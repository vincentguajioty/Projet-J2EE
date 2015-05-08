<!DOCTYPE html>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Inscription | La pâte de canard</title>
<c:import url="/inc/inc_bodyhead.jsp" />
	<section id="form">
		<!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="signup-form">
						<!--sign up form-->
						<div>
							<form method="post" action="<c:url value="/creerClient"/>">
								<fieldset>
									<legend>Inscription</legend>
									<c:import url="/inc/inc_client_form.jsp" />
								</fieldset>
								<button type="submit" value="S'inscrire" class="btn btn-default">S'inscrire</button>
								<br /> <input type="reset" value="Remettre à zéro" /> <br />
							</form>
						</div>
					</div>
					<!--/sign up form-->
				</div>
			</div>
		</div>
	</section>
	<!--/form-->
<c:import url="/inc/inc_bodyfoot.jsp" />
</html>