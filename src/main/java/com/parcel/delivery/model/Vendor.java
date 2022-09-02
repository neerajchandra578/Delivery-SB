package com.parcel.delivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="vendor")
@Table(name ="vendor")
@EqualsAndHashCode(callSuper = true)
public class Vendor extends BaseEntity {
    @SequenceGenerator(
            name = "vendor_sequence",
            sequenceName = "vendor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vendor_sequence"
    )
    @Id
    private long id;

    private String vendorName;

    private String vendorAddress;
}
