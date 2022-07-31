package com.sb.gltkn.api;

import com.sb.gltkn.entity.Car;
import com.sb.gltkn.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CarController {

    private final CarRepository carRepository;

    @GetMapping("/{id}")
    public Car getCar(@PathVariable Long id) {
        return carRepository.findById(id).get();
    }

    @GetMapping
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @PostMapping
    public Car save(@RequestBody Car car) {
        return carRepository.save(car);
    }
}
