package com.aruss.evaluacion.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aruss.evaluacion.entity.UserEntity;
import com.aruss.evaluacion.utils.AppCommon;
import com.aruss.evaluacion.utils.AppConstantes;

/**
 * Clase para responder al endpoint aruss/v1.0/evaluacion
 * @author Antonio Escobedo Martinez
 */

@RestController
@RequestMapping(AppConstantes.RUTA_BASE_EVALUACION)
public class LoginController {

	/**
	 * Método GET xxxxxx 
	 * @param Long 
	 * @param Long 
	 * @param String 
	 * @author Antonio Escobedo Martinez
	 * @return ResponseEntity
	 * 
	 */
	
	@Autowired
	@GetMapping(value = AppConstantes.RUTA_ACCION_EVALUACION)
	public ResponseEntity getBase() {
	
		long lStartTime = System.currentTimeMillis();
		Map<String, Object> response;
		
		UserEntity userEntity = new UserEntity();
		userEntity.setiIdUser(2);
		//userEntity.setsDescription("Example for microservice method get");
		
		response = AppCommon.generateResponseOk(lStartTime, userEntity);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	/**
	 * Método POST xxxxxx 
	 * @param Long 
	 * @param Long 
	 * @param String 
	 * @author Antonio Escobedo Martinez
	 * @return ResponseEntity
	 * 
	 */
	@SuppressWarnings("rawtypes")
	@PostMapping(value = AppConstantes.RUTA_ACCION_EVALUACION)
	public ResponseEntity postBase(@RequestBody UserEntity userEntity) {
	
		long lStartTime = System.currentTimeMillis();
		Map<String, Object> response;
		
		if(userEntity.getsUserName().equals("root") && userEntity.getsUserPassword().equals("root")) {
			response = AppCommon.generateResponseOk(lStartTime, userEntity);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}else{
			response = AppCommon.generateResponseOk(lStartTime, userEntity);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}		
		
		
	}

}
