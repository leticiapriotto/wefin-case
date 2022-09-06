package com.person.wefin.service;

import com.person.wefin.controller.dto.PersonDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface PersonService {

    Page<PersonDTO> getAllPersons(Pageable pageable);

    ResponseEntity<PersonDTO> storePerson(PersonDTO person, UriComponentsBuilder uriBuilder);

}
