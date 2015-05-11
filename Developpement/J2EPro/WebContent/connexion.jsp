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
					<div class="login-form">
						<!--login form-->
						<form method="post" action="<c:url value="/connexion"/>">
							<fieldset>
								<legend>Connexion</legend>
									<p>Vous pouvez vous connecter via ce formulaire.</p>
									<label for="emailClient">Adresse email<span class="requis">*</span></label>
									<input type="email" id="emailClient" name="emailClient" value="" size="30" maxlength="60" />
									<label for="motdepasse">Mot de passe <span class="requis">*</span></label> 
									<input type="password" id="mdp" name="motdepasse" value=""" size="20" maxlength="20" /> <br />
									<button type="submit" value="Connexion" class="btn btn-default">Connexion</button>
									<br />
							    <p>	<a href="<c:url value="/recupmdp"/>">J'ai oublié mon mot de passe !</a> </p>
							</fieldset>
						</form>
					</div>
					<!--/login form-->
				</div>
			</div>
		</div>
	</section>
	<!--/form-->
<c:import url="/inc/inc_bodyfoot.jsp" />
</html>