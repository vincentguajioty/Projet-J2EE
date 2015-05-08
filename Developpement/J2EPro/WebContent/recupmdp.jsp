<!DOCTYPE html>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Accueil | La pâte de canard</title>
<c:import url="/inc/inc_bodyhead.jsp" />
	<section id="form">
		<!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form">
						<!--login form-->
						<form method="post" action="<c:url value="/recupmdp"/>">
							<fieldset>
	              			  <legend>Récupération du mot de passe</legend>
	           			      <p>Récupérez votre mot de passe en renseignant le champ ci-dessous.</p>
		          			    <label for="email">Adresse email<span class="requis">*</span></label>
								<input type="email" id="email" name="email" value="" size="30" maxlength="60" />
	            			  <br />      
	             			  <input type="submit" value="Envoyer" class="sansLabel" />
	           				  <br />
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