package com.challenge.demo.repos;

import com.challenge.demo.models.PersonaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepo extends CrudRepository<PersonaModel,Integer> {
}
