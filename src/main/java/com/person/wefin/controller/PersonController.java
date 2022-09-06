package com.person.wefin.controller;

import com.person.wefin.controller.dto.PersonDTO;
import com.person.wefin.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonServiceImp service;

    @GetMapping
    public Page<PersonDTO> getAllPersons(@PageableDefault(sort = "name", page = 0, size = 5) Pageable pageable) {
        return service.getAllPersons(pageable);
    }

    @PostMapping
    public ResponseEntity<PersonDTO> storePerson(@RequestBody PersonDTO form, UriComponentsBuilder uriBuilder) {
        return service.storePerson(form, uriBuilder);
    }

}