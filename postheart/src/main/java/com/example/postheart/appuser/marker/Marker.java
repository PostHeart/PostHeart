package com.example.postheart.appuser.marker;

import com.example.postheart.appuser.AppUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Marker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long markerid;
    //private String imgURL;
    //private String text;
    private double lat;
    private double lng;
    //private String title;
    @JsonIgnore
    @ManyToOne //(fetch = FetchType.LAZY)
    @JoinColumn(name = "appUserId")
    private AppUser appUser;
    public Marker(double lat, double lng, AppUser appUser) {
        this.lat = lat;
        this.lng = lng;
        this.appUser = appUser;
        
    }
    public Marker(){
        
    }

}
