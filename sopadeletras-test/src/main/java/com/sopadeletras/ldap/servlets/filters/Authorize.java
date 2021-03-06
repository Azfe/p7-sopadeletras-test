package com.sopadeletras.ldap.servlets.filters;

import java.io.IOException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.jndi.ldap.LdapCtxFactory;

public class Authorize implements Filter {

	String ldapHostname;
	String ldapUsername;
	String ldapPassword;
	
	String loginUrlPath;
	
	@Override
	public void init(FilterConfig filterConfiguration) throws ServletException {
		
		ldapHostname = filterConfiguration.getInitParameter("ldap-hostname");
		ldapUsername = filterConfiguration.getInitParameter("ldap-username");
		ldapPassword = filterConfiguration.getInitParameter("ldap-password");
				
		loginUrlPath = filterConfiguration.getInitParameter("login-url-path");

		System.out.println("Authorize filter created having with login url '" + loginUrlPath + 
				"', ldap server '" + ldapHostname +  "', with username '" + ldapUsername + 
				"' and password '" + ldapPassword + "'.");
	}

	private boolean performLdapAuthentication(String username, String password) {
		boolean authenticationGranted = false;
		
		String ldapContext = String.format("ldap://%s", ldapHostname);
		
		Hashtable<String, String> ldapUserProperties = new Hashtable<String, String>();
		ldapUserProperties.put(Context.SECURITY_PRINCIPAL, username);
		ldapUserProperties.put(Context.SECURITY_CREDENTIALS, password);

		try {
			@SuppressWarnings("unused")
			DirContext directoryContext = LdapCtxFactory.getLdapCtxInstance(ldapContext, ldapUserProperties);
			authenticationGranted = true;
		} catch (NamingException e) {
				System.out.println("Authentication failed!");
		}
		
		return authenticationGranted;
	}
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain servletFilterChain)
			throws IOException, ServletException {
		
		System.out.println("Performing authorization...");

		boolean authenticationGranted = false;
		String redirectUri = null;
		
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpSession session = request.getSession();

		// perform authentication only if user is not previously authorized
		String authorizedUsername = (String) session.getAttribute("authorizedUsername");
		if (authorizedUsername != null) {
			System.out.println("User '" + authorizedUsername + "' was previously authorized!");
			authenticationGranted = true;
		} else {
			// loginUrlPath would be defined as "/login"
			if (request.getServletPath().equals(loginUrlPath)) {
				if (request.getMethod().equals("GET")) {
					// login URI is always allowed
					authenticationGranted = true;
				} else if (request.getMethod().equals("POST")) {
					String username = request.getParameter("_login_username");
					String password = request.getParameter("_login_password");

					// authorize user with credentials provided from login page
					if (performLdapAuthentication(username, password)) {
						session.setAttribute("authorizedUsername", ldapUsername);
						authenticationGranted = true;

						System.out.println("User '" + session.getAttribute("authorizedUsername") + "' is now authorized!");
					} else {
						redirectUri = String.format("%s%s", request.getContextPath(), loginUrlPath);
						session.setAttribute("_login_authentication_error", "Authentication error, username or password invalid!");
					}
				}
			} else {
				// redirect to login URI if configured
				if (loginUrlPath != null) {
					redirectUri = String.format("%s%s", request.getContextPath(), loginUrlPath);
					// keep original URL in session to redirect after valid authentication
					session.setAttribute("_login_original_request_url", request.getRequestURL());
				} else {
					// authorize user with credentials provided from initial parameters
					if (performLdapAuthentication(ldapUsername, ldapPassword)) {
						authorizedUsername = ldapUsername;
						session.setAttribute("authorizedUsername", ldapUsername);
						authenticationGranted = true;

						System.out.println("User '" + authorizedUsername + "' is now authorized!");
					}
				}
			}
		}

		if (authenticationGranted) {
			servletFilterChain.doFilter(servletRequest, servletResponse);
		} else {
			if (redirectUri == null) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			} else {
				response.sendRedirect(redirectUri);
			}
		}
	}

	@Override
	public void destroy() {
		System.out.println("Authorize filter destroyed.");
	}
}