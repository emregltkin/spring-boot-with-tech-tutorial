package com.sb.gltkn.controller;

import com.sb.gltkn.dto.PetDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Api(value = "Pet API Dokümantasyonu")
public class PetController {

    private List<PetDto> petDtoList = new ArrayList<>();

    @PostConstruct
    public void init(){
        petDtoList.add(new PetDto(1, "PetA", new Date()));
    }


    @PostMapping
    @ApiOperation(value = "Yeni bir Pet oluşturma fonksiyonu", notes = "Oluşturma işlemi kritik bir işlemdir.")
    public ResponseEntity<PetDto> create(@RequestBody @ApiParam(value = "animal") PetDto petDto) {
        petDtoList.add(petDto);
        return ResponseEntity.ok(petDto);
    }

    @GetMapping
    @ApiOperation(value = "Pet listesi fonksiyonu", notes = "Tüm pet'leri getirir.")
    public ResponseEntity<List<PetDto>> getAllPerson() {
        return ResponseEntity.ok(petDtoList);
    }
}
