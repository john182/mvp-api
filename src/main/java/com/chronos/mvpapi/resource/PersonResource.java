package com.chronos.mvpapi.resource;

import com.chronos.mvpapi.event.ResourceCreatEvent;
import com.chronos.mvpapi.model.Person;
import com.chronos.mvpapi.repository.PersonRepository;
import com.chronos.mvpapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/people")
public class PersonResource {

    @Autowired
    private PersonService service;
    @Autowired
    private PersonRepository repository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping
    public ResponseEntity<Person> create(@Valid @RequestBody Person person, HttpServletResponse response) {
        Person pessoaSalva = service.salve(person);
        publisher.publishEvent(new ResourceCreatEvent(this, response, pessoaSalva.getUuid()));
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Person> buscarPeloCodigo(@PathVariable String uuid) {
        Optional<Person> person = repository.findById(uuid);
        return person.isPresent() ? ResponseEntity.ok(person.get()) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable String uuid) {
        repository.deleteById(uuid);
    }


    @PutMapping("/{uuid}")
    public ResponseEntity<Person> atualizar(@PathVariable String uuid, @Valid @RequestBody Person person) {
        Person pessoaSalve = service.update(uuid, person);
        return ResponseEntity.ok(pessoaSalve);
    }


}
