package com.aruss.evaluacion.utils;

/**
 * Clase de constantes para el uso del microservicio
 * @author Antonio Escobedo Martínez
 */

public final class AppConstantes {
	private AppConstantes() {
	}
	
	public static final String RUTA_BASE_ARUSS						= "/aruss";
	public static final String RUTA_BASE_HOME						= "/home";
	public static final String MSG_HOME_AVAILABLE					= "aruss.home.available";
	public static final String MSG_HOME_VERSION						= "aruss.home.version";
	public static final String GUION_BAJO_ESPACIO					= " - ";
	
	public static final String RUTA_BASE_EVALUACION			= RUTA_BASE_ARUSS+"/v1.0/evaluacion";
	public static final String RUTA_ACCION_EVALUACION			= "/login";
	
	public static final String ENCODING								= "UTF-8";
	
	public static final String ERROR_GENERAL 						= "aruss.error.general";
	
	public static final String ERROR_PARAMETRO_LIST_NOT_NULL 		= "arus.param.listNotNulo";
	public static final String ERROR_PARAMETRO_LIST_NOT_EMPTY 		= "arus.param.listNotEmpty";
}