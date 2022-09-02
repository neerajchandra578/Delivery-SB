package com.parcel.delivery.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "trip")
@Table(name = "trip")
@EqualsAndHashCode(callSuper = true)
public class Trip extends BaseEntity{

    @SequenceGenerator(
            name = "trip_sequence",
            sequenceName = "trip_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "trip_sequence"
    )
    @Id
    private Long tripId;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(optional=false)
    @JoinColumn(name = "user_id")
    private User userId;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(optional=false)
    @JoinColumn(name = "vechile_id")
    private Vechile vechileId;

    private String sourcePlace;

    private String destinationPlace;

    private int loadedParcelWeight;

    private int currentWeight;

    private int totalAmount;

    private boolean isActive;
   // private Date createdAt;

    /*@OneToMany(
            mappedBy = "id"
    )*/
    /*@OneToMany
    @JoinColumn(name = "id")*/
    /*@OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "transactions",
            referencedColumnName = "tripId"
    )*/
/*    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(cascade = CascadeType.ALL,mappedBy="tripId")
   // @JoinColumn(name = "trip_id")
    private List<Transaction> transactions;*/
}
