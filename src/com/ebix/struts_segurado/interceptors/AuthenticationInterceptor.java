package com.ebix.struts_segurado.interceptors;

import java.util.Map;

import com.ebix.struts_segurado.interfaces.LoginAware;
import com.ebix.struts_segurado.model.Login;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthenticationInterceptor implements Interceptor {

	private static final long serialVersionUID = -5011962009065225959L;

	@Override
	public void destroy() {
		//release resources here
	}

	@Override
	public void init() {
		// create resources here
	}

	@Override
	public String intercept(ActionInvocation actionInvocation)
			throws Exception {
		System.out.println("inside auth interceptor");
		Map<String, Object> sessionAttributes = actionInvocation.getInvocationContext().getSession();
		
		Login login = (Login) sessionAttributes.get("USER");
		
		if(login == null){
			return Action.LOGIN;
		}else{
			Action action = (Action) actionInvocation.getAction();
			if(action instanceof LoginAware){
				((LoginAware) action).setLogin(login);
			}
			return actionInvocation.invoke();
		}
	}

}
