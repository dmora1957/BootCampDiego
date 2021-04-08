package com.desafioproductos.demo.helpers;

import com.desafioproductos.demo.dtos.FilterDto;
import com.desafioproductos.demo.exceptions.FilterNotValidException;
import com.desafioproductos.demo.exceptions.GenericException;

public class FilterValidator {

    /**
     * Validates filter
     * @param filter (FilterDto) object with the filter values
     * @throws FilterNotValidException with filter validation error
     */
    public static void validateFilter (FilterDto filter) throws GenericException{
        validateFilterQuantity(filter);
        validatePrestige(filter.getPrestige());
        validateIdentifier(filter.getId());
        validateOrder(filter.getOrder());
    }

    /**
     * Validates filter quantity is not greater than 2
     * @param filter (FilterDto) object with the filter values
     * @throws FilterNotValidException with filter validation error
     */
    private static void validateFilterQuantity(FilterDto filter) throws GenericException{
        var count = 0;
        if(filter.getFreeShipping() != null)
            count++;
        if(filter.getBrand() != null)
            count++;
        if(filter.getName() != null)
            count++;
        if(filter.getId() != null)
            count++;
        if(filter.getPrestige() != null)
            count++;
        if(filter.getCategory() != null)
            count++;
        if(count > 2)
            throw new FilterNotValidException("Se deben usar hasta 2 filtros sin contar el orden");
    }

    private static void validatePrestige(String prestige) throws GenericException{
        if(prestige != null) {
            var prestigeTrashValue = prestige.replace("*", "");
            if (!prestigeTrashValue.isEmpty())
                throw new FilterNotValidException("Prestigio solo debe contender *");
            if (prestige.length() > 6)
                throw new FilterNotValidException("Prestigio debe tener un máximo de ******");
        }
    }

    private static void validateIdentifier(Integer id) throws GenericException{
        if(id != null) {
            if (id <= 0)
                throw new FilterNotValidException("Id debe tener un valor positivo");
        }
    }

     static void validateOrder(Integer order) throws GenericException{
        if(order != null) {
            if (order < 0 || order > 3)
                throw new FilterNotValidException("El orden debe ser 0, 1, 2 o 3");
        }
    }
}
