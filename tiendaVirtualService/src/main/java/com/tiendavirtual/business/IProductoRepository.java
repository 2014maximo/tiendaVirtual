package com.tiendavirtual.business;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tiendavirtual.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {

	 @Query("select new com.tiendavirtual.model.Producto(p.id, p.nombre, p.estado, " + 
	 		" p.descripcion, p.precio, p.cantidad, p.foto, p.categoria) from Producto p")
	List<Producto> findAll();
	
	 @Query("select new com.tiendavirtual.model.Producto(p.id, p.nombre, p.estado, " + 
	 		" p.descripcion, p.precio, p.cantidad, p.foto, p.categoria) " +
	 		" from Producto p where p.id = ?1")
	Optional<Producto> findById(Integer id);
}
