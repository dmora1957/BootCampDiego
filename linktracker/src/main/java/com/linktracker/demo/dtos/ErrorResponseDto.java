package com.linktracker.demo.dtos;

import com.linktracker.demo.exceptions.LinkException;
import com.linktracker.demo.exceptions.LinkNotFoundException;
import com.linktracker.demo.exceptions.LinkNotValidException;
import lombok.Data;

@Data
public class ErrorResponseDto {

    private String name;
    private String description;

    public ErrorResponseDto(LinkException exc)
    {
        name = exc.getName();
        description = exc.getMessage();
    }
}
