package com.calculadorametros.refactor.demo.repositories;

import com.calculadorametros.refactor.demo.dto.PriceDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Repository
public class PriceRepository implements IPriceRepository{
    @Override
    public PriceDto findPriceByLocation(String location) {
        List<PriceDto> pricesDtos = null;
        pricesDtos = loadDataBase();
        PriceDto result = null;

        if(pricesDtos != null){
            Optional<PriceDto> item = pricesDtos.stream()
                    .filter(priceDto -> priceDto.getLocation().equals(location))
                    .findFirst();
            if(item.isPresent())
            {
                result = item.get();
            }
        }
        return result;
    }

    private List<PriceDto> loadDataBase() {
        File file = null;
    try{
        file = ResourceUtils.getFile("classpath:prices.json");
    }catch (Exception e)
    {
        e.printStackTrace();
    }

    ObjectMapper om = new ObjectMapper();
    TypeReference<List<PriceDto>> typeRef = new TypeReference<>(){};
    List<PriceDto> pricesDto = null;

    try{
        pricesDto = om.readValue(file, typeRef);
    }catch (Exception ex)
    {
        ex.printStackTrace();
    }
            return pricesDto;
    }
}
