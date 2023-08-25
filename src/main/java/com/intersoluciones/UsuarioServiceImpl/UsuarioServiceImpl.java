package com.intersoluciones.UsuarioServiceImpl;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
    public List<TipoDocumentoDTO> consultarTipoDocumento() {
        List<TipoDocumento> tiposDocumento = tipodocumentoRepository.findAll();
        List<TipoDocumentoDTO> tipoDocumentoDTOs = ((UsuarioMapper) TipoDocumentoMapper.INSTANCE).benListToDtoList(tiposDocumento);
        return tipoDocumentoDTOs;
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
	public ResponseEntity<ResponseDTO> eliminarUsuario(Integer id_usuario) {
        try {
            usuarioRepository.deleteById(id_usuario);
            ResponseDTO responseDTO = new ResponseDTO(null, HttpStatus.OK.value(), "Usuario eliminado");
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (EmptyResultDataAccessException ex) {
            // Manejar caso de usuario no encontrado
            ResponseDTO responseDTO = new ResponseDTO(null, HttpStatus.NOT_FOUND.value(), "Usuario no  encontrado");
            return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
        } 
	}

	@Override
	 public ResponseEntity<ResponseDTO> actualizarUsuario(UsuarioDTO usuarioDTO) {
	       
	        // Actualizar los datos del usuario existente con los datos de usuarioDTO
	        usuarioRepository.save(UsuarioMapper.INSTANCE.dtoToEntity(usuarioDTO));

	        ResponseDTO responseDTO = new ResponseDTO("Usuario actualizado con éxito", null, null);
	        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

}

