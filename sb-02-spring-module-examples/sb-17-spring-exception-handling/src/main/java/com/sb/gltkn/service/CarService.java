package com.sb.gltkn.service;

import com.sb.gltkn.dto.CarDto;
import com.sb.gltkn.exception.EntityNotfoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private static List<CarDto> carList = new ArrayList<>();

    @PostConstruct
    public void init() {
        carList.add(new CarDto("Car1", "Brand1"));
        carList.add(new CarDto("Car2", "Brand2"));
        carList.add(new CarDto("Car3", "Brand3"));
    }

    public CarDto getCar(String name) {
        if (name.startsWith("1")) {
            throw new IllegalArgumentException();
        }
        return carList.stream().filter(item -> item.getName().equals(name)).findFirst()
                .orElseThrow(() -> new EntityNotfoundException(name));
    }
}
