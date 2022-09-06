package com.person.wefin.service;

import com.person.wefin.controller.dto.PersonDTO;
import com.person.wefin.model.Person;
import com.person.wefin.model.TipoIdentificador;
import com.person.wefin.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.net.URI;
import java.util.stream.Collectors;

@Service
public class PersonServiceImp implements PersonService {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private ModelMapper mapper;

    public Page<PersonDTO> getAllPersons(Pageable pageable) {
        Page<Person> products = repository.findAll(pageable);
        return new PageImpl<>(products.stream().map(person -> mapper.map(person, PersonDTO.class)).collect(Collectors.toList()));
    }

    public ResponseEntity<PersonDTO> storePerson(PersonDTO form, UriComponentsBuilder uriBuilder) {

        if (!repository.findById(form.getIdentificador()).isPresent()) {
            Person person = mapper.map(form, Person.class);
            TipoIdentificador tipo = person.personVerification();
            person.setTipoIdentificador(tipo);
            repository.save(person);

            URI uri = uriBuilder.path("/person/{id}").buildAndExpand(person.getIdentificador()).toUri();
            return ResponseEntity.created(uri).body(mapper.map(person, PersonDTO.class));
        }
        throw new KeyAlreadyExistsException();

    }

}
