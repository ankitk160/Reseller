<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Reseller Dashboard</title>
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
			<a class="navbar-brand text-uppercase text-reset" href="#">
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
		<c:if test="${not empty alertMessage}">
			<div class="alert alert-success">${alertMessage}</div>
		</c:if>
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
			<li class="sidebar-item active"><a class="sidebar-link"
				href="index"> <svg class="svg-icon svg-icon-sm svg-icon-heavy">
					<use xlink:href="#real-estate-1"> </use> </svg><span>Home </span>
			</a></li>
			<li class="sidebar-item"><a class="sidebar-link"
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
		<div class="page-content">
			<!-- Page Header-->
			<div class="bg-dash-dark-2 py-4">
				<div class="container-fluid">
					<h2 class="h5 mb-0">Dashboard</h2>

				</div>
			</div>
			<section>
			<div class="container-fluid">
				<div class="row gy-4">
					<div class="col-md-4 col-sm-6">
						<div class="card mb-0">
							<div class="card-body">
								<div class="d-flex align-items-end justify-content-between mb-2">
									<div class="me-2">
										<svg
											class="svg-icon svg-icon-sm svg-icon-heavy text-gray-600 mb-2">
										<use xlink:href="#browser-window-1"> </use> </svg>
										<p class="text-sm text-uppercase text-gray-600 lh-1 mb-0">App
											Traffic Service Info</p>
									</div>
									<p class="text-xxl lh-1 mb-0 text-dash-color-1">${countAppTSInfo}</p>
								</div>
								<div class="progress" style="height: 3px">
									<div class="progress-bar bg-dash-color-1" role="progressbar"
										style="width: ${countAppTSInfo}%" aria-valuenow=""
										aria-valuemin="0" aria-valuemax="100"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="card mb-0">
							<div class="card-body">
								<div class="d-flex align-items-end justify-content-between mb-2">
									<div class="me-2">
										<svg
											class="svg-icon svg-icon-sm svg-icon-heavy text-gray-600 mb-2">
										<use xlink:href="#chart-1"> </use> </svg>
										<p class="text-sm text-uppercase text-gray-600 lh-1 mb-0">App
											Campaign Details</p>
									</div>
									<p class="text-xxl lh-1 mb-0 text-dash-color-2">${countCampaignDetails}</p>
								</div>
								<div class="progress" style="height: 3px">
									<div class="progress-bar bg-dash-color-2" role="progressbar"
										style="width: ${countCampaignDetails}%" aria-valuenow=""
										aria-valuemin="0" aria-valuemax="100"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="card mb-0">
							<div class="card-body">
								<div class="d-flex align-items-end justify-content-between mb-2">
									<div class="me-2">
										<svg
											class="svg-icon svg-icon-sm svg-icon-heavy text-gray-600 mb-2">
										<use xlink:href="#portfolio-grid-1"> </use> </svg>
										<p class="text-sm text-uppercase text-gray-600 lh-1 mb-0">Switching
											Campaign</p>
									</div>
									<p class="text-xxl lh-1 mb-0 text-dash-color-3">${countSwitchingCampaign}</p>
								</div>
								<div class="progress" style="height: 3px">
									<div class="progress-bar bg-dash-color-3" role="progressbar"
										style="width: ${countSwitchingCampaign}%" aria-valuenow=""
										aria-valuemin="0" aria-valuemax="100"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="card mb-0">
							<div class="card-body">
								<div class="d-flex align-items-end justify-content-between mb-2">
									<div class="me-2">
										<svg
											class="svg-icon svg-icon-sm svg-icon-heavy text-gray-600 mb-2">
										<use xlink:href="#survey-1"> </use> </svg>
										<p class="text-sm text-uppercase text-gray-600 lh-1 mb-0">Operators</p>
									</div>
									<p class="text-xxl lh-1 mb-0 text-dash-color-4">${countOperator}</p>
								</div>
								<div class="progress" style="height: 3px">
									<div class="progress-bar bg-dash-color-4" role="progressbar"
										style="width: ${countOperator}%" aria-valuenow=""
										aria-valuemin="0" aria-valuemax="100"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="card mb-0">
							<div class="card-body">
								<div class="d-flex align-items-end justify-content-between mb-2">
									<div class="me-2">
										<svg
											class="svg-icon svg-icon-sm svg-icon-heavy text-gray-600 mb-2">
										<use xlink:href="#paper-stack-1"> </use> </svg>
										<p class="text-sm text-uppercase text-gray-600 lh-1 mb-0">Territory</p>
									</div>
									<p class="text-xxl lh-1 mb-0 text-dash-color-5">${countTerritory}</p>
								</div>
								<div class="progress" style="height: 3px">
									<div class="progress-bar bg-dash-color-5" role="progressbar"
										style="width: ${countTerritory}%" aria-valuenow=""
										aria-valuemin="0" aria-valuemax="100"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="card mb-0">
							<div class="card-body">
								<div class="d-flex align-items-end justify-content-between mb-2">
									<div class="me-2">
										<svg
											class="svg-icon svg-icon-sm svg-icon-heavy text-gray-600 mb-2">
										<use xlink:href="#sales-up-1"> </use> </svg>
										<p class="text-sm text-uppercase text-gray-600 lh-1 mb-0">Promoter</p>
									</div>
									<p class="text-xxl lh-1 mb-0 text-dash-color-6">${countPromoter}</p>
								</div>
								<div class="progress" style="height: 3px">
									<div class="progress-bar bg-dash-color-6" role="progressbar"
										style="width: ${countPromoter}%" aria-valuenow=""
										aria-valuemin="0" aria-valuemax="100"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6">
						<div class="card mb-0">
							<div class="card-body">
								<div class="d-flex align-items-end justify-content-between mb-2">
									<div class="me-2">
										<svg
											class="svg-icon svg-icon-sm svg-icon-heavy text-gray-600 mb-2">
										<use xlink:href="#imac-screen-1"> </use> </svg>
										<p class="text-sm text-uppercase text-gray-600 lh-1 mb-0">Partner</p>
									</div>
									<p class="text-xxl lh-1 mb-0 text-dash-color-7">${countPartner}</p>
								</div>
								<div class="progress" style="height: 3px">
									<div class="progress-bar bg-dash-color-7" role="progressbar"
										style="width: ${countPartner}%" aria-valuenow=""
										aria-valuemin="0" aria-valuemax="100"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			</section>
			<!-- Page Footer-->
			<footer
				class="position-absolute bottom-0 bg-dash-dark-2 text-white text-center py-3 w-100 text-xs"
				id="footer"> <!-- <div class="container-fluid text-center">
				Please do not remove the backlink to us unless you support us at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)
				<p class="mb-0 text-dash-gray">
					2021 &copy; Your company. Design by <a
						href="https://bootstrapious.com">Bootstrapious</a>.
				</p>
			</div> --> </footer>
		</div>
	</div>
	<!-- JavaScript files-->
	<script
		src="/reseller/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="/reseller/resources/vendor/just-validate/js/just-validate.min.js"></script>
	<!-- <script src="/reseller/resources/vendor/chart.js/Chart.min.js"></script> -->
	<script
		src="/reseller/resources/vendor/choices.js/public/assets/scripts/choices.min.js"></script>
	<!-- <script src="/reseller/resources/js/charts-home.js"></script> -->
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
	<!-- FontAwesome CSS - loading as last, so it doesn't block rendering-->
	<link rel="stylesheet"
		href="https://use.fontawesome.com/releases/v5.7.1/css/all.css"
		integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
		crossorigin="anonymous">
</body>
</html>