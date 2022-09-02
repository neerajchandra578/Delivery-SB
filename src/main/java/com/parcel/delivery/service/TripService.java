package com.parcel.delivery.service;

import com.parcel.delivery.error.DepartmentNotFound;
import com.parcel.delivery.model.*;
import com.parcel.delivery.repo.TripRepo;
import com.parcel.delivery.repo.UserRepo;
import com.parcel.delivery.repo.VechileRepo;
import com.parcel.delivery.repo.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TripService {

    @Autowired
    private TripRepo tripRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private VechileRepo vechileRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private VechileService vechileService;


    public Trip saveTrip(Trip department) {
        return tripRepo.save(department);
    }


    public List<Trip> fetchTripList() {
        return tripRepo.findAll();
    }


    public Trip fetchvById(Long departmentId) throws DepartmentNotFound {
        Optional<Trip> department =
                tripRepo.findById(departmentId);

        if(!department.isPresent()) {
            throw new DepartmentNotFound("Department Not Available");
        }

        return  department.get();
    }

    public Trip endTrip(Long departmentId) throws DepartmentNotFound {
        Optional<Trip> department =
                tripRepo.findById(departmentId);

        Trip trp = department.get();
        User cUser = trp.getUserId();
        Vechile cVechile = trp.getVechileId();
        userService.updateUserActiveStatus(cUser,false);
        vechileService.updateVechileActiveStatus(cVechile,false);
        trp.setActive(false);
        tripRepo.save(trp);

        return  tripRepo.save(trp);
    }

    public List<Trip> fetchTripByUserId(long departmentId) throws DepartmentNotFound {
        List<Trip> department =
                tripRepo.findTripByUserId(departmentId);

/*        if(!department.isPresent()) {
            throw new DepartmentNotFound("Department Not Available");
        }*/

        return  department;
    }


    public Trip saveTripFromMob(TripRequestBody department) {

        Trip newTrans = new Trip();
        long userId = Long.valueOf(department.getUserId());
        User cUser = userRepo.getById(userId);
        newTrans.setUserId(cUser);

        long vechileId = Long.valueOf(department.getVechileId());
        Vechile cVechile = vechileRepo.getById(vechileId);
        newTrans.setVechileId(cVechile);


        String sourcePlace = department.getSourcePlace();
        String destinationPlace = department.getDestinationPlace();
        int parcelWeight = department.getParcelWeight();

        newTrans.setLoadedParcelWeight(parcelWeight);
        newTrans.setCurrentWeight(parcelWeight);
        newTrans.setSourcePlace(sourcePlace);
        newTrans.setDestinationPlace(destinationPlace);

        userService.updateUserActiveStatus(cUser,true);
        vechileService.updateVechileActiveStatus(cVechile,true);

        newTrans.setActive(true);

        return tripRepo.save(newTrans);
    }

    public void deleteTripById(Long departmentId) {
        tripRepo.deleteById(departmentId);
    }


    public Trip updateTrip(Long departmentId, Trip department) {
        Trip depDB = tripRepo.findById(departmentId).get();

        if(Objects.nonNull(department.getSourcePlace()) &&
                !"".equalsIgnoreCase(department.getSourcePlace())) {
            depDB.setSourcePlace(department.getSourcePlace());
        }
        if(Objects.nonNull(department.getDestinationPlace()) &&
                !"".equalsIgnoreCase(department.getDestinationPlace())) {
            depDB.setDestinationPlace(department.getDestinationPlace());
        }
        if(Objects.nonNull(department.getLoadedParcelWeight()) ) {
            depDB.setLoadedParcelWeight(department.getLoadedParcelWeight());
        }

        return tripRepo.save(depDB);
    }

    public Trip updateAmountAndWeight(Trip trip,int amount,int weight,String debitCrType,String loadUnloadType){

        int currentAmount = trip.getTotalAmount();
        int currentWeight = trip.getCurrentWeight();

        if(debitCrType.equalsIgnoreCase("Debit")){
            currentAmount = currentAmount-amount;
        }else{
            currentAmount = currentAmount+amount;
        }

        if(loadUnloadType.equalsIgnoreCase("Load- Drop Packets")){
            currentWeight = currentWeight-weight;
        }else{
            currentWeight = currentWeight+weight;
        }

        trip.setCurrentWeight(currentWeight);
        trip.setTotalAmount(currentAmount);


        return tripRepo.save(trip);
    }

}
