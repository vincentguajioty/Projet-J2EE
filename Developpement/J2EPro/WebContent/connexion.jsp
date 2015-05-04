<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Login | La pâte de canard</title>
    <link href="inc/bootstrap.min.css" rel="stylesheet">
    <link href="inc/font-awesome.min.css" rel="stylesheet">
    <link href="inc/prettyPhoto.css" rel="stylesheet">
    <link href="inc/price-range.css" rel="stylesheet">
    <link href="inc/animate.css" rel="stylesheet">
	<link href="inc/main.css" rel="stylesheet">
	<link href="inc/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="inc/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="inc/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="inc/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="inc/images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>
	<header id="header"><!--header-->
		<div class="header_top"><!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href=""><i class="fa fa-phone"></i> +33 8 08 08 08 08</a></li>
								<li><a href=""><i class="fa fa-envelope"></i> contact@lapatedecanard.fr</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header_top-->
		
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="index.jsp"><img src="inc/images/home/logo.png" alt="" /></a>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<li><a href="#"><i class="fa fa-user"></i> Mon compte</a></li>
								<li><a href="creerClient"><i class="fa fa-crosshairs"></i> S'inscrire</a></li>
								<li><a href="panier"><i class="fa fa-shopping-cart"></i> Panier</a></li>
								<li><a href="connexion"><i class="fa fa-lock"></i> Se connecter</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="index.jsp">Accueil</a></li>
								<li class="dropdown"><a href="#">Shop<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="shop.html">Products</a></li>
										<li><a href="product-details.html">Product Details</a></li> 
										<li><a href="checkout.html">Checkout</a></li> 
										<li><a href="cart.html">Cart</a></li> 
										<li><a href="login.html" class="active">Login</a></li> 
                                    </ul>
                                </li> 
								<li class="dropdown"><a href="#">Blog<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="blog.html">Blog List</a></li>
										<li><a href="blog-single.html">Blog Single</a></li>
                                    </ul>
                                </li> 
								<li><a href="404.html">404</a></li>
								<li><a href="contact-us.html">Contact</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="search_box pull-right">
							<input type="text" placeholder="Search"/>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->
	
	<section id="form"><!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form"><!--login form-->
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
			
			                <button type="submit" value="Connexion" class="btn btn-default">Connexion</button>
			                <br />
			                <p><a href="<c:url value="/recupmdp.jsp"/>">J'ai oublié mon mot de passe !</a></p>
			            </fieldset>
			        </form>
					</div><!--/login form-->
				</div>
				<!-- <div class="col-sm-1">
					<h2 class="or">OR</h2>
				</div>
				<div class="col-sm-4">
					<div class="signup-form">
						<h2>New User Signup!</h2>
						<form action="#">
							<input type="text" placeholder="Name"/>
							<input type="email" placeholder="Email Address"/>
							<input type="password" placeholder="Password"/>
							<button type="submit" class="btn btn-default">Signup</button>
						</form>
					</div><sign up form-->
				</div>
			</div>
	</section><!--/form-->
	
	
	<footer id="footer"><!--Footer-->		
		<div class="footer-bottom">
			<div class="container">
				<div class="row">
					<p class="pull-left">Copyright © 2015 La Pâte de Canard. Tous droits réservés.</p>
				</div>
			</div>
		</div>
	</footer><!--/Footer-->
	 
    <script src="inc/js/jquery.js"></script>
	<script src="inc/js/price-range.js"></script>
    <script src="inc/js/jquery.scrollUp.min.js"></script>
	<script src="inc/js/bootstrap.min.js"></script>
    <script src="inc/js/jquery.prettyPhoto.js"></script>
    <script src="inc/js/main.js"></script>
</body>
</html>