package com.ebix.struts_segurado.action;

import com.ebix.struts_segurado.model.Login;
import com.ebix.struts_segurado.model.dao.LoginDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	private String usuario;
	
	private String senha;
	
	public String execute() {
		
		Login login = new Login(this.usuario, this.senha);
		
		LoginDAO dao = new LoginDAO();
		
		if(dao.loginExiste(login)) {
			
			return "success";
		}
		else {
			addActionError(getText("error.login"));
			return "error";
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
	

	
}
