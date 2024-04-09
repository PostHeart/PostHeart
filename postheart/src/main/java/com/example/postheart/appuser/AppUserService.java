package com.example.postheart.appuser;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.postheart.registration.token.ConfirmationToken;
import com.example.postheart.registration.token.ConfirmationTokenService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService{
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationtokenService; 
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email %s not found", email)));
    }

    public String signUpUser(AppUser appUser) {
        boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
        if(userExists){
            throw new IllegalStateException("Email already taken");
        }
        String encodedPass = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPass);
        appUserRepository.save(appUser);
        
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationtoken = new ConfirmationToken(
            token,
            LocalDateTime.now(),
            LocalDateTime.now().plusMinutes(15),
            appUser
        );
        confirmationtokenService.saveConfirmationToken(confirmationtoken);
        
       return token;
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }

    public List<Marker> getUserMarkers(String email) {
        AppUser user = appUserRepository.findByEmail(email)
            .orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + email));
        return user.getMarkers();
    }

    
    public Marker addUserMarker(String email, Marker marker) {
        AppUser user = appUserRepository.findByEmail(email)
            .orElseThrow(() -> new IllegalArgumentException("Invalid user email: " + email));
        user.getMarkers().add(marker);
        appUserRepository.save(user);
        return marker;
    }
}
