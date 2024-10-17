<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Add App Service Traffic Info</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
<!-- Choices.js-->
<link rel="stylesheet"
	href="/reseller/resources/vendor/choices.js/public/assets/styles/choices.min.css">
<!-- Google fonts - Muli-->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Muli:300,400,700">
<!-- theme stylesheet-->
<link rel="stylesheet" href="/reseller/resources/css/style.default.css"
	id="theme-stylesheet">
<!-- Custom stylesheet - for your changes-->
<link rel="stylesheet" href="/reseller/resources/css/custom.css">
<!-- Favicon-->
<link rel="shortcut icon" href="/reseller/resources/img/favicon.ico">
<!-- Jquery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- FontAwesome CSS - loading as last, so it doesn't block rendering-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.1/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
<!-- Tweaks for older IEs-->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<body>
	<header class="header"> <nav
		class="navbar navbar-expand-lg py-3 bg-dash-dark-2 border-bottom border-dash-dark-1 z-index-10">
	<div
		class="container-fluid d-flex align-items-center justify-content-between py-1">
		<div class="navbar-header d-flex align-items-center">
			<a class="navbar-brand text-uppercase text-reset" href="index">
				<div class="brand-text brand-big">
					<strong class="text-primary">Reseller</strong><strong>Dashboard</strong>
				</div>
				<div class="brand-text brand-sm">
					<strong class="text-primary">R</strong><strong>D</strong>
				</div>
			</a>
			<button class="sidebar-toggle">
				<svg class="svg-icon svg-icon-sm svg-icon-heavy transform-none">
				<use xlink:href="#arrow-left-1"> </use> </svg>
			</button>
		</div>
		<ul class="list-inline mb-0">
			<li class="list-inline-item logout px-lg-2"><a
				class="nav-link text-sm text-reset px-1 px-lg-0" id="logout"
				href="logout"> <span class="d-none d-sm-inline-block">Logout
				</span> <svg class="svg-icon svg-icon-xs svg-icon-heavy"> <use
						xlink:href="#disable-1"> </use> </svg></a></li>
		</ul>
	</div>
	</nav> </header>
	<div class="d-flex align-items-stretch">
		<!-- Sidebar Navigation-->
		<nav id="sidebar"> <!-- Sidebar Header--> <span
			class="text-uppercase text-gray-600 text-xs mx-3 px-2 heading mb-2">Main</span>
		<ul class="list-unstyled">
			<li class="sidebar-item"><a class="sidebar-link" href="index">
					<svg class="svg-icon svg-icon-sm svg-icon-heavy"> <use
						xlink:href="#real-estate-1"> </use> </svg><span>Home </span>
			</a></li>
			<li class="sidebar-item active"><a class="sidebar-link"
				href="#exampledropdownDropdown1" data-bs-toggle="collapse"> <svg
						class="svg-icon svg-icon-sm svg-icon-heavy"> <use
						xlink:href="#browser-window-1"> </use> </svg><span>App Traffic
						Service Info </span></a>
				<ul class="collapse list-unstyled " id="exampledropdownDropdown1">
					<li><a class="sidebar-link" href="viewAppTrafficServiceInfo">View
							App Traffic Service Info</a></li>
					<li><a class="sidebar-link" href="addAppTrafficServiceInfo">Add
							App Traffic Service Info</a></li>
				</ul></li>
			<li class="sidebar-item"><a class="sidebar-link"
				href="#exampledropdownDropdown6" data-bs-toggle="collapse"> <svg
						class="svg-icon svg-icon-sm svg-icon-heavy"> <use
						xlink:href="#chart-1"> </use> </svg><span>App Campaign Details </span></a>
				<ul class="collapse list-unstyled " id="exampledropdownDropdown6">
					<li><a class="sidebar-link" href="viewAppCampaignDetails">View
							App Campaign Details</a></li>
					<li><a class="sidebar-link" href="addAppCampaignDetails">Add
							App Campaign Details</a></li>
				</ul></li>
			<li class="sidebar-item"><a class="sidebar-link"
				href="#exampledropdownDropdown7" data-bs-toggle="collapse"> <svg
						class="svg-icon svg-icon-sm svg-icon-heavy"> <use
						xlink:href="#portfolio-grid-1"> </use> </svg><span>Switching
						Campaign </span></a>
				<ul class="collapse list-unstyled " id="exampledropdownDropdown7">
					<li><a class="sidebar-link" href="viewSwitchingCampaign">View
							Switching Campaign</a></li>
					<li><a class="sidebar-link" href="addSwitchingCampaign">Add
							Switching Campaign</a></li>
				</ul></li>
			<li class="sidebar-item"><a class="sidebar-link"
				href="#exampledropdownDropdown2" data-bs-toggle="collapse"> <svg
						class="svg-icon svg-icon-sm svg-icon-heavy"> <use
						xlink:href="#survey-1"> </use> </svg><span>Operator </span></a>
				<ul class="collapse list-unstyled " id="exampledropdownDropdown2">
					<li><a class="sidebar-link" href="viewOperator">View
							Operator</a></li>
					<li><a class="sidebar-link" href="addOperator">Add
							Operator</a></li>
				</ul></li>
			<li class="sidebar-item"><a class="sidebar-link"
				href="#exampledropdownDropdown3" data-bs-toggle="collapse"> <svg
						class="svg-icon svg-icon-sm svg-icon-heavy"> <use
						xlink:href="#paper-stack-1"> </use> </svg><span>Territory </span></a>
				<ul class="collapse list-unstyled " id="exampledropdownDropdown3">
					<li><a class="sidebar-link" href="viewTerritory">View
							Territory</a></li>
					<li><a class="sidebar-link" href="addTerritory">Add
							Territory</a></li>
				</ul></li>
			<li class="sidebar-item"><a class="sidebar-link"
				href="#exampledropdownDropdown4" data-bs-toggle="collapse"> <svg
						class="svg-icon svg-icon-sm svg-icon-heavy"> <use
						xlink:href="#sales-up-1"> </use> </svg><span>Promoter </span></a>
				<ul class="collapse list-unstyled " id="exampledropdownDropdown4">
					<li><a class="sidebar-link" href="viewPromoter">View
							Promoter</a></li>
					<li><a class="sidebar-link" href="addPromoter">Add
							Promoter</a></li>
				</ul></li>
			<li class="sidebar-item"><a class="sidebar-link"
				href="#exampledropdownDropdown5" data-bs-toggle="collapse"> <svg
						class="svg-icon svg-icon-sm svg-icon-heavy"> <use
						xlink:href="#imac-screen-1"> </use> </svg><span>Partner </span></a>
				<ul class="collapse list-unstyled " id="exampledropdownDropdown5">
					<li><a class="sidebar-link" href="viewPartner">View
							Partner</a></li>
					<li><a class="sidebar-link" href="addPartner">Add Partner</a></li>
				</ul></li>
		</ul>
		</nav>
		<div class="page-content form-page">
			<!-- Page Header-->
			<div class="bg-dash-dark-2 py-4">
				<div class="container-fluid">
					<h2 class="h5 mb-0">Add App Service Traffic Info</h2>
				</div>
			</div>
			<!-- Breadcrumb-->
			<div class="container-fluid py-2">
				<nav aria-label="breadcrumb">
				<ol class="breadcrumb mb-0 py-3 px-0">
					<li class="breadcrumb-item"><a href="index">Home</a></li>
					<li class="breadcrumb-item active" aria-current="page">Add App
						Service Traffic Info</li>
				</ol>
				</nav>
			</div>
			<!-- Forms Section-->
			<section class="pt-0">
			<div class="container-fluid">
				<div class="row gy-4">
					<!-- Form Elements -->
					<div class="col-lg-12">
						<c:if test="${not empty alertMessage}">
							<div class="alert alert-success">${alertMessage}</div>
						</c:if>
						<div class="card">
							<div class="card-header">
								<h3 class="h4 mb-0">Fill below fields</h3>
							</div>
							<div class="card-body pt-0">
								<form class="form-horizontal"
									action="insertAppTrafficServiceInfo" method="post">
									<div class="row">
										<label class="col-sm-3 form-label">Optimize %age</label>
										<div class="col-sm-9">
											<input class="form-control" type="number" name="optimizePerc"
												value="0" min="0" step="10" max="100"
												placeholder="Enter Optimize %age Here..." required>
										</div>
									</div>
									<div class="my-4"></div>
									<div class="row">
										<label class="col-sm-3 form-label">Optimize Flag</label>
										<div class="col-sm-9">
											<input class="form-control" type="text" name="optimizeFlag"
												value="N" placeholder="Enter Optimize Flag Here..." required>
										</div>
									</div>
									<div class="my-4"></div>
									<div class="row">
										<label class="col-sm-3 form-label">Association Type</label>
										<div class="col-sm-9">
											<input class="form-control" type="text"
												name="associationType" value="1001"
												placeholder="Enter Association Type Here..." required>
										</div>
									</div>
									<div class="my-4"></div>
									<div class="row">
										<label class="col-sm-3 form-label">Price</label>
										<div class="col-sm-9">
											<div class="input-group mb-3">
												<span class="input-group-text">$</span><span
													class="input-group-text">0.000</span> <input
													class="form-control" type="number" name="price" min="0"
													value="0.000" step=".001" required>
											</div>
										</div>
									</div>
									<div class="my-4"></div>
									<div class="row">
										<label class="col-sm-3 form-label">Bid Rate</label>
										<div class="col-sm-9">
											<div class="input-group mb-3">
												<span class="input-group-text">$</span><span
													class="input-group-text">0.00</span> <input
													class="form-control" type="number" name="bidrate" min="0"
													value="0" step=".01" required>
											</div>
										</div>
									</div>
									<div class="my-4"></div>
									<div class="row">
										<label class="col-sm-3 form-label">Select Territory</label>
										<div class="col-sm-9">
											<select class="form-select mb-3" name="territoryid"
												id="territoryid" required>
												<option selected="selected">-Select Territory-</option>
												<c:forEach items="${territoryList}" var="territory">
													<option value="${territory.id}">${territory.id}-
														${territory.name}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="my-4"></div>
									<div class="row">
										<label class="col-sm-3 form-label">Select Operator ID</label>
										<div class="col-sm-9">
											<select class="form-select mb-3" name="operatorid"
												id="operatorid" required>
											</select>
										</div>
									</div>
									<div class="my-4"></div>
									<div class="row">
										<label class="col-sm-3 form-label">Select App Campaign</label>
										<div class="col-sm-9">
											<select class="form-select mb-3" name="partnerid"
												id="appcampaign" required>
											</select>
										</div>
									</div>
									<div class="my-4"></div>
									<div class="row">
										<label class="col-sm-3 form-label">Select Promoter</label>
										<div class="col-sm-9">
											<select class="form-select mb-3" name="PromoterName" required>
												<c:forEach items="${promoterList}" var="promoter">
													<option value="${promoter.id}">${promoter.id}-
														${promoter.name}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="my-4"></div>
									<div class="row">
										<div class="col-sm-9 ms-auto">
											<button class="btn btn-primary" type="submit">Submit
												Data</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Page Footer--> <footer
				class="position-absolute bottom-0 bg-dash-dark-2 text-white text-center py-3 w-100 text-xs"
				id="footer">
			<div class="container-fluid text-center">
				<!-- Please do not remove the backlink to us unless you support us at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
				<!-- <p class="mb-0 text-dash-gray">
					2021 &copy; Your company. Design by <a
						href="https://bootstrapious.com">Bootstrapious</a>.
				</p> -->
			</div>
			</footer> </section>
		</div>
	</div>
	<!-- JavaScript files-->
	<script
		src="/reseller/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="/reseller/resources/vendor/just-validate/js/just-validate.min.js"></script>
	<script src="/reseller/resources/vendor/chart.js/Chart.min.js"></script>
	<script
		src="/reseller/resources/vendor/choices.js/public/assets/scripts/choices.min.js"></script>
	<!-- Main File-->
	<script src="/reseller/resources/js/front.js"></script>
	<script>
		// ------------------------------------------------------- //
		//   Inject SVG Sprite - 
		//   see more here 
		//   https://css-tricks.com/ajaxing-svg-sprite/
		// ------------------------------------------------------ //
		function injectSvgSprite(path) {

			var ajax = new XMLHttpRequest();
			ajax.open("GET", path, true);
			ajax.send();
			ajax.onload = function(e) {
				var div = document.createElement("div");
				div.className = 'd-none';
				div.innerHTML = ajax.responseText;
				document.body.insertBefore(div, document.body.childNodes[0]);
			}
		}
		// this is set to BootstrapTemple website as you cannot 
		// inject local SVG sprite (using only 'icons/orion-svg-sprite.svg' path)
		// while using file:// protocol
		// pls don't forget to change to your domain :)
		injectSvgSprite('https://bootstraptemple.com/files/icons/orion-svg-sprite.svg');
	</script>
	<script>
		$('#territoryid').on(
				'change',
				function() {
					var selectedTerritoryId = this.value;
					$.ajax({
						type : "POST",
						url : "getOperatorByTerritoryId",
						data : selectedTerritoryId,
						dataType : "html",
						contentType : "application/text",
						success : function(result) {
							var jsonResult = JSON.parse(result);
							var operatorid = $("#operatorid");
							operatorid.empty();
							operatorid.append($("<option>").text(
									"-Select Operator-"));
							$.each(jsonResult, function(index, item) {
								var option = $("<option>").val(item.id).text(
										item.id + " - " + item.name);
								operatorid.append(option);
							});
						}
					});
				});
	</script>
	<script>
		$('#operatorid').on(
				'change',
				function() {
					var selectedOperatorId = this.value;
					$.ajax({
						type : "POST",
						url : "getAppCampaignByOperatorId",
						data : selectedOperatorId,
						dataType : "html",
						contentType : "application/text",
						success : function(result) {
							var jsonResult = JSON.parse(result);
							var appcampaign = $("#appcampaign");
							appcampaign.empty();
							$.each(jsonResult, function(index, item) {
								var option = $("<option>").val(item.id).text(
										item.id + " - " + item.campaign_name);
								appcampaign.append(option);
							});
						}
					});
				});
	</script>
</body>
</html>