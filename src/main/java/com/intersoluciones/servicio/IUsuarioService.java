package com.intersoluciones.servicio;


import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.intersoluciones.dto.ResponseDTO;
import com.intersoluciones.dto.TipoDocumentoDTO;
import com.intersoluciones.dto.UsuarioDTO;
import com.intersoluciones.entities.TipoDocumento;

public interface IUsuarioService {
		
	public ResponseEntity<ResponseDTO> crearUsuario(UsuarioDTO usuario);
	
	public ResponseEntity<ResponseDTO> crearTipoDocumento(TipoDocumentoDTO tipodocumento);

	public ResponseEntity<ResponseDTO> eliminarUsuario(Integer id_usuario);

	public ResponseEntity<ResponseDTO> actualizarUsuario(UsuarioDTO usuarioDTO);
	
	public List<TipoDocumentoDTO> consultarTipoDocumento();
}
