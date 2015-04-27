<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
    </head>
    <body>
        <c:import url="/inc/menu.jsp" />
        <div>
	        <form method="post" action="connexion">
	            <fieldset>
	                <legend>Récupération du mot de passe</legend>
	                <p>Récupérez votre mot de passe en renseignant le champ ci-dessous.</p>
	
	                <label for="nom">Adresse email <span class="requis"></span></label>
	                <input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
	                <br />      
	                <input type="submit" value="Envoyer" class="sansLabel" />
	                <br />
	            </fieldset>
	        </form>
        </div>
    </body>
</html>