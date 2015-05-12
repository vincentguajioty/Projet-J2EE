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
											<img src="" alt="" />
											<h2>30€</h2>
											<p>Article 1</p>
											<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Ajouter au panier</a>
										</div>
										<div class="product-overlay">
											<div class="overlay-content">
												<h2>30€</h2>
												<p>Article 1</p>
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
										<img src="" alt="" />
										<h2>15€</h2>
										<p>Dessert 2</p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Ajouter au panier</a>
									</div>
									<div class="product-overlay">
										<div class="overlay-content">
											<h2>15€</h2>
											<p>Dessert 2</p>
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
										<img src="" alt="" />
										<h2>25,50€</h2>
										<p>Article 2</p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Ajouter au panier</a>
									</div>
									<div class="product-overlay">
										<div class="overlay-content">
											<h2>25,50€</h2>
											<p>Article 2</p>
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
<c:import url="/inc/inc_bodyfoot.jsp" />
</html>