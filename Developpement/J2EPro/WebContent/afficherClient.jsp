<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Affichage d'un client</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
    </head>
    <body>
        <c:import url="/inc/menu.jsp" />
        <div id="corps">
            <p class="info">${ message }</p>
            <c:if test="${ !erreur }">
                <p>Nom : <c:out value="${ client.nomCli }"/></p>
                <p>Prénom : <c:out value="${ client.prenomCli }"/></p>
                <p>Adresse : <c:out value="${ client.adresseCli }"/></p>
                <p>Numéro de téléphone : <c:out value="${ client.telCli }"/></p>
                <p>Email : <c:out value="${ client.mailCli }"/></p>
                <p>Date de naissance : <c:out value="${ client.datenaiss }"/></p>
                <p>Mot de passe : <c:out value="${ client.mdpCli }"/> <b>Conservez le précieusement !</b> </p>
            </c:if>
        </div>
    </body>
</html>