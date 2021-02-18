package com.aruss.evaluacion.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aruss.evaluacion.utils.AppCommon;
import com.aruss.evaluacion.utils.AppConstantes;

/**
 * Clase para responder al endpoint aruss/home
 * @author Antonio Escobedo Martinez
 */

@RestController
@RequestMapping(AppConstantes.RUTA_BASE_ARUSS)
public class AppHomeController {
	
	@Autowired
    @Qualifier("messageResourceImpl")
    MessageSource messageSource;
	
	@Value("${aruss.app.version}")
	private String version;

	@Value("${aruss.app.name}")
	private String appName;
	
	/**
	 * Método que permite conocer la disponibilidad del microservicio
	 * @author Antonio Escobedo Martinez
	 * @return ResponseEntity información de salida
	 */
	@Autowired
	@GetMapping(value = AppConstantes.RUTA_BASE_HOME, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getHomeMessage() {
		Map<String, Object> response;
		long lStartTime = System.currentTimeMillis();
		response = AppCommon.generateResponseOk(lStartTime, messageSource.getMessage(AppConstantes.MSG_HOME_AVAILABLE, null, null) + AppConstantes.GUION_BAJO_ESPACIO + appName + AppConstantes.GUION_BAJO_ESPACIO + version);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
