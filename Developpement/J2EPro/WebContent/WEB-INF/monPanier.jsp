<%@page import="entities.Menu"%>
<%@page import="entities.Plat"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Mon Panier</title>
		<style type="text/css">		
			.item_wrapper a
			{
				margin: 5px 10px;
			}
				
			.msg
			{
				background-color: red;
				color: white;
				display: inline-block;
				padding: 3px 8px;
				margin-top: 20px;
				display: inline-block;
			}
			
			li
			{
				display: block;
				margin-bottom: 5px;
			}
			
			li:last-child
			{
				margin-bottom: 0px;
			}
			
			.item_wrapper
			{
				border: thid solid #A4A4A4;
				background-color: #F2F2F2;
				padding: 10px;
				width: 80%;
				display: inline-block;
			}
			
			.action_wrapper>.retirer
			{
				cursor: pointer;
			}
		</style>
		<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
	</head>
	<body>
		<h1>Mon panier</h1>
        <div>
        	<h2>Mes Produits</h2>
        	<div>
        		<h3>Menus</h3>
	        	<ul>
		        	<%
	        		Set<Menu> menus = (Set<Menu>) request.getAttribute("menus");
		        	
		        	if(menus == null || menus.size() == 0)
		        		out.println("<span>Aucun menu.</span>");
		        	else
			        	for (Menu men : menus)
			        	{
			        		String url = application.getContextPath();
							out.println("<li><div class=\"item_wrapper\"><p>" + men.toString() +
									" </p><div class=\"action_wrapper\"><a class=\"details\" href=\"" + url + "/panier\">Détails</a>" + 
									"<a id=\"" + String.valueOf(men.getId().getIdProduit()) + "\" class=\"retirer\" >Retirer</a>" + 
									"</div></li>");
			        	}
		        	%>
	        	</ul>
        	</div>
        	<div>
        		<h3>Plats</h3>
	        	<ul>
	        		<%
	        		Set<Plat> plats = (Set<Plat>) request.getAttribute("plats");
		        	
		        	if(plats == null || plats.size() == 0)
		        		out.println("<span>Aucun plat.</span>");
		        	else
			        	for (Plat men : plats)
			        	{
			        		String url = application.getContextPath();
							out.println("<li><div class=\"item_wrapper\"><p>" + men.toString() + 
									" </p><div class=\"action_wrapper\"><a class=\"details\" href=\"" + url + "/panier\">Détails</a>" + 
									"<a id=\"" + String.valueOf(men.getId().getIdProduit()) + "\" class=\"retirer\" >Retirer</a>" + 
									"</div></li>");
						}
		        	//href=\"" + url + "/panier?rem=" + String.valueOf(men.getId().getIdProduit()) + "\"
		        	%>
	        	</ul>
        	</div>
        </div>
        <div class="msg">
        	<% 
            String attribut = (String) request.getAttribute("msg");
        	
        	if(attribut == null)
        		out.println("Lol :(");
        	else
        		out.println("Message: " + attribut);
            %>
        </div>
        <script type="text/javascript">
        $( document ).ready(function()
      	{
            $(".action_wrapper>.retirer").click(function()
            {
            	alert("retirer");
            	<%
	            	out.println("var url = \"" + application.getContextPath() + "/panier?rem=\" + $(this).attr(\"id\");"); 
            		//out.println("window.location.href = \"" + application.getContextPath() + "\" + $(this).attr(\"id\");") ;
           		%>
           		window.location.href = url;
           		//console.log(url);
            });
            
            $(".action_wrapper>.details").click(function()
            {
            	alert("details");
            });
        });
        </script>
	</body>
</html>