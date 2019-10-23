package com.ebix.struts_segurado.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ebix.struts_segurado.model.Login;
import com.ebix.struts_segurado.model.dao.LoginDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements SessionAware, ModelDriven<Login>{
	
	private static final long serialVersionUID = 1L;

	private String usuario;
	private String senha;
	private Login login = new Login();
	private Map<String, Object> sessionAttributes = null;

	
	public String execute() {
				
		
		LoginDAO dao = new LoginDAO();
		
		if(dao.loginExiste(login)) {
			sessionAttributes.put("USER", login);
			return "success";
		}
		else {
			addActionError(getText("error.login"));
			return "input";
		}
		
		
				
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public Login getModel() {
		return login;
	}

	@Override
	public void setSession(Map<String, Object> sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
		
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
 
	
}
