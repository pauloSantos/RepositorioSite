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
							<h4>Teste1</h4>
							<p>Minha primeira imagem.</p>
						</div>
					</div>
					<div class="item">
						<img src="static/img/celular.jpg" alt="">
						<div class="carousel-caption">
							<h4>Teste2</h4>
							<p>Cras justo odio, dapibus ac facilisis in, egestas eget
								quam. Donec id elit non mi porta gravida at eget metus. Nullam
								id dolor id nibh ultricies vehicula ut id elit.</p>
						</div>
					</div>
					<div class="item active">
						<img src="static/img/academia.jpg" alt="">
						<div class="carousel-caption">
							<h4>Teste3</h4>
							<p>Cras justo odio, dapibus ac facilisis in, egestas eget
								quam. Donec id elit non mi porta gravida at eget metus. Nullam
								id dolor id nibh ultricies vehicula ut id elit.</p>
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