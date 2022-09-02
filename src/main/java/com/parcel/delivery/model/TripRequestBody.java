package com.parcel.delivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripRequestBody {
    long userId;
    long vechileId;
    String sourcePlace;
    String destinationPlace;
    int parcelWeight;
}
