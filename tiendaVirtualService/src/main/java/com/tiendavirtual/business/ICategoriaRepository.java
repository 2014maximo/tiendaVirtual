package com.tiendavirtual.business;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiendavirtual.model.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {


}
