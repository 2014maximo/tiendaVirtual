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

import com.tiendavirtual.business.IProductoRepository;
import com.tiendavirtual.model.Producto;

@RestController
@RequestMapping("/producto")
@CrossOrigin("*")
public class ProductoController {
	
	@Autowired
	IProductoRepository productoBusiness;

	//Consultar por id
	@GetMapping(value="/{id}", produces = "application/json")
    @ResponseBody
    public Producto consultarPorId(@PathVariable Integer id) {
    	return productoBusiness.findById(id).orElse(new Producto());
    }
	
	//Consultar todos
	@GetMapping("/")
    @ResponseBody
    public List<Producto> consultarTodas() {
    	return (List<Producto>) productoBusiness.findAll();
    }
	
	//Crear registro Save
	@PostMapping("/crear/")
	public Producto crear(@Valid @RequestBody Producto producto) {
	    return productoBusiness.save(producto);
	}
	
	//Actualizar registro
	@PutMapping("/actualizar/{id}")
	public Producto updateNote(@PathVariable(value = "id") Integer productoId,
	                       @Valid @RequestBody Producto productoDetails) {

		Producto producto = productoBusiness.findById(productoId)
	            .orElseThrow(() -> new ResourceNotFoundException());

		producto.setNombre(productoDetails.getNombre());
		producto.setDescripcion(productoDetails.getDescripcion());

		Producto updatedProducto = productoBusiness.save(producto);
	    return updatedProducto;
	}
	
	//Borrar producto
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Integer productoId) {
		Producto producto = productoBusiness.findById(productoId)
	            .orElseThrow(() -> new ResourceNotFoundException());

		productoBusiness.delete(producto);
	    return ResponseEntity.ok().build();
	}
    

}