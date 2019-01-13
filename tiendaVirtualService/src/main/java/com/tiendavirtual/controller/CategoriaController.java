package com.tiendavirtual.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tiendavirtual.business.ICategoriaRepository;
import com.tiendavirtual.model.Categoria;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {
	
	@Autowired
	ICategoriaRepository categoriaBusiness;

	//Consultar por id
	@GetMapping(value="/{id}", produces = "application/json")
    @ResponseBody
    public Categoria consultarPorId(@PathVariable Integer id) {
    	return categoriaBusiness.findById(id).orElse(new Categoria());
    }
	
	//Consultar todos
	@GetMapping("/")
    @ResponseBody
    public List<Categoria> consultarTodas() {
    	return (List<Categoria>) categoriaBusiness.findAll();
    }
	
	//Crear registro Save
	@PostMapping("/crear/")
	public Categoria crearCategoria(@Valid @RequestBody Categoria categoria) {
	    return categoriaBusiness.save(categoria);
	}
	
	//Actualizar registro
	@PutMapping("/actualizar/{id}")
	public Categoria updateNote(@PathVariable(value = "id") Integer categoriaId,
	                       @Valid @RequestBody Categoria categoriaDetails) {

		Categoria categoria = categoriaBusiness.findById(categoriaId)
	            .orElseThrow(() -> new ResourceNotFoundException());

		categoria.setNombre(categoriaDetails.getNombre());
		categoria.setDescripcion(categoriaDetails.getDescripcion());

		Categoria updatedCategoria = categoriaBusiness.save(categoria);
	    return updatedCategoria;
	}
	
	//Borrar Categoria
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Integer categoriaId) {
		Categoria categoria = categoriaBusiness.findById(categoriaId)
	            .orElseThrow(() -> new ResourceNotFoundException());

		categoriaBusiness.delete(categoria);
	    return ResponseEntity.ok().build();
	}
    

}