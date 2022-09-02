package com.parcel.delivery.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardModel {

    int totalUsers;
    int totalVechiles;
    int totalTrips;
    int totalVendors;

}
