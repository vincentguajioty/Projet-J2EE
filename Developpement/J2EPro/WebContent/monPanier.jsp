<!DOCTYPE html>
<%@page import="entities.Menu"%>
<%@page import="entities.Plat"%>
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Mon panier | La pâte de canard</title>
	<c:import url="/inc/inc_bodyhead.jsp" />
	<section id="panier_section">
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="panier">
						<h1>Mon panier</h1>
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
													" </p><div class=\"action_wrapper\"><button class=\"details btn btn-default\">Détails</button>" + 
													"<button class=\"retirer btn btn-default\" id=\"" + String.valueOf(men.getId().getIdProduit()) + "\">Retirer</a>" + 
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
													" </p><div class=\"action_wrapper\"><button class=\"details btn btn-default\">Détails</button>" + 
													"<button class=\"retirer btn btn-default\" id=\"" + String.valueOf(men.getId().getIdProduit()) + "\">Retirer</a>" + 
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
			        </div>
		        </div>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.3.js"></script>
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
	<c:import url="/inc/inc_bodyfoot.jsp" />
</html>