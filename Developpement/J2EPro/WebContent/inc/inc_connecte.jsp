<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${empty sessionScope.sessionClient}">
		<li><a href="connexion"><i class="fa fa-lock"></i>Se connecter</a></li>
	</c:when>
	<c:when test="${!empty sessionScope.sessionClient}">
		<li><a href="deconnexion"><i class="fa fa-lock"></i>Se déconnecter (<c:out value="${ sessionScope.sessionClient.nomCli }"/> <c:out value="${ sessionScope.sessionClient.prenomCli }"/>)</a></li>
	</c:when>
</c:choose>