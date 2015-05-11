<!DOCTYPE html>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Login | La pâte de canard</title>
<c:import url="/inc/inc_bodyhead.jsp" />
	<section id="form">
		<!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
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
				</div>
			</div>
		</div>
	</section>
	<!--/form-->
<c:import url="/inc/inc_bodyfoot.jsp" />
</html>