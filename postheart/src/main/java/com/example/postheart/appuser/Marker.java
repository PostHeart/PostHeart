package com.example.postheart.appuser;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Long id;
    private String imgURL;
    private String text;
    private double lat;
    private double lng;
    private String title;
    @ManyToOne
    private AppUser appUser;

}
