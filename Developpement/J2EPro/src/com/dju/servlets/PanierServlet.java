package com.dju.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dju.entities.Panier;
import com.dju.entities.PanierHome;

public class PanierServlet extends HttpServlet
{
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		String message = "Shit's workin out !";
		request.setAttribute( "test", message );
		
		Panier p = (new PanierHome()).findById(0);
		request.setAttribute( "panier", p );
		
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/mon_panier.jsp" ).forward( request, response );
	}
}
