package com.parcel.delivery.repo;

import com.parcel.delivery.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepo extends JpaRepository<Vendor,Long> {

    @Query(value = "select count(*) from vendor",nativeQuery = true)
    Integer findTotalVendors();
}
