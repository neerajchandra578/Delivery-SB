package com.parcel.delivery.repo;

import com.parcel.delivery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    @Query(value = "select * from user where user_name = :userName and password = :password",nativeQuery = true)
    Optional<User> findByUserNamePassword(String userName, String password);

    @Query(value = "select * from user where is_active = false",nativeQuery = true)
    List<User> findAvailableUsers();

    @Query(value = "select count(*) from user",nativeQuery = true)
    Integer findTotalUsers();


}
