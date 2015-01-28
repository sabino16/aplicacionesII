package com.aplicaciones.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aplicacionesa.modelo.Usuario;


/**
 * Servlet Filter implementation class Filtros
 */
@WebFilter("/Filtros")
public class Filtros implements Filter {

    /**
     * Default constructor. 
     */
    public Filtros() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		HttpServletRequest httprequest=(HttpServletRequest)request;
		//obtener la session a partir de la peticion
		HttpSession session=httprequest.getSession();
		//leer de la sesion
		Usuario usuario=(Usuario)session.getAttribute("usuario");
		//si usuario existe en la sesion
		
			//ruta del recurso solicitado
			String path=httprequest.getServletPath();
			//comprobar si el usuario existe en la session
			if(usuario!=null){
				
			// pass the request along the filter chain
			//pasa la peticin al siguiente filtro en la ultima llamada
			//(es decir en el utlimo filtro) invoca al primer Servlet
			chain.doFilter(request, response);
		}else{
			//redirigir a la pagina de Login
			//foward a la pagina de login
			HttpServletResponse httpresponse=(HttpServletResponse)response;
			httprequest.getServletContext().getRequestDispatcher("/login.zul").forward(httprequest,httpresponse);
		}


		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
