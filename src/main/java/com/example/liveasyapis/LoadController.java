package com.example.liveasyapis;

import com.example.liveasyapis.Dtos.RequestDto;
import com.example.liveasyapis.Dtos.ResponseDto;
import com.example.liveasyapis.Exceptions.LoadNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Load")
public class LoadController {

    @Autowired
    LoadService loadService ;

    @PostMapping("/add_load")
    public ResponseEntity<String> add_load(@RequestBody RequestDto requestDto){
        loadService.add_load(requestDto) ;
        return new ResponseEntity<>("Loads details added successfully", HttpStatus.OK) ;
    }

    @GetMapping("/get_loads")
    public ResponseEntity<?> get_loads(@RequestParam String shipperId){
        try {
            List<ResponseDto> payLoads = loadService.get_loads(shipperId);
            return new ResponseEntity<>(payLoads, HttpStatus.OK);
        }
        catch(LoadNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("get_load/{loadId}")
    public ResponseEntity<?> get_load(@PathVariable Integer loadId){
        try {
            ResponseDto payLoad = loadService.get_load(loadId) ;
            return new ResponseEntity<>(payLoad, HttpStatus.OK);
        }
        catch(LoadNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("update_load/{loadId}")
    public ResponseEntity<String> update_load(@PathVariable Integer loadId, @RequestBody RequestDto requestDto){
        try{
            loadService.update_load(loadId, requestDto) ;
            return new ResponseEntity<>("Load updated successfully", HttpStatus.OK);
        }
        catch(LoadNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete_load/{loadId}")
    public ResponseEntity<String> delete_load(@PathVariable Integer loadId){
        try{
            loadService.delete_load(loadId) ;
            return new ResponseEntity<>("Load deleted successfully", HttpStatus.OK);
        }
        catch(LoadNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
