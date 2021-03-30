package com.starwars.demo.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.demo.dtos.CharacterResponseDto;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PersonajesRepository implements  IPersonajesRepository{
    @Override
    public List<CharacterResponseDto> searchCharacters(String name) {
        List<CharacterResponseDto> characters = null;
        characters = loadDataBase();
        List<CharacterResponseDto> result = null;

        if(characters != null){
            var item = characters.stream()
                    .filter(character -> character.getName().contains(name));
                result = item.collect(Collectors.toUnmodifiableList());;

        }
        return result;
    }

    private List<CharacterResponseDto> loadDataBase() {
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:starwars.json");
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        ObjectMapper om = new ObjectMapper();
        TypeReference<List<CharacterResponseDto>> typeRef = new TypeReference<>(){};
        List<CharacterResponseDto> characters = null;

        try{
            characters = om.readValue(file, typeRef);
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return characters;
    }
}
