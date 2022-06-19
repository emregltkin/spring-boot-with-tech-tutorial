package com.sb.gltkn.service.impl;

import com.sb.gltkn.dto.PersonDto;
import com.sb.gltkn.entity.Address;
import com.sb.gltkn.entity.Person;
import com.sb.gltkn.repository.AddressRepository;
import com.sb.gltkn.repository.PersonRepository;
import com.sb.gltkn.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public PersonDto save(PersonDto personDto) {
        Assert.notNull(personDto.getName(), "Ad alani zorunludur!");

        Person person = new Person();
        person.setName(personDto.getName());
        person.setSurname(personDto.getSurname());
        final Person personDb = personRepository.save(person);

        List<Address> addressList = new ArrayList<>();
        personDto.getAddresses().forEach(item -> {
            Address address = new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.OTHER);
            address.setActive(true);
            address.setPerson(personDb);
            addressList.add(address);
        });
        addressRepository.saveAll(addressList);
        personDto.setId(personDb.getId());
        return personDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<PersonDto> getAll() {
        List<Person> personList = personRepository.findAll();
        List<PersonDto> personDtoList = new ArrayList<>();

        personList.forEach(item -> {
            PersonDto dto = new PersonDto();
            dto.setId(item.getId());
            dto.setName(item.getName());
            dto.setSurname(item.getSurname());
            dto.setAddresses(item.getAddresses().stream()
                    .map(Address::getAddress)
                    .collect(Collectors.toList()));
            personDtoList.add(dto);
        });
        return personDtoList;
    }

    @Override
    public Page<PersonDto> getAll(Pageable pageable) {
        return null;
    }
}
