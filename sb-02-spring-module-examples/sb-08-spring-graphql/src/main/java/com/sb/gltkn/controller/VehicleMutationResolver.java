package com.sb.gltkn.controller;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.sb.gltkn.dto.VehicleDto;
import com.sb.gltkn.entity.Vehicle;
import com.sb.gltkn.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class VehicleMutationResolver implements GraphQLMutationResolver {

    private final VehicleRepository vehicleRepository;

    public Vehicle createVehicle(VehicleDto vehicleDto){
        return vehicleRepository.save(dtoToEntity(vehicleDto));
    }

    private Vehicle dtoToEntity(VehicleDto vehicleDto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrandName(vehicleDto.getBrandName());
        vehicle.setModelCode(vehicleDto.getModelCode());
        vehicle.setType(vehicleDto.getType());
        vehicle.setLaunchDate(new Date());
        return vehicle;
    }
}
