package cse591.web.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomLogoutHandler extends SimpleUrlLogoutSuccessHandler {
	 
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, 
			Authentication authentication) throws IOException, ServletException {
 
		System.out.println("Logout");
		KnockSequence.sequence="";
		KnockSequence.secret=0;
		KnockSequence.knock="";
		KnockSequence.flag=0;
		
		super.onLogoutSuccess(request, response, authentication);
	}
}