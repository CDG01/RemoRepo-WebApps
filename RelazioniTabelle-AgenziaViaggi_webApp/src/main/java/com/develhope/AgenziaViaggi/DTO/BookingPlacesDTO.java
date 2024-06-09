package com.develhope.AgenziaViaggi.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class BookingPlacesDTO {
    @NotNull
    private Long userID;
    @NotEmpty
    @NotNull
    private List<@NotNull Long> placesID;

    public BookingPlacesDTO(Long userID, List<@NotNull Long> placesID) {
        this.userID = userID;
        this.placesID = placesID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public List<Long> getPlacesID() {
        return placesID;
    }

    public void setPlacesID(List<Long> placesID) {
        this.placesID = placesID;
    }
}
