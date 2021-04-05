package com.linktracker.demo.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RedirectResponseDto {
    private int linkId;
    private String url;
}
