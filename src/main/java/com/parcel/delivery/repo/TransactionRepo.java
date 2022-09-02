package com.parcel.delivery.repo;

import com.parcel.delivery.model.Transaction;
import com.parcel.delivery.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction,Long> {

    @Query("select trp from trip_trans trp where trp.tripId.tripId = :tripId")
    List<Transaction> findTransactionsByTripId(long tripId);
}
