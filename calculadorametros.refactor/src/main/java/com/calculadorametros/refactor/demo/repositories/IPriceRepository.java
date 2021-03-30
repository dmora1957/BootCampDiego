package com.calculadorametros.refactor.demo.repositories;

import com.calculadorametros.refactor.demo.dto.PriceDto;

public interface IPriceRepository {
    PriceDto findPriceByLocation(String location);
}
