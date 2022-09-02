package com.parcel.delivery.repo;

import com.parcel.delivery.model.User;
import com.parcel.delivery.model.Vechile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VechileRepo extends JpaRepository<Vechile,Long> {

    @Query(value = "select * from vechile where is_active = false",nativeQuery = true)
    List<Vechile> findAvailableVechiles();

    @Query(value = "select count(*) from vechile",nativeQuery = true)
    Integer findTotalVechile();
}
