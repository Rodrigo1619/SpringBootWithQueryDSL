package com.Library.Library.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Library.Library.Services.AutorService;
import com.Library.Library.models.DTOS.SaveAutorDTO;
import com.Library.Library.models.Entities.Autor;

import java.util.List;

@RestController
@RequestMapping("api/autor")
@CrossOrigin("*")
public class AutorController {
    @Autowired
    AutorService autorService;

    @PostMapping("/save")
    public ResponseEntity<?> saveAutor(@RequestBody SaveAutorDTO autor){
        Autor newAutor = autorService.save(autor);

        if(newAutor != null){
            return new ResponseEntity<>(autor, HttpStatus.OK);
        }
        return new ResponseEntity<>("Autor ya existe", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllAutores(){
        List<Autor> autores = autorService.findAll();
        return new ResponseEntity<>(autores, HttpStatus.OK);
    }

    @GetMapping("/nombre")
    public ResponseEntity<?> findByNombre(@RequestParam("nombre") String nombre){
        List<Autor> autores = autorService.findByNombre(nombre);
        return new ResponseEntity<>(autores, HttpStatus.OK);
    }
}
