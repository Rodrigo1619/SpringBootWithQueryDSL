package com.Library.Library.Services;
import java.util.List;

import java.util.UUID;

import com.Library.Library.models.DTOS.SaveAutorDTO;
import com.Library.Library.models.Entities.Autor;
public interface AutorService {
    List<Autor> findAll();
    Autor findById(UUID id);
    Autor save(SaveAutorDTO autor);
    List<Autor> findByNombre(String nombre);
}
