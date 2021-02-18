package com.aruss.evaluacion.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase de comunes
 * @author Antonio Escobedo Martínez
 */

public final class AppCommon {
	private AppCommon() {
	}
	
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSSSSS");
	private static final Logger logger = LoggerFactory.getLogger(AppCommon.class);
	
	/**
	 * Método generateResponseError para generar la respuesta de error en caso de existir 
	 * @param int iCodeError 
	 * @param String sDescriptionError 
	 * @param String sStackTrace
	 * @param List sDiagnostics 
	 * @author Antonio Escobedo Martinez
	 * @return ResponseEntity
	 * 
	 */
    public static Map generateResponseError(int iCodeError, String sDescriptionError, String sStackTrace, List sDiagnostics) {    	
        Map response = new HashMap();
        response.put("codigoError", Integer.valueOf(iCodeError));
        response.put("descripcionError", sDescriptionError);
        response.put("stackTrace", sStackTrace);
        response.put("diagnosticos", sDiagnostics);
        response.put("id", UUID.randomUUID());
        logger.error("Fecha y hora de ejecucion: " + simpleDateFormat.format(new Date()) + "Ocurrio un error en el método: generateResponseError " + sStackTrace);
        return response;
    }

	/**
	 * Método generateResponseError para generar la respuesta de error en caso de existir y tener una excepcion
	 * @param int iCodeError 
	 * @param String sDescriptionError 
	 * @param Exception exception
	 * @param List sDiagnostics 
	 * @author Antonio Escobedo Martinez
	 * @return ResponseEntity
	 * 
	 */
    public static Map generateResponseError(int iCodeError, String sDescriptionError, Exception exception, List sDiagnostics) {
        Map response = new HashMap();
        response.put("codigoError", Integer.valueOf(iCodeError));
        response.put("descripcionError", sDescriptionError);
        response.put("stackTrace", getDetailException(exception));
        response.put("diagnosticos", sDiagnostics);
        response.put("id", UUID.randomUUID());
        return response;
    }
    
    /**
	 * Método getDetailException para obtener el detalle de la excepcion
	 * @param Exception exception
	 * @author Antonio Escobedo Martinez
	 * @return ResponseEntity
	 * 
	 */
    private static String getDetailException(Exception exception) {
        try {
            String sClassError = exception.getStackTrace()[0].getClassName() == null ? "Clase: desconocida" : exception.getStackTrace()[0].getClassName();
            String sMethodError = exception.getStackTrace()[0].getMethodName() == null ? "Metodo: desconocido" : exception.getStackTrace()[0].getMethodName();
            String sMessageError = exception.getMessage() == null ? "Mensaje: " : exception.getMessage();
            int iNumberLineException = exception.getStackTrace()[0].getLineNumber();
            
            logger.error("Fecha y hora de ejecucion: " + simpleDateFormat.format(new Date())  + sClassError.concat(AppConstantes.GUION_BAJO_ESPACIO).concat(sMethodError).concat(AppConstantes.GUION_BAJO_ESPACIO).concat(sMessageError).concat(AppConstantes.GUION_BAJO_ESPACIO).concat("Linea: ").concat(String.valueOf(iNumberLineException)));
            return sClassError.concat(AppConstantes.GUION_BAJO_ESPACIO).concat(sMethodError).concat(" - ").concat(sMessageError).concat(AppConstantes.GUION_BAJO_ESPACIO).concat("Linea: ").concat(String.valueOf(iNumberLineException));
        } catch(Exception exceptionGetDetail) {
        	logger.error("Ocurrio un error al obtener el método: getDetailException, mensaje de error: "  + exceptionGetDetail.getMessage() +
        			" Stacktrace: " + exceptionGetDetail.getStackTrace());
            return "Clase o metodo desconocido";
        }
    }

    /**
   	 * Método generateResponseOk para generar la respuesta exitosa
   	 * @param Long lStartTime exception
   	 * @param Object data
   	 * @author Antonio Escobedo Martinez
   	 * @return ResponseEntity
   	 * 
   	 */
    public static Map generateResponseOk(long lStartTime, Object data) {
        Map resp = new HashMap();
        long lEndTime = System.currentTimeMillis();
        logger.info("Fecha y hora de ejecucion: " + simpleDateFormat.format(new Date()) + "Timpo de ejecucion : " + String.valueOf((new StringBuilder(String.valueOf(lEndTime - lStartTime))).append(" ms").toString()));
        resp.put("mensaje", "Operaci\363n exitosa");        
        resp.put("datos", data);
        return resp;
    }
}
