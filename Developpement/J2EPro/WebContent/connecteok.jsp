<!DOCTYPE html>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Connection | La pâte de canard</title>
<c:import url="/inc/inc_bodyhead.jsp" />
	<section id="form">
		<!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
        <div id="corps">
            <p class="info">${ message }</p>
            <c:if test="${ !erreur }">
            	 <c:if test="${!empty sessionScope.sessionClient}">
	                <p>Email : <c:out value="${ sessionScope.sessionClient.mailCli }"/></p>
	                <p>Mot de passe : <c:out value="${ sessionScope.sessionClient.mdpCli }"/> </p>
	             </c:if>
            </c:if>
        </div>
				</div>
			</div>
		</div>
	</section>
	<!--/form-->
<c:import url="/inc/inc_bodyfoot.jsp" />
</html>