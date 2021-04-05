package com.linktracker.demo.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkDto {
    private int linkId;
    private boolean isActive;
    private String url;
}
