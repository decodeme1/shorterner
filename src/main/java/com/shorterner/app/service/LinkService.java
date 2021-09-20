package com.shorterner.app.service;

import com.shorterner.app.entity.Link;

public interface LinkService {
    Link generateByUrl(String url);

    String getByCode(String url);
}
