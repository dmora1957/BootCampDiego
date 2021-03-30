package com.starwars.demo.repositories;

import com.starwars.demo.dtos.CharacterResponseDto;

import java.util.List;

public interface IPersonajesRepository {

    public List<CharacterResponseDto> searchCharacters(String name);
}
