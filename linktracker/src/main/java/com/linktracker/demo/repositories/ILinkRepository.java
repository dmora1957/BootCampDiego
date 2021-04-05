package com.linktracker.demo.repositories;

import com.linktracker.demo.dtos.CreationResponseDto;
import com.linktracker.demo.dtos.RedirectResponseDto;
import com.linktracker.demo.exceptions.LinkException;
import com.linktracker.demo.exceptions.LinkNotFoundException;

public interface ILinkRepository {

    CreationResponseDto addNewUrl(String url);
    RedirectResponseDto getUrl(int id) throws LinkException;
    void invalidate(int linkId) throws LinkException;
}
