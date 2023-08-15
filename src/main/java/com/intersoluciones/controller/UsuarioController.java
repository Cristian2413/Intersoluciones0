package com.intersoluciones.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intersoluciones.UsuarioServiceImpl.UsuarioServiceImpl;
import com.intersoluciones.dto.ResponseDTO;
import com.intersoluciones.dto.TipoDocumentoDTO;
import com.intersoluciones.dto.UsuarioDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/usuario")
@CrossOrigin
@RequiredArgsConstructor

public class UsuarioController {
	
	private final UsuarioServiceImpl serviceUsuario;
	
	@GetMapping
	public ResponseEntity<ResponseDTO> obtenerTipoDocumento() {
		return this.serviceUsuario.obtenerTipoDocumento();
	}
	
	@PostMapping("/crear/Usuario")
    public ResponseEntity<ResponseDTO> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return serviceUsuario.crearUsuario(usuarioDTO);
    }
	
	@PostMapping("/crear")
    public ResponseEntity<ResponseDTO> crearTipoDocumento(@RequestBody TipoDocumentoDTO tipodocumentoDTO) {
        return serviceUsuario.crearTipoDocumento(tipodocumentoDTO);
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO> eliminarUsuario(@PathVariable Integer id) {
		return this.serviceUsuario.eliminarUsuario(id);

	}
	
}
	


