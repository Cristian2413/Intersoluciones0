package com.intersoluciones.utils;

import com.intersoluciones.dto.ResponseDTO;

public class Utils {
	
	/**
	 * Método que permite mapear la respuesta de un servicio.
	 */
	public static ResponseDTO mapearRespuesta(final String message, final Integer statusCode,
			final Object objResponse) {
		ResponseDTO response = new ResponseDTO();
		response.setMessage(message);		
		return response;
	}

	/**
	 * Método que permite mapear la respuesta de un servicio.
	 */
	public static ResponseDTO mapearRespuesta(final String message, final Integer statusCode) {
		ResponseDTO response = new ResponseDTO();
		response.setMessage(message);		
		return response;
	}
	
	

}
