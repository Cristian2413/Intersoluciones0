package com.intersoluciones.servicio;


import org.springframework.http.ResponseEntity;

import com.intersoluciones.dto.ResponseDTO;
import com.intersoluciones.dto.TipoDocumentoDTO;
import com.intersoluciones.dto.UsuarioDTO;

public interface IUsuarioService {
	
	public ResponseEntity<ResponseDTO> obtenerTipoDocumento();
	
	public ResponseEntity<ResponseDTO> crearUsuario(UsuarioDTO usuario);
	
	public ResponseEntity<ResponseDTO> crearTipoDocumento(TipoDocumentoDTO tipodocumento);

	ResponseEntity<ResponseDTO> eliminarUsuario(Integer id);

}
