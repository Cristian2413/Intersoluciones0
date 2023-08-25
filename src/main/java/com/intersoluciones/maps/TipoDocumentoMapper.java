package com.intersoluciones.maps;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.intersoluciones.dto.TipoDocumentoDTO;
import com.intersoluciones.entities.TipoDocumento;

@Mapper
public interface TipoDocumentoMapper {
	
	TipoDocumentoMapper INSTANCE = Mappers.getMapper(TipoDocumentoMapper.class);
	
	TipoDocumentoDTO entityToDto(TipoDocumentoDTO tipodocumento);
	
	@InheritInverseConfiguration

	TipoDocumentoDTO dtoToEntity(TipoDocumento dto);

	TipoDocumentoDTO tipoDocumentoToDto(TipoDocumento tipoDocumento);

	TipoDocumento dtoToEntity(TipoDocumentoDTO tipodocumentoDTO);



	
}

