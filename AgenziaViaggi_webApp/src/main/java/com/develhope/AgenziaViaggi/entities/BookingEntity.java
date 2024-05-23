package com.develhope.AgenziaViaggi.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "bookings")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(joinColumns = @JoinColumn(name = "bookings_id"),
            inverseJoinColumns = @JoinColumn(name = "places_id"))
    private List<PlaceEntity> places;

    public BookingEntity(){}
    public BookingEntity(UserEntity user, List<PlaceEntity> places) {
        this.user = user;
        this.places = places;
    }
}
