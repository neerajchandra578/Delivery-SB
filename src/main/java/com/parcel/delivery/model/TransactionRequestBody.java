package com.parcel.delivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequestBody {

    private long partyId;
    private String otherPartyName;
    private String quantity;
    private String subQuantity;
    private String paymentMode;
    private String amount;
    private String loadUnloadType;
    private String debitCreditType;
    private String tripId;
}
