package com.tiendavirtual.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "estado")
	private boolean estado;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "precio")
	private Double precio;
	
	@Column(name = "cantidad")
	private Integer cantidad;
	
	@Column(name = "foto")
	private String foto;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_categoria")
	private Categoria categoria;
	
	/*public Producto(Integer id, String nombre, boolean estado,
					String descripcion, Double precio, Integer cantidad, String foto, Categoria categoria) {
		
	}*/
	
	/*
	 * @Column(name = "REGIST_DATE", updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar registDate;
	 */
}
