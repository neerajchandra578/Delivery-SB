package com.parcel.delivery.service;

import com.parcel.delivery.model.DashboardModel;
import com.parcel.delivery.repo.TripRepo;
import com.parcel.delivery.repo.UserRepo;
import com.parcel.delivery.repo.VechileRepo;
import com.parcel.delivery.repo.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    VechileRepo vechileRepo;

    @Autowired
    TripRepo tripRepo;

    @Autowired
    VendorRepo vendorRepo;

    public DashboardModel getDashboardView(){

        int totalUser = userRepo.findTotalUsers();
        int totalVechile = vechileRepo.findTotalVechile();
        int totalTrip = tripRepo.findTotalTrips();
        int totalVendors = vendorRepo.findTotalVendors();

        DashboardModel dm = new DashboardModel();
        dm.setTotalTrips(totalTrip);
        dm.setTotalUsers(totalUser);
        dm.setTotalVechiles(totalVechile);
        dm.setTotalVendors(totalVendors);
        return dm;

    }
}
