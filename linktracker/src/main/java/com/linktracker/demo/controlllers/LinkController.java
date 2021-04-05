package com.linktracker.demo.controlllers;

import com.linktracker.demo.dtos.ErrorResponseDto;
import com.linktracker.demo.dtos.UrlRequestDto;
import com.linktracker.demo.exceptions.LinkException;
import com.linktracker.demo.exceptions.LinkNotFoundException;
import com.linktracker.demo.exceptions.LinkNotValidException;
import com.linktracker.demo.services.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private ILinkService service;

    @PostMapping("/create")
    public ResponseEntity createUrl(@RequestBody UrlRequestDto url) throws LinkException {
        return new ResponseEntity(service.createUrl(url.getUrl()), HttpStatus.OK);
    }

    @GetMapping("/redirect/{linkId}")
    public RedirectView redirect(@PathVariable(value = "linkId") int linkId) throws LinkException {
        return new RedirectView(service.redirect(linkId).getUrl());
    }

    @PostMapping("/metrics/{url}")
    public ResponseEntity getMetrics(@PathVariable(value = "url") String url) throws LinkException {
        return new ResponseEntity(service.createUrl(url), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity invalidateUrl(@PathVariable(value = "linkId") int linkId) throws LinkException {
        service.invalidate(linkId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ExceptionHandler(LinkException.class)
    public ResponseEntity<ErrorResponseDto> handleException(LinkException errorException)
    {
        var error = new ErrorResponseDto(errorException);
        return new ResponseEntity<>(error, errorException.getStatusCode());
    }
}
