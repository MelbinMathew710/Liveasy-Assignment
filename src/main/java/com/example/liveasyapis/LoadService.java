package com.example.liveasyapis;

import com.example.liveasyapis.Dtos.RequestDto;
import com.example.liveasyapis.Dtos.ResponseDto;
import com.example.liveasyapis.Exceptions.LoadNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoadService {

    @Autowired
    LoadRepository loadRepository ;

    public void add_load(RequestDto requestDto) {
        PayLoad payLoadObj = Transformers.dtoToEntity(requestDto) ;
        loadRepository.save(payLoadObj) ;
    }

    public List<ResponseDto> get_loads(String shipperId) {

        List<PayLoad> result = loadRepository.findByShipperId(shipperId) ;

        if(result.size() == 0){
            throw new LoadNotFoundException() ;
        }

        List<ResponseDto> payLoads = new ArrayList<>() ;

        for(PayLoad p : result){
             payLoads.add( Transformers.entityToDto(p) ) ;
        }

        return payLoads ;
    }

    public ResponseDto get_load(Integer loadId) {

        Optional<PayLoad> result = loadRepository.findById(loadId) ;

        if(result.isEmpty()){
            throw new LoadNotFoundException() ;
        }

        ResponseDto load = Transformers.entityToDto(result.get()) ;
        return load ;
    }

    public void update_load(Integer loadId, RequestDto requestDto) {

        Optional<PayLoad> result = loadRepository.findById(loadId) ;

        if(result.isEmpty()){
            throw new LoadNotFoundException() ;
        }

        PayLoad load = result.get() ;

        load.setLoadingPoint(requestDto.getLoadingPoint());
        load.setUnloadingPoint(requestDto.getUnloadingPoint());
        load.setProductType(requestDto.getProductType());
        load.setTruckType(requestDto.getTruckType());
        load.setNoOfTrucks(requestDto.getNoOfTrucks());
        load.setWeight(requestDto.getWeight());
        load.setComment(requestDto.getComment());
        load.setDate(requestDto.getDate());

        loadRepository.save(load);
    }

    public void delete_load(Integer loadId) {

        Optional<PayLoad> load = loadRepository.findById(loadId) ;

        if(load.isEmpty()){
            throw new LoadNotFoundException() ;
        }

        loadRepository.deleteById(loadId) ;
    }

}