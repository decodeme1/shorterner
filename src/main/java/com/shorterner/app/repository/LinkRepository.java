package com.shorterner.app.repository;

import com.shorterner.app.entity.Link;
import org.springframework.data.repository.CrudRepository;

public interface LinkRepository extends CrudRepository<Link, Long> {
}
