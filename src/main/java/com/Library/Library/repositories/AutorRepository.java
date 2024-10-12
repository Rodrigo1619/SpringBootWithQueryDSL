package com.Library.Library.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.Library.Library.models.Entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, UUID>, QuerydslPredicateExecutor<Autor> {

}
