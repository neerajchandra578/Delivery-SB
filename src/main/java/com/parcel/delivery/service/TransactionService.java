package com.parcel.delivery.service;

import com.parcel.delivery.error.DepartmentNotFound;
import com.parcel.delivery.model.Transaction;
import com.parcel.delivery.model.TransactionRequestBody;
import com.parcel.delivery.model.Trip;
import com.parcel.delivery.model.Vechile;
import com.parcel.delivery.repo.TransactionRepo;
import com.parcel.delivery.repo.TripRepo;
import com.parcel.delivery.repo.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private TripRepo tripRepo;

    @Autowired
    private VendorRepo vendorRepo;

    @Autowired
    private TripService tripService;


    public Transaction saveTransaction(Transaction department) {
        return transactionRepo.save(department);
    }

    public Transaction saveTransactionFromMob(TransactionRequestBody department) {

        Transaction newTrans = new Transaction();
        long tripId = Long.valueOf(department.getTripId());

        Trip trip = tripRepo.getById(tripId);
        newTrans.setTripId(trip);
        String otherPartyName = department.getOtherPartyName();

        if(otherPartyName.isEmpty()){
            long otherPartyId = department.getPartyId();
            newTrans.setVendor(vendorRepo.getById(otherPartyId));
        }else {
            newTrans.setVendorName(otherPartyName);
        }

        String quantity = department.getQuantity();
        String subQuantity = department.getSubQuantity();
        String payMentMode = department.getPaymentMode();
        String amount = department.getAmount();
        String loadUnloadType = department.getLoadUnloadType();
        String debitCreditType = department.getDebitCreditType();
        newTrans.setLuggageUnloadedWeight(Integer.valueOf(quantity));
        if(!subQuantity.isEmpty()){
            newTrans.setSubQuantity(Integer.valueOf(subQuantity));
        }

        newTrans.setAmountPaidMode(payMentMode);
        newTrans.setAmount(Integer.valueOf(amount));
        newTrans.setLoadUnloadType(loadUnloadType);
        newTrans.setDebitCreditType(debitCreditType);

        tripService.updateAmountAndWeight(trip,Integer.valueOf(amount),Integer.valueOf(quantity),
                debitCreditType,loadUnloadType);


        return transactionRepo.save(newTrans);
    }


    public List<Transaction> fetchTransactionList() {
        return transactionRepo.findAll();
    }

    public List<Transaction> fetchTransactionListByTripId(long id) {
        return transactionRepo.findTransactionsByTripId(id);
    }


    public Transaction fetchvById(Long departmentId) throws DepartmentNotFound {
        Optional<Transaction> department =
                transactionRepo.findById(departmentId);

        if(!department.isPresent()) {
            throw new DepartmentNotFound("Department Not Available");
        }

        return  department.get();
    }


    public void deleteTransactionById(Long departmentId) {
        transactionRepo.deleteById(departmentId);
    }


    public Transaction updateTransaction(Long departmentId, Transaction department) {
        Transaction depDB = transactionRepo.findById(departmentId).get();

/*        if(Objects.nonNull(department.getVechileName()) &&
                !"".equalsIgnoreCase(department.getVechileName())) {
            depDB.setVechileName(department.getVechileName());
        }*/

/*        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }*/

        return transactionRepo.save(depDB);
    }

}
