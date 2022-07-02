package com.sb.gltkn.api;

import com.sb.gltkn.dto.CarDto;
import com.sb.gltkn.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarApi {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<CarDto> getCar(@RequestParam String name) {
        return ResponseEntity.ok(carService.getCar(name));
    }

    /**
     @ExceptionHandler({EntityNotfoundException.class})
     public String entityNotFound() {
        return "Record not found";
     }
     **/
}
