package com.example.inicial1.services;

import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PersonaServices implements BaseService<Persona>{
@Autowired
    private PersonaRepository personaRepository;

    @Override
    @Transactional
    public List<Persona> findAll() throws Exception {
        try {
                List<Persona> entities = personaRepository.findAll();
                return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona findById(Long id) throws Exception {
        try {
                Optional<Persona> entityOptional = personaRepository.findById(id);
                return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona save(Persona entity) throws Exception {
        try {
                entity = personaRepository.save(entity);
                return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Persona update(Long id, Persona entity) throws Exception {
        try {
                Optional<Persona> entityOptional = personaRepository.findById(id);
                Persona persona = entityOptional.get();
                persona = personaRepository.save(entity);
                return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
                if (personaRepository.existsById(id)){
                    personaRepository.deleteById(id);
                    return true;
                }else {
                    throw new Exception();
                }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public void saveInitialData() {
        Persona p1 = Persona.builder().nombre("Pepe").apellido("Argento").build();
        Persona p2 = Persona.builder().nombre("Maria").apellido("Hernandez").build();
        Persona p3 = Persona.builder().nombre("Lupeta").apellido("Oregon").build();
        Persona p4 = Persona.builder().nombre("Monica").apellido("Calderon").build();
        Persona p5 = Persona.builder().nombre("Roberto").apellido("Villanueva").build();

        personaRepository.save(p1);
        personaRepository.save(p2);
        personaRepository.save(p3);
        personaRepository.save(p4);
        personaRepository.save(p5);
    }
}
