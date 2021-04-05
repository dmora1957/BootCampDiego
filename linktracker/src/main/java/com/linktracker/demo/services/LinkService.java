package com.linktracker.demo.services;

import com.linktracker.demo.dtos.CreationResponseDto;
import com.linktracker.demo.dtos.RedirectResponseDto;
import com.linktracker.demo.exceptions.LinkException;
import com.linktracker.demo.exceptions.LinkNotFoundException;
import com.linktracker.demo.exceptions.LinkNotValidException;
import com.linktracker.demo.repositories.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LinkService implements ILinkService{

    @Autowired
    private ILinkRepository repository;

    @Override
    public CreationResponseDto createUrl(String url) throws LinkNotValidException {
       if(!validateUrl(url))
           throw new LinkNotValidException(url);
        return repository.addNewUrl(url);
    }

    @Override
    public RedirectResponseDto redirect(int linkId) throws LinkException {
        return repository.getUrl(linkId);
    }

    @Override
    public void invalidate(int linkId) throws LinkException {
        repository.invalidate(linkId);
    }

    private boolean validateUrl(String url)
    {
        String regex = "((http|https)://)(www.)?"
                + "[a-zA-Z0-9@:%._\\+~#?&//=]"
                + "{2,256}\\.[a-z]"
                + "{2,6}\\b([-a-zA-Z0-9@:%"
                + "._\\+~#?&//=]*)";
        Pattern p = Pattern.compile(regex);

        if (url == null) {
            return false;
        }

        Matcher m = p.matcher(url);

        return m.matches();
    }
}
