package com.intersoluciones.dto;

import java.io.Serializable;
import java.sql.Date;

import com.intersoluciones.entities.TipoDocumento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UsuarioDTO implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	
	private Integer id_usuario;
	private String nombre;
	private String no_documento;
	private String  telefono;
	private String ciudad;
	private String direccion;
	private String email;
	private String password;
	private Integer id_tipo_Documento; 
	private Boolean bloqueado; 
	private String usuarioCreacion;
	private Date fechaCreacion;
	private String usuarioModifica;
	private Date fechaModifica;
	private Boolean activo;
	public void settipoDocumento(Object gettipoDocumento) {
	}			
}
