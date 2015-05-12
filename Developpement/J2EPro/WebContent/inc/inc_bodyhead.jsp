<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="inc/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="inc/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="inc/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="inc/images/ico/apple-touch-icon-57-precomposed.png">
</head>
<!--/head-->

<body>
	<header id="header">
		<!--header-->
		<div class="header_top">
			<!--header_top-->
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
		</div>
		<!--/header_top-->

		<div class="header-middle">
			<!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="/J2EPro/accueil"><img src="inc/images/home/logo.png"
								alt="" /></a>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<c:if test="${!empty sessionScope.sessionClient}">
									<li><a href="Mon-compte"><i class="fa fa-user"></i> Mon compte</a></li>
								</c:if>
								<c:if test="${empty sessionScope.sessionClient}">
									<li><a href="creerClient"><i class="fa fa-crosshairs"></i>S'inscrire</a></li>
								</c:if>
								<li><a href="panier"><i class="fa fa-shopping-cart"></i>Panier</a></li>
								<c:import url="/inc/inc_connecte.jsp" />
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/header-middle-->

		<div class="header-bottom">
			<!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle"
								data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="/J2EPro/accueil">Accueil</a></li>
								<li class="dropdown"><a href="#">Menu<i
										class="fa fa-angle-down"></i></a>
									<ul role="menu" class="sub-menu">
										<li><a href="#">Produits</a></li>
										<li><a href="#">Détails des articles</a></li>
										<li><a href="monPanier.jsp">Panier</a></li>
									</ul></li>
								<li><a href="/J2EPro/mention">Mentions Légales</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="search_box pull-right">
							<input type="text" placeholder="Recherche" />
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/header-bottom-->
	</header>
	<!--/header-->