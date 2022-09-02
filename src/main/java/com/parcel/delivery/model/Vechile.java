package com.parcel.delivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="vechile",
        uniqueConstraints = @UniqueConstraint(
                name = "vechile_reg_no_unique",
                columnNames = "vechile_reg_no"
        ))
@EqualsAndHashCode(callSuper = true)
public class Vechile extends BaseEntity {

    @SequenceGenerator(
            name = "vechile_sequence",
            sequenceName = "vechile_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vechile_sequence"
    )
    @Id
    private long id;

    private String vechileName;

    @Column(name = "vechile_reg_no")
    private String vechileRegNumber;

    private boolean isActive;
/*    @OneToMany(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "vechileId")
    private Set<Trip> trip;*/

}
