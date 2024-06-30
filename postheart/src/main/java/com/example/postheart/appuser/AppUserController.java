package com.example.postheart.appuser;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.postheart.appuser.marker.Marker;
import com.example.postheart.appuser.marker.MarkerRepository;
import com.example.postheart.appuser.marker.MarkerRequest;

@RestController
@RequestMapping(path = "api/v1/user")
public class AppUserController {

    private final AppUserService appUserService;
    private final MarkerRepository markerRepository;
    public AppUserController(AppUserService appUserService, MarkerRepository markerRepository) {
        this.appUserService = appUserService;
        this.markerRepository = markerRepository;
    }

    @GetMapping("/{email}/markers")
    public ResponseEntity<List<Marker>> getUserMarkers(@PathVariable String email) {
        List<Marker> markers = appUserService.getMarkersService(email);
        return ResponseEntity.ok(markers);
    }
    
    @PostMapping("/{email}/markers")
    public ResponseEntity<Marker> addUserMarker(@PathVariable String email, @RequestBody MarkerRequest request) {
        Marker marker = new Marker(request.getLat(), request.getLng(), appUserService.loadUserByUsername(email));
        appUserService.addUserMarker(email, marker);
        
        return ResponseEntity.ok(marker);
    }
}
