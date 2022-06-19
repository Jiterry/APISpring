package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table (name = "Producto")
public class Producto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;
	
	private String nombreProducto;
	private String descripcionProducto;
	private double precioProducto;
	private int existencia;
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	
	@ManyToOne
	@JoinColumn(name = "idCategoria")
	private Categoria idCategoria;
	
	@PrePersist
	public void prePersist() {
		this.fechaCreacion = new Date();
	}

}
