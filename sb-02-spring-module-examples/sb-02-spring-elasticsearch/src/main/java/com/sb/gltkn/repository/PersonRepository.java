package com.sb.gltkn.repository;

import com.sb.gltkn.entity.Person;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends ElasticsearchRepository<Person, String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    List<Person> getPersonListBySearch(String search);
}
