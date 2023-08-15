package com.intersoluciones.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario",schema="seguridad")
@EntityListeners(AuditingEntityListener.class)
@Where(clause = "activo = true")

public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_usuario")
	private Integer id_usuario;
	
	@Basic(optional = false)
	@Column(name = "nombre")
	private String nombre;
	
	@Basic(optional = false)
	@Column(name = "no_documento")
	private String no_documento;
	
	@Basic(optional = false)
	@Column(name = "telefono")
	private String  telefono;
	
	@Basic(optional = false)
	@Column(name = "ciudad")
	private String ciudad;
	
	@Basic(optional = false)
	@Column(name = "direccion")
	private String direccion;
	
	@Basic(optional = false)
	@Column(name = "email")
	private String email;
	
	@Basic(optional = false)
	@Column(name = "password")
	private String password;
	
	@JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento")
	@ManyToOne(optional = true)
	private String id_tipo_documento; 
	
	@Basic(optional = true)
	@Column(name = "bloqueado")
	private Boolean bloqueado; 
	
	
	@Basic(optional = true)
	@Column(name = "usuario_creacion", insertable = true, updatable = false)
	private String usuarioCreacion;

	@Basic(optional = true)
	@Column(name = "fecha_creacion", insertable = true, updatable = false)
	@CreatedDate
	private Date fechaCreacion;

	@Basic(optional = true)
	@Column(name = "usuario_modificacion",updatable = true, insertable = false )
	private String usuarioModifica;

	@Basic(optional = true)
	@Column(name = "fecha_modificacion",updatable = true, insertable = false)
	@LastModifiedDate
	private Date fechaModifica;

	@Basic(optional = true)
	@Column(name = "activo", insertable = true, updatable = true)
	private Boolean activo;

	public void setId_tipo_Documento(Integer id_tipo_Documento2) {
		// TODO Auto-generated method stub
		
	}

	public Integer getId_tipo_Documento() {
		// TODO Auto-generated method stub
		return null;
	}

	
}


