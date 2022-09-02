package com.parcel.delivery.repo;


import com.parcel.delivery.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TripRepo extends JpaRepository<Trip,Long> {
    @Query("select trp from trip trp where trp.userId.id = :tripId")
    List<Trip> findTripByUserId(long tripId);

    @Query(value = "select count(*) from trip",nativeQuery = true)
    Integer findTotalTrips();
}
