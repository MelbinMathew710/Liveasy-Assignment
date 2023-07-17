package com.example.liveasyapis.Dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {

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
