<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Mon Panier</title>
	</head>
	<body>
		<h1>Mon panier</h1>
		<p>
			<%  
	        com.dju.entities.Panier panier = (com.dju.entities.Panier) request.getAttribute("panier");
	        out.println( panier.getPrenom() );
            out.println( panier.getNom() );
            %>
		
            <% 
            String attribut = (String) request.getAttribute("test");
            out.println(attribut);
            %>
        </p>
	</body>
</html>