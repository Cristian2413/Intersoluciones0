package com.intersoluciones.maps;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.intersoluciones.dto.UsuarioDTO;
import com.intersoluciones.entities.Usuario;

@Mapper(uses = TipoDocumentoMapper.class)
public interface UsuarioMapper {

UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

	UsuarioDTO entityToDto(UsuarioDTO usuario);
	
	@InheritInverseConfiguration
	Usuario dtoToEntity(UsuarioDTO usuario);
	
	UsuarioDTO dtoToEntity(Usuario dto);
	
	List<UsuarioDTO> benListToDtoList(List<Usuario> lista);
}
