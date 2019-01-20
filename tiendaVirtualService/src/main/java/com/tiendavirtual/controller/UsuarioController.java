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

import com.tiendavirtual.business.IUsuarioRepository;
import com.tiendavirtual.model.Usuario;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	IUsuarioRepository usuarioBusiness;

	//Consultar por id
	@GetMapping(value="/{id}", produces = "application/json")
    @ResponseBody
    public Usuario consultarPorId(@PathVariable Integer id) {
    	return usuarioBusiness.findById(id).orElse(new Usuario());
    }
	
	//Consultar todos
	@GetMapping("/")
    @ResponseBody
    public List<Usuario> consultarTodas() {
    	return (List<Usuario>) UsuarioBusiness.findAll();
    }
	
	//Crear registro Save
	@PostMapping("/crear/")
	public Usuario crearUsuario(@Valid @RequestBody Usuario Usuario) {
	    return UsuarioBusiness.save(Usuario);
	}
	
	//Actualizar registro
	@PutMapping("/actualizar/{id}")
	public Usuario updateNote(@PathVariable(value = "id") Integer UsuarioId,
	                       @Valid @RequestBody Usuario UsuarioDetails) {

		Usuario Usuario = UsuarioBusiness.findById(UsuarioId)
	            .orElseThrow(() -> new ResourceNotFoundException());

		Usuario.setNombre(UsuarioDetails.getNombre());
		Usuario.setDescripcion(UsuarioDetails.getDescripcion());

		Usuario updatedUsuario = UsuarioBusiness.save(Usuario);
	    return updatedUsuario;
	}
	
	//Borrar Usuario
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Integer UsuarioId) {
		Usuario Usuario = UsuarioBusiness.findById(UsuarioId)
	            .orElseThrow(() -> new ResourceNotFoundException());

		UsuarioBusiness.delete(Usuario);
	    return ResponseEntity.ok().build();
	}
    

}