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
	                <legend>Connexion</legend>
	                <p>Vous pouvez vous connecter via ce formulaire.</p>
	                <label for="nom">Adresse email <span class="requis">*</span></label>
	                <input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
	                <br />
	
	                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
	                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
	                <br />
	
	                <input type="submit" value="Connexion" class="sansLabel" />
	                <br />
	                <p><a href="<c:url value="/recupmdp.jsp"/>">J'ai oublié mon mot de passe !</a></p>
	            </fieldset>
	        </form>
        </div>
    </body>
</html>