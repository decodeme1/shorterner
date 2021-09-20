package com.shorterner.app.service.impl;

import com.shorterner.app.entity.Link;
import com.shorterner.app.repository.LinkRepository;
import com.shorterner.app.service.LinkService;
import com.shorterner.app.util.GenUtils;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LinkServiceImpl implements LinkService {

    private LinkRepository shortenerRepository;

    public LinkServiceImpl(LinkRepository shortenerRepository) {
        this.shortenerRepository = shortenerRepository;
    }

    @Override
    public Link generateByUrl(String url) {
        Link link = new Link(GenUtils.generateCode(), url);
        return shortenerRepository.save(link);
    }

    @Override
    public String getByCode(String code) {
        List<Link> linkList = IterableUtils.toList(this.shortenerRepository.findAll());
        return linkList.stream().filter(link -> link.getCode().equals(code)).collect(Collectors.toList()).stream().findFirst().get().getOriginalUrl();
    }

}
