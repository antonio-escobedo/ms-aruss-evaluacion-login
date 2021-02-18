package com.aruss.evaluacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.aruss.evaluacion.utils.AppConstantes;

/**
 * Clase principal de microservicio
 * @author Antonio Escobedo Martinez
 */

@SpringBootApplication
public class LoginApplication {
	
	/**
	 * @author Antonio Escobedo Martinez
	 * Genera el bean de CharacterEncodingFilter.
	 * @return Bean de CharacterEncodingFilter
	 */
	@Bean
	public CharacterEncodingFilter characterFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding(AppConstantes.ENCODING);
		filter.setForceEncoding(true);
		return filter;
	}
	
	/**
	 * Genera el bean de MessageSource.
	 * @author Antonio Escobedo Martinez
	 * @return Bean de MessageSource
	 */
    @Bean(name = "messageResourceImpl")
    public MessageSource messageResource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("messages");
        return resourceBundleMessageSource;
    }

	/**
	 * Método main
	 * @author Antonio Escobedo Martinez
	 * @return Bean de MessageSource
	 */
	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}

}
