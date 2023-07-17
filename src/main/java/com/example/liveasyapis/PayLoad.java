package com.example.liveasyapis;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.util.Date;
import java.util.Optional;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
@Entity
public class PayLoad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer loadId ;
    String loadingPoint ;
    String unloadingPoint ;
    String productType ;
    String truckType ;
    String noOfTrucks ;
    String weight ;
    String comment ;
    String shipperId ;
    Date date ;

}