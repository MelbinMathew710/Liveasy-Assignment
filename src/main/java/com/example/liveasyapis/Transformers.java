package com.example.liveasyapis;

import com.example.liveasyapis.Dtos.RequestDto;
import com.example.liveasyapis.Dtos.ResponseDto;

public class Transformers {

    public static PayLoad dtoToEntity(RequestDto requestDto){

        PayLoad payLoadObj = PayLoad.builder()
                .loadingPoint(requestDto.getLoadingPoint())
                .unloadingPoint(requestDto.getUnloadingPoint())
                .productType(requestDto.getProductType())
                .truckType(requestDto.getTruckType())
                .noOfTrucks(requestDto.getNoOfTrucks())
                .weight(requestDto.getWeight())
                .comment(requestDto.getComment())
                .shipperId(requestDto.getShipperId())
                .date(requestDto.getDate())
                .build() ;

        return payLoadObj ;
    }

    public static ResponseDto entityToDto(PayLoad payLoadObj){

        ResponseDto responseDto = ResponseDto.builder()
                .loadingPoint(payLoadObj.getLoadingPoint())
                .unloadingPoint(payLoadObj.getUnloadingPoint())
                .productType(payLoadObj.getProductType())
                .truckType(payLoadObj.getTruckType())
                .noOfTrucks(payLoadObj.getNoOfTrucks())
                .weight(payLoadObj.getWeight())
//                .comment(payLoadObj.getComment())
                .shipperId(payLoadObj.getShipperId())
                .date(payLoadObj.getDate())
                .build() ;

        return responseDto ;
    }

}