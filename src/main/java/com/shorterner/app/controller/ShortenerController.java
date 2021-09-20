package com.shorterner.app.controller;


import com.shorterner.app.entity.Link;
import com.shorterner.app.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = ShortenerController.PATH)
public class ShortenerController {

    protected static final String PATH = "";

    private LinkService linkService;

    public ShortenerController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("get-link/{code}")
    public ResponseEntity getLinkByUrl(@PathVariable String code) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("http://" + this.linkService.getByCode(code)))
                .build();
    }

    @PostMapping("generate")
    public Link generate(@RequestBody String url) {
        return this.linkService.generateByUrl(url);
    }

}
