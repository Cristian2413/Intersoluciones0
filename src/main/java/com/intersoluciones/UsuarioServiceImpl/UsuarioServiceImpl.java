package com.intersoluciones.UsuarioServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.intersoluciones.dto.ResponseDTO;
import com.intersoluciones.dto.TipoDocumentoDTO;
import com.intersoluciones.dto.UsuarioDTO;
import com.intersoluciones.entities.TipoDocumento;
import com.intersoluciones.entities.Usuario;
import com.intersoluciones.maps.TipoDocumentoMapper;
import com.intersoluciones.maps.UsuarioMapper;
import com.intersoluciones.repository.TipoDocumentoRepository;
import com.intersoluciones.repository.UsuarioRepository;
import com.intersoluciones.servicio.IUsuarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class UsuarioServiceImpl implements IUsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	private final TipoDocumentoRepository tipodocumentoRepository;
	
	
	@Override
	public ResponseEntity<ResponseDTO> obtenerTipoDocumento(){
		List<TipoDocumentoDTO> tipodocumentoDTO = TipoDocumentoMapper.INSTANCE.benListToDtoList(this.tipodocumentoRepository.findAll());
		ResponseDTO responseDTO = new ResponseDTO(HttpStatus.OK.name(),HttpStatus.OK.value(),tipodocumentoDTO);
		
		return new ResponseEntity<>(responseDTO,HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<ResponseDTO> crearUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = UsuarioMapper.INSTANCE.dtoToEntity(usuarioDTO);
		usuario = usuarioRepository.save(usuario);
		ResponseDTO responseDTO =new ResponseDTO(HttpStatus.CREATED.name(),HttpStatus.CREATED.value(),usuario);
		return new ResponseEntity<>(responseDTO,HttpStatus.CREATED);

	}
	
	@Override
	public ResponseEntity<ResponseDTO> crearTipoDocumento(TipoDocumentoDTO tipodocumentoDTO) {
		TipoDocumento tipodocumento = TipoDocumentoMapper.INSTANCE.dtoToEntity(tipodocumentoDTO);
		tipodocumento = tipodocumentoRepository.save(tipodocumento);
		ResponseDTO responseDTO =new ResponseDTO(HttpStatus.CREATED.name(),HttpStatus.CREATED.value(),tipodocumento);
		return new ResponseEntity<>(responseDTO,HttpStatus.CREATED);

	}
	
	@Override
	public ResponseEntity<ResponseDTO> eliminarUsuario (Integer id) {
		usuarioRepository.deleteById(id);
		ResponseDTO responseDTO = new ResponseDTO(null, HttpStatus.OK.value(), "Usuario eliminado");
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	
	}

}
		


	


