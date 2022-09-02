package com.parcel.delivery.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "trip_trans")
@Table(name = "trip_trans")
@EqualsAndHashCode(callSuper = true)
public class Transaction extends BaseEntity{


    @SequenceGenerator(
            name = "trans_sequence",
            sequenceName = "trip_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "trans_sequence"
    )
    @Id
    private long id;

    /*@ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "tripId",
            referencedColumnName = "tripId"
    )*/
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(optional=false)
    @JoinColumn(name = "trip_id")
    private Trip tripId;

/*    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    private User userId;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "vechile_id",
            referencedColumnName = "id"
    )
    private Vechile vechileId;*/

    private int amount;

    private String amountPaidMode;

    private int luggageUnloadedWeight;

    private int subQuantity;

    private String amountTrasactionType;

    private String vendorName;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(optional=true)
    @JoinColumn(name = "vendor")
    private Vendor vendor;

    private String loadUnloadType;
    private String debitCreditType;


}
