package com.Library.Library.Services.implementations;

import java.util.List;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Library.Library.Services.AutorService;
import com.Library.Library.models.DTOS.SaveAutorDTO;
import com.Library.Library.models.Entities.Autor;
import com.Library.Library.models.Entities.QAutor;
import com.Library.Library.repositories.AutorRepository;

@Service
public class AutorServiceImpl  implements AutorService{

    @Autowired
    AutorRepository autorRepository;

    @Override
    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    @Override
    public Autor findById(UUID id) {
        return autorRepository.findById(id).orElse(null);
    }

    @Override
    public Autor save(SaveAutorDTO autor) {
        Autor newAutor = new Autor(autor.getNombre(), autor.getEdad());
        return autorRepository.save(newAutor); 
    }

    @Override
    public List<Autor> findByNombre(String nombre) {
        QAutor qautor = QAutor.autor;
        return (List<Autor>) autorRepository.findAll(qautor.nombre.eq(nombre));
    }

}
