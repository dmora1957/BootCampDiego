package com.starwars.demo.services;

import com.starwars.demo.dtos.CharacterResponseDto;
import com.starwars.demo.repositories.PersonajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharactersService {

    @Autowired
    private PersonajesRepository repository;

    public List<CharacterResponseDto> getCharacters(String name)
    {
        return repository.searchCharacters(name);
    }
}
