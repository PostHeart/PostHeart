package com.example.postheart.appuser;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/user")
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/{id}/markers")
    public ResponseEntity<List<Marker>> getUserMarkers(@PathVariable String email) {
        List<Marker> markers = appUserService.getUserMarkers(email);
        return ResponseEntity.ok(markers);
    }

    @PostMapping("/{id}/markers")
    public ResponseEntity<Marker> addUserMarker(@PathVariable String email, @RequestBody Marker marker) {
        Marker addedMarker = appUserService.addUserMarker(email, marker);
        return ResponseEntity.ok(addedMarker);
    }
}
