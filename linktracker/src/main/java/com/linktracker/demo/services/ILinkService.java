package com.linktracker.demo.services;

import com.linktracker.demo.dtos.CreationResponseDto;
import com.linktracker.demo.dtos.RedirectResponseDto;
import com.linktracker.demo.exceptions.LinkException;
import com.linktracker.demo.exceptions.LinkNotValidException;

public interface ILinkService {
    CreationResponseDto createUrl(String url) throws LinkException;
    RedirectResponseDto redirect(int linkId) throws LinkException;
    void invalidate(int linkId) throws LinkException;
}
