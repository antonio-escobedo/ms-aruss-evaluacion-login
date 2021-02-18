/**
 * 
 */
package com.aruss.evaluacion.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.lang.NonNull;

import com.aruss.evaluacion.utils.AppConstantes;

/**
 * @author Antonio
 *
 */
public class UserEntity {
	
	@Autowired
    @Qualifier("messageResourceImpl")
    MessageSource messageSource;
	
	@NotNull(message =  "${arus.param.listNotNulo}")
	@NotEmpty(message = "${arus.param.listNotNulo}")
	private String sUserName;
	
	@NotNull(message =  "${arus.param.listNotNulo}")
	@NotEmpty(message = "${arus.param.listNotNulo}")
	private String sUserPassword;
	
	
	private int iIdUser;
	private int iNumberAttempts; 
	/**
	 * @return the sUserName
	 */
	public String getsUserName() {
		return sUserName;
	}
	/**
	 * @param sUserName the sUserName to set
	 */
	public void setsUserName(String sUserName) {
		this.sUserName = sUserName;
	}
	/**
	 * @return the sUserPassword
	 */
	public String getsUserPassword() {
		return sUserPassword;
	}
	/**
	 * @param sUserPassword the sUserPassword to set
	 */
	public void setsUserPassword(String sUserPassword) {
		this.sUserPassword = sUserPassword;
	}
	/**
	 * @return the iIdUser
	 */
	public int getiIdUser() {
		return iIdUser;
	}
	/**
	 * @param iIdUser the iIdUser to set
	 */
	public void setiIdUser(int iIdUser) {
		this.iIdUser = iIdUser;
	}
	/**
	 * @return the iNumberAttempts
	 */
	public int getiNumberAttempts() {
		return iNumberAttempts;
	}
	/**
	 * @param iNumberAttempts the iNumberAttempts to set
	 */
	public void setiNumberAttempts(int iNumberAttempts) {
		this.iNumberAttempts = iNumberAttempts;
	}

}
