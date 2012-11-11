<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>ADMIN LOGADO</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<jsp:include page="../templates/barraSuperior.jsp" />

	<div class="row-fluid">
		<jsp:include page="../templates/menuLateralAdmin.jsp" />
		<div class="span8">
			<div id="myCarousel" class="carousel slide">
				<div class="carousel-inner">
					<div class="item">
						<img src="static/img/imagem_maca.jpg" alt="">
						<div class="carousel-caption">
							<h4>Consultas</h4>
							<p>Est&aacute; em d&uacute;vida de quantas calorias esta ingerindo nesta alimenta&ccedil;&atilde;o, n&atilde;o se preocupe nos lhe mostramos
						</div>
					</div>
					<div class="item">
						<img src="static/img/celular.jpg" alt="">
						<div class="carousel-caption">
							<h4>Confian&ccedil;a</h4>
							<p>Chega de se preocupar se as suas dietas foram preescritas por algu&eacute;m de confian&ccedil;a, aproveite as facilidades da era mobile e 
								adquira agora as melhores dietas cadastradas por m&eacute;dicos conceituados</p>
						</div>
					</div>
					<div class="item active">
						<img src="static/img/academia.jpg" alt="">
						<div class="carousel-caption">
						<h4>Portabilidade</h4>
							<p>Est&aacute; no treino e n&atilde;o se lembra o que voc&ecirc; deve comer depois, n&atilde;o tem problema com nosso aplicativo a sua dieta esta sempre com voc&ecirc;</p>
						</div>
					</div>
				</div>
				<a class="left carousel-control" href="#myCarousel"
					data-slide="prev">‹</a> <a class="right carousel-control"
					href="#myCarousel" data-slide="next">›</a>
			</div>
		</div>
		<!-- /span8 -->
	</div>
	<!-- /.row-fluid -->
</body>
</html>