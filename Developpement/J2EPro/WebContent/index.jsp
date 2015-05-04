<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>La pâte de canard</title>
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
    <link rel="shortcut icon" href="inc/images/ico/favicon.ico">
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
								<li><a href="#"><i class="fa fa-phone"></i> +33 8 08 08 08 08</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i> contact@lapatedecanard.fr</a></li>
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
							<a href="index.html"><img src="inc/images/home/logo.png" alt="" /></a>
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
								<li><a href="index.jsp" class="active">Accueil</a></li>
								<li class="dropdown"><a href="#">Shop<i class="fa fa-angle-down"></i></a>
                                    <ul role="menu" class="sub-menu">
                                        <li><a href="shop.html">Products</a></li>
										<li><a href="product-details.html">Product Details</a></li> 
										<li><a href="checkout.html">Checkout</a></li> 
										<li><a href="cart.html">Cart</a></li> 
										<li><a href="login.html">Login</a></li> 
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
							<input type="text" placeholder="Recherche"/>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->
	
	<section id="slider"><!--slider-->
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div id="slider-carousel" class="carousel slide" data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
							<li data-target="#slider-carousel" data-slide-to="1"></li>
						</ol>
						
						<div class="carousel-inner">
							<div class="item active">
								<div class="col-sm-6">
									<h1><span>Le Magret </span>de canard</h1>
									<h2>Un plat classique pour vos repas</h2>
									<p>Le magret est un filet de viande maigre, découpé à partir de la poitrine d'une oie ou d'un canard gras, engraissé par gavage, les mêmes qui servent à produire le confit et le foie gras. Pouvant être séché ou fumé, coupé en fines tranches, il est le plus souvent servi saignant ou rosé après avoir été cuit au gril ou à la poêle. </p>
									<button type="button" class="btn btn-default get">Commander</button>
								</div>
								<div class="col-sm-6">
									<img src="inc/images/home/magret.jpg" class="girl img-responsive" alt="" />
								</div>
							</div>
							<div class="item">
								<div class="col-sm-6">
									<h1><span>Le Confit </span>de canard</h1>
									<h2>Le bon goût du Sud</h2>
									<p>Le confit de canard (ou le confit d'oie) est une spécialité culinaire du sud-ouest de la France, et plus spécifiquement de la Gascogne, du Périgord, du Quercy et du Languedoc.</p>
									<button type="button" class="btn btn-default get">Commander</button>
								</div>
								<div class="col-sm-6">
									<img src="inc/images/home/confit.jpg" class="girl img-responsive" alt="" />
								</div>
							</div>							
						</div>
						
						<a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
							<i class="fa fa-angle-left"></i>
						</a>
						<a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
							<i class="fa fa-angle-right"></i>
						</a>
					</div>
					
				</div>
			</div>
		</div>
	</section><!--/slider-->
	
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>Catégories</h2>
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->							
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#">Entrées</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#">Plats</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#">Desserts</a></h4>
								</div>
							</div>
						</div><!--/category-products-->					
					</div>
				</div>
				
				<div class="col-sm-9 padding-right">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">Articles</h2>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
										<div class="productinfo text-center">
											<img src="inc/images/home/product1.jpg" alt="" />
											<h2>$56</h2>
											<p>Easy Polo Black Edition</p>
											<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Ajouter au panier</a>
										</div>
										<div class="product-overlay">
											<div class="overlay-content">
												<h2>$56</h2>
												<p>Easy Polo Black Edition</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Ajouter au panier</a>
											</div>
										</div>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="inc/images/home/product2.jpg" alt="" />
										<h2>$56</h2>
										<p>Easy Polo Black Edition</p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Ajouter au panier</a>
									</div>
									<div class="product-overlay">
										<div class="overlay-content">
											<h2>$56</h2>
											<p>Easy Polo Black Edition</p>
											<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Ajouter au panier</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="inc/images/home/product3.jpg" alt="" />
										<h2>$56</h2>
										<p>Easy Polo Black Edition</p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Ajouter au panier</a>
									</div>
									<div class="product-overlay">
										<div class="overlay-content">
											<h2>$56</h2>
											<p>Easy Polo Black Edition</p>
											<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Ajouter au panier</a>
										</div>
									</div>
								</div>
							</div>
						</div>		
						
					</div><!--features_items-->					
				</div>
			</div>
		</div>
	</section>
	
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
	<script src="inc/js/bootstrap.min.js"></script>
	<script src="inc/js/jquery.scrollUp.min.js"></script>
	<script src="inc/js/price-range.js"></script>
    <script src="inc/js/jquery.prettyPhoto.js"></script>
    <script src="inc/js/main.js"></script>
</body>
</html>