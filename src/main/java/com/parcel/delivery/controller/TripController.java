package com.parcel.delivery.controller;

import com.parcel.delivery.error.DepartmentNotFound;
import com.parcel.delivery.model.*;
import com.parcel.delivery.service.TripService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins={"http://localhost:3000", "http://3.16.158.189:3000"})
@RestController
public class TripController {
    @Autowired
    private TripService tripService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(TripController.class);

    @PostMapping("/trips")
    public Trip saveTrip(@RequestBody Trip department) {
        LOGGER.info("Inside saveTrip of TripController");
        return tripService.saveTrip(department);
    }

    @GetMapping("/trips")
    public List<Trip> fetchTripList() {
        LOGGER.info("Inside fetchTripList of TripController");
        return tripService.fetchTripList();
    }

    @GetMapping("/trips/{id}")
    public Trip fetchTripById(@PathVariable("id") Long departmentId)
            throws DepartmentNotFound {
        return tripService.fetchvById(departmentId);
    }

    @GetMapping("/trips/endTrip/{id}")
    public Trip endTrip(@PathVariable("id") Long departmentId)
            throws DepartmentNotFound {
        return tripService.endTrip(departmentId);
    }

    @GetMapping("/trips/byUser/{id}")
    public List<Trip> fetchTripByUserId(@PathVariable("id") long departmentId)
            throws DepartmentNotFound {
        return tripService.fetchTripByUserId(departmentId);
    }

    @PostMapping("/trip/mob")
    public Trip saveTransaction(@Valid @RequestBody TripRequestBody department) {
        LOGGER.info("Inside save Transaction of TransactionController");

        return tripService.saveTripFromMob(department);
    }


    @DeleteMapping("/trips/{id}")
    public String deleteTripById(@PathVariable("id") Long departmentId) {
        tripService.deleteTripById(departmentId);
        return "Trip deleted Successfully!!";
    }

    @PutMapping("/trips/{id}")
    public Trip updateTrip(@PathVariable("id") Long departmentId,
                                 @RequestBody Trip department) {
        return tripService.updateTrip(departmentId,department);
    }
}
