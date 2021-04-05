package com.linktracker.demo.repositories;

import com.linktracker.demo.dtos.CreationResponseDto;
import com.linktracker.demo.dtos.LinkDto;
import com.linktracker.demo.dtos.RedirectResponseDto;
import com.linktracker.demo.exceptions.LinkException;
import com.linktracker.demo.exceptions.LinkNotActiveException;
import com.linktracker.demo.exceptions.LinkNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepository implements ILinkRepository{

    private HashMap<Integer, LinkDto> links;
    private int identifier = 0;
    public LinkRepository()
    {
        links = new HashMap<>();
    }

    private int getId()
    {
        identifier++;
        return identifier;
    }

    @Override
    public CreationResponseDto addNewUrl(String url) {
        var link = new LinkDto(getId(), true, url);
        links.put(link.getLinkId(),link);
        return new CreationResponseDto(link.getLinkId(),link.getUrl());
    }

    @Override
    public RedirectResponseDto getUrl(int linkId) throws LinkException {

        var currentLink = this.findLink(linkId);

        return new RedirectResponseDto(currentLink.getLinkId(), currentLink.getUrl());
    }

    @Override
    public void invalidate(int linkId) throws LinkException {

        var currentLink = this.findLink(linkId);
        links.get(linkId).setActive(false);
    }

    public LinkDto findLink(int linkId) throws LinkException
    {
        if(!links.containsKey(linkId))
            throw new LinkNotFoundException(linkId);

        var currentLink = links.get(linkId);
        if(!currentLink.isActive())
            throw new LinkNotActiveException(currentLink.getUrl());

        return currentLink;
    }
}
