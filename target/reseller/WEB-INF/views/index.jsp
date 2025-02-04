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
					<div class="col-md-3 col-sm-6">
						<div class="card mb-0">
							<div class="card-body">
								<div class="d-flex align-items-end justify-content-between mb-2">
									<div class="me-2">
										<svg
											class="svg-icon svg-icon-sm svg-icon-heavy text-gray-600 mb-2">
										<use xlink:href="#user-1"> </use> </svg>
										<p class="text-sm text-uppercase text-gray-600 lh-1 mb-0">New
											Clients</p>
									</div>
									<p class="text-xxl lh-1 mb-0 text-dash-color-1">27</p>
								</div>
								<div class="progress" style="height: 3px">
									<div class="progress-bar bg-dash-color-1" role="progressbar"
										style="width: 30%" aria-valuenow="30" aria-valuemin="0"
										aria-valuemax="100"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-3 col-sm-6">
						<div class="card mb-0">
							<div class="card-body">
								<div class="d-flex align-items-end justify-content-between mb-2">
									<div class="me-2">
										<svg
											class="svg-icon svg-icon-sm svg-icon-heavy text-gray-600 mb-2">
										<use xlink:href="#stack-1"> </use> </svg>
										<p class="text-sm text-uppercase text-gray-600 lh-1 mb-0">New
											Projects</p>
									</div>
									<p class="text-xxl lh-1 mb-0 text-dash-color-2">375</p>
								</div>
								<div class="progress" style="height: 3px">
									<div class="progress-bar bg-dash-color-2" role="progressbar"
										style="width: 70%" aria-valuenow="70" aria-valuemin="0"
										aria-valuemax="100"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-3 col-sm-6">
						<div class="card mb-0">
							<div class="card-body">
								<div class="d-flex align-items-end justify-content-between mb-2">
									<div class="me-2">
										<svg
											class="svg-icon svg-icon-sm svg-icon-heavy text-gray-600 mb-2">
										<use xlink:href="#survey-1"> </use> </svg>
										<p class="text-sm text-uppercase text-gray-600 lh-1 mb-0">New
											Invoices</p>
									</div>
									<p class="text-xxl lh-1 mb-0 text-dash-color-3">140</p>
								</div>
								<div class="progress" style="height: 3px">
									<div class="progress-bar bg-dash-color-3" role="progressbar"
										style="width: 55%" aria-valuenow="55" aria-valuemin="0"
										aria-valuemax="100"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-3 col-sm-6">
						<div class="card mb-0">
							<div class="card-body">
								<div class="d-flex align-items-end justify-content-between mb-2">
									<div class="me-2">
										<svg
											class="svg-icon svg-icon-sm svg-icon-heavy text-gray-600 mb-2">
										<use xlink:href="#paper-stack-1"> </use> </svg>
										<p class="text-sm text-uppercase text-gray-600 lh-1 mb-0">All
											Projects</p>
									</div>
									<p class="text-xxl lh-1 mb-0 text-dash-color-4">41</p>
								</div>
								<div class="progress" style="height: 3px">
									<div class="progress-bar bg-dash-color-4" role="progressbar"
										style="width: 35%" aria-valuenow="35" aria-valuemin="0"
										aria-valuemax="100"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			</section>
			<section class="pt-0">
			<div class="container-fluid">
				<div class="row gy-4">
					<div class="col-lg-4">
						<div class="card">
							<div class="card-body">
								<canvas id="barChartExample1"></canvas>
							</div>
						</div>
						<div class="card">
							<div class="card-body">
								<canvas id="barChartExample2"></canvas>
							</div>
						</div>
					</div>
					<div class="col-lg-8">
						<div class="card">
							<div class="card-body">
								<canvas id="lineChart"></canvas>
							</div>
						</div>
					</div>
				</div>
			</div>
			</section>
			<section class="pt-0">
			<div class="container-fluid">
				<div class="row gy-4">
					<div class="col-lg-6">
						<!-- Stat card-->
						<div class="card mb-4">
							<div class="card-body">
								<div class="row gx-sm-5">
									<div class="col-6 border-sm-end border-dash-dark-1">
										<!-- Stat item-->
										<div class="d-flex">
											<i class="mt-3 fas fa-caret-down text-danger"></i>
											<div class="ms-2">
												<p class="text-xl fw-normal mb-0">5.657</p>
												<p class="text-uppercase text-sm fw-light mb-2">Standard
													scans</p>
												<div class="progress" style="height: 2px">
													<div class="progress-bar bg-dash-color-1"
														role="progressbar" style="width: 60%;" aria-valuenow="60"
														aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="col-6">
										<!-- Stat item-->
										<div class="d-flex">
											<i class="mt-3 fas fa-caret-up text-success"></i>
											<div class="ms-2">
												<p class="text-xl fw-normal mb-0">3.1459</p>
												<p class="text-uppercase text-sm fw-light mb-2">Team
													Scans</p>
												<div class="progress" style="height: 2px">
													<div class="progress-bar bg-dash-color-2"
														role="progressbar" style="width: 35%;" aria-valuenow="35"
														aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- Stat card-->
						<div class="card">
							<div class="card-body">
								<div class="row gx-5">
									<div class="col-6 border-sm-end border-dash-dark-1">
										<!-- Stat item-->
										<div class="d-flex">
											<div>
												<p class="text-xl fw-normal mb-0">745</p>
												<p class="text-uppercase text-sm fw-light mb-2">Total
													requests</p>
												<div class="progress" style="height: 2px">
													<div class="progress-bar bg-dash-color-1"
														role="progressbar" style="width: 60%;" aria-valuenow="60"
														aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="col-6">
										<div class="d-flex justify-content-center text-center">
											<div class="px-3 px-lg-4">
												<p class="text-lg fw-normal mb-0">4.124</p>
												<span class="text-sm text-uppercase mb-0">Threats</span>
												<hr class="border-dark-1 mx-auto my-2"
													style="max-width: 3rem">
												<small>+246</small>
											</div>
											<div class="px-3 px-lg-4">
												<p class="text-lg fw-normal mb-0">2.147</p>
												<span class="text-sm text-uppercase mb-0">Neutral</span>
												<hr class="border-dark-1 mx-auto my-2"
													style="max-width: 3rem">
												<small>+416</small>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="card">
							<div class="card-body">
								<canvas id="lineChart1"></canvas>
							</div>
						</div>
					</div>
				</div>
			</div>
			</section>
			<section class="pt-0">
			<div class="container-fluid">
				<div class="row gy-4">
					<div class="col-lg-4">
						<!-- User block-->
						<div class="card">
							<div class="card-body">
								<div class="text-center">
									<div class="position-relative d-inline-block">
										<img class="avatar avatar-lg mb-3"
											src="/reseller/resources/img/avatar-1.jpg"
											alt="Richard Nevoreski"><span
											class="avatar-badge bg-dash-color-1">1st</span>
									</div>
									<h3 class="h5 mb-0">Richard Nevoreski</h3>
									<p class="text-sm fw-light">@richardnevo</p>
									<div
										class="d-inline-block py-1 px-4 rounded-pill bg-dash-dark-3 fw-light text-sm mb-4">950
										Contributions</div>
									<ul
										class="list-inline text-center mb-0 d-flex justify-content-between text-sm mb-0">
										<li class="list-inline-item"><i
											class="fab fa-blogger-b me-2"></i>150</li>
										<li class="list-inline-item"><i
											class="fas fa-code-branch me-2"></i>340</li>
										<li class="list-inline-item"><i class="fab fa-gg me-2"></i>460</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<!-- User block-->
						<div class="card">
							<div class="card-body">
								<div class="text-center">
									<div class="position-relative d-inline-block">
										<img class="avatar avatar-lg mb-3"
											src="/reseller/resources/img/avatar-4.jpg"
											alt="Samuel Watson"><span
											class="avatar-badge bg-dash-color-2">2nd</span>
									</div>
									<h3 class="h5 mb-0">Samuel Watson</h3>
									<p class="text-sm fw-light">@samwatson</p>
									<div
										class="d-inline-block py-1 px-4 rounded-pill bg-dash-dark-3 fw-light text-sm mb-4">772
										Contributions</div>
									<ul
										class="list-inline text-center mb-0 d-flex justify-content-between text-sm mb-0">
										<li class="list-inline-item"><i
											class="fab fa-blogger-b me-2"></i>80</li>
										<li class="list-inline-item"><i
											class="fas fa-code-branch me-2"></i>420</li>
										<li class="list-inline-item"><i class="fab fa-gg me-2"></i>272</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<!-- User block-->
						<div class="card">
							<div class="card-body">
								<div class="text-center">
									<div class="position-relative d-inline-block">
										<img class="avatar avatar-lg mb-3"
											src="/reseller/resources/img/avatar-6.jpg"
											alt="Sebastian Wood"><span
											class="avatar-badge bg-dash-color-3">3rd</span>
									</div>
									<h3 class="h5 mb-0">Sebastian Wood</h3>
									<p class="text-sm fw-light">@sebastian</p>
									<div
										class="d-inline-block py-1 px-4 rounded-pill bg-dash-dark-3 fw-light text-sm mb-4">620
										Contributions</div>
									<ul
										class="list-inline text-center mb-0 d-flex justify-content-between text-sm mb-0">
										<li class="list-inline-item"><i
											class="fab fa-blogger-b me-2"></i>150</li>
										<li class="list-inline-item"><i
											class="fas fa-code-branch me-2"></i>280</li>
										<li class="list-inline-item"><i class="fab fa-gg me-2"></i>190</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="col-12">
						<div class="card">
							<div class="card-body">
								<div class="row gy-3 align-items-center">
									<div class="col-lg-4">
										<div class="d-flex align-items-center">
											<strong class="text-sm d-none d-lg-block">4th</strong><img
												class="avatar ms-3"
												src="/reseller/resources/img/avatar-1.jpg"
												alt="Tomas Hecktor">
											<div class="ms-3">
												<h3 class="h5 mb-0">Tomas Hecktor</h3>
												<p class="text-sm fw-light mb-0">@tomhecktor</p>
											</div>
										</div>
									</div>
									<div class="col-lg-4 text-center">
										<div
											class="d-inline-block py-1 px-4 rounded-pill bg-dash-dark-3 fw-light text-sm">410
											Contributions</div>
									</div>
									<div class="col-lg-4">
										<ul
											class="list-inline text-center mb-0 d-flex justify-content-between mb-0 text-sm">
											<li class="list-inline-item"><i
												class="fab fa-blogger-b me-2"></i>110</li>
											<li class="list-inline-item"><i
												class="fas fa-code-branch me-2"></i>200</li>
											<li class="list-inline-item"><i class="fab fa-gg me-2"></i>100</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-12">
						<div class="card">
							<div class="card-body">
								<div class="row gy-3 align-items-center">
									<div class="col-lg-4">
										<div class="d-flex align-items-center">
											<strong class="text-sm d-none d-lg-block">5th</strong><img
												class="avatar ms-3"
												src="/reseller/resources/img/avatar-2.jpg"
												alt="Alexander Shelby">
											<div class="ms-3">
												<h3 class="h5 mb-0">Alexander Shelby</h3>
												<p class="text-sm fw-light mb-0">@alexshelby</p>
											</div>
										</div>
									</div>
									<div class="col-lg-4 text-center">
										<div
											class="d-inline-block py-1 px-4 rounded-pill bg-dash-dark-3 fw-light text-sm">320
											Contributions</div>
									</div>
									<div class="col-lg-4">
										<ul
											class="list-inline text-center mb-0 d-flex justify-content-between mb-0 text-sm">
											<li class="list-inline-item"><i
												class="fab fa-blogger-b me-2"></i>150</li>
											<li class="list-inline-item"><i
												class="fas fa-code-branch me-2"></i>120</li>
											<li class="list-inline-item"><i class="fab fa-gg me-2"></i>50</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-12">
						<div class="card">
							<div class="card-body">
								<div class="row gy-3 align-items-center">
									<div class="col-lg-4">
										<div class="d-flex align-items-center">
											<strong class="text-sm d-none d-lg-block">6th</strong><img
												class="avatar ms-3"
												src="/reseller/resources/img/avatar-6.jpg"
												alt="Arther Kooper">
											<div class="ms-3">
												<h3 class="h5 mb-0">Arther Kooper</h3>
												<p class="text-sm fw-light mb-0">@artherkooper</p>
											</div>
										</div>
									</div>
									<div class="col-lg-4 text-center">
										<div
											class="d-inline-block py-1 px-4 rounded-pill bg-dash-dark-3 fw-light text-sm">170
											Contributions</div>
									</div>
									<div class="col-lg-4">
										<ul
											class="list-inline text-center mb-0 d-flex justify-content-between mb-0 text-sm">
											<li class="list-inline-item"><i
												class="fab fa-blogger-b me-2"></i>60</li>
											<li class="list-inline-item"><i
												class="fas fa-code-branch me-2"></i>70</li>
											<li class="list-inline-item"><i class="fab fa-gg me-2"></i>40</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			</section>
			<section class="pt-0">
			<div class="container-fluid">
				<div class="row d-flex align-items-stretch gy-4">
					<div class="col-lg-4">
						<!-- Sales bar chart-->
						<div class="card">
							<div class="card-body">
								<h3 class="h4 mb-0">Sales Difference</h3>
								<p class="text-sm fw-light">Lorem ipsum dolor sit</p>
								<div class="row align-items-end">
									<div class="col-lg-5">
										<p class="text-xl fw-light mb-0 text-dash-color-3">$740</p>
										<span class="d-block">May 2017</span><small class="d-block">
											320 Sales</small>
									</div>
									<div class="col-lg-7">
										<canvas id="salesBarChart1"></canvas>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<!-- Sales bar chart-->
						<div class="card">
							<div class="card-body">
								<h3 class="h4 mb-0">Visit Statistics</h3>
								<p class="text-sm fw-light">Lorem ipsum dolor sit</p>
								<div class="row align-items-end">
									<div class="col-lg-5">
										<p class="text-xl fw-light mb-0 text-dash-color-1">$457</p>
										<span class="d-block">May 2017</span><small class="d-block">
											210 Sales</small>
									</div>
									<div class="col-lg-7">
										<canvas id="visitPieChart"></canvas>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<!-- Sales bar chart-->
						<div class="card">
							<div class="card-body">
								<h3 class="h4 mb-0">Sales Activities</h3>
								<p class="text-sm fw-light">Lorem ipsum dolor sit</p>
								<div class="row align-items-end">
									<div class="col-lg-5">
										<p class="text-xl fw-light mb-0 text-dash-color-4">80%</p>
										<span class="d-block">May 2017</span><small class="d-block">
											+35 Sales</small>
									</div>
									<div class="col-lg-7">
										<canvas id="salesBarChart2"></canvas>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			</section>
			<section class="pt-0">
			<div class="container-fluid">
				<div class="row gy-4">
					<div class="col-lg-6">
						<div class="card">
							<div class="card-body">
								<h3 class="h4 mb-3">To do list</h3>
								<form id="checkListForm">
									<div class="p-3">
										<div class="form-check mb-0 py-1">
											<input class="form-check-input" type="checkbox"
												name="input-1" id="input-1" checked> <label
												class="form-check-label text-gray-600 text-sm" for="input-1">Lorem
												ipsum dolor sit amet, consectetur adipisicing elit.</label>
										</div>
									</div>
									<div class="p-3 bg-dash-dark-3">
										<div class="form-check mb-0 py-1">
											<input class="form-check-input" type="checkbox"
												name="input-2" id="input-2" checked> <label
												class="form-check-label text-gray-600 text-sm" for="input-2">Lorem
												ipsum dolor sit amet, consectetur adipisicing elit.</label>
										</div>
									</div>
									<div class="p-3">
										<div class="form-check mb-0 py-1">
											<input class="form-check-input" type="checkbox"
												name="input-3" id="input-3"> <label
												class="form-check-label text-gray-600 text-sm" for="input-3">Lorem
												ipsum dolor sit amet, consectetur adipisicing elit.</label>
										</div>
									</div>
									<div class="p-3 bg-dash-dark-3">
										<div class="form-check mb-0 py-1">
											<input class="form-check-input" type="checkbox"
												name="input-4" id="input-4"> <label
												class="form-check-label text-gray-600 text-sm" for="input-4">Lorem
												ipsum dolor sit amet, consectetur adipisicing elit.</label>
										</div>
									</div>
									<div class="p-3">
										<div class="form-check mb-0 py-1">
											<input class="form-check-input" type="checkbox"
												name="input-5" id="input-5"> <label
												class="form-check-label text-gray-600 text-sm" for="input-5">Lorem
												ipsum dolor sit amet, consectetur adipisicing elit.</label>
										</div>
									</div>
									<div class="p-3 bg-dash-dark-3">
										<div class="form-check mb-0 py-1">
											<input class="form-check-input" type="checkbox"
												name="input-6" id="input-6"> <label
												class="form-check-label text-gray-600 text-sm" for="input-6">Lorem
												ipsum dolor sit amet, consectetur adipisicing elit.</label>
										</div>
									</div>
									<div class="p-3">
										<div class="form-check mb-0 py-1">
											<input class="form-check-input" type="checkbox"
												name="input-7" id="input-7"> <label
												class="form-check-label text-gray-600 text-sm" for="input-7">Lorem
												ipsum dolor sit amet, consectetur adipisicing elit.</label>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="card">
							<div class="card-body">
								<h3 class="h4 mb-3">New messages</h3>
								<a
									class="d-block d-flex align-items-center text-reset text-decoration-none bg-dash-dark-2 py-2 px-3"
									href="#">
									<div class="position-relative">
										<img class="avatar" src="/reseller/resources/img/avatar-3.jpg"
											alt=""><span class="availability-status bg-success"></span>
									</div>
									<div class="ms-3">
										<p class="fw-bold mb-0">Nadia Halsey</p>
										<p class="text-sm fw-light mb-0">lorem ipsum dolor sit
											amit</p>
										<p class="small fw-light mb-0">09:30am</p>
									</div>
								</a><a
									class="d-block d-flex align-items-center text-reset text-decoration-none bg-dash-dark-2 py-2 px-3"
									href="#">
									<div class="position-relative">
										<img class="avatar" src="/reseller/resources/img/avatar-2.jpg"
											alt=""><span class="availability-status bg-warning"></span>
									</div>
									<div class="ms-3">
										<p class="fw-bold mb-0">Peter Ramsy</p>
										<p class="text-sm fw-light mb-0">lorem ipsum dolor sit
											amit</p>
										<p class="small fw-light mb-0">7:30am</p>
									</div>
								</a><a
									class="d-block d-flex align-items-center text-reset text-decoration-none bg-dash-dark-2 py-2 px-3"
									href="#">
									<div class="position-relative">
										<img class="avatar" src="/reseller/resources/img/avatar-1.jpg"
											alt=""><span class="availability-status bg-danger"></span>
									</div>
									<div class="ms-3">
										<p class="fw-bold mb-0">Sam Kaheil</p>
										<p class="text-sm fw-light mb-0">lorem ipsum dolor sit
											amit</p>
										<p class="small fw-light mb-0">06:55pm</p>
									</div>
								</a><a
									class="d-block d-flex align-items-center text-reset text-decoration-none bg-dash-dark-2 py-2 px-3"
									href="#">
									<div class="position-relative">
										<img class="avatar" src="/reseller/resources/img/avatar-5.jpg"
											alt=""><span class="availability-status bg-gray"></span>
									</div>
									<div class="ms-3">
										<p class="fw-bold mb-0">Sara Wood</p>
										<p class="text-sm fw-light mb-0">lorem ipsum dolor sit
											amit</p>
										<p class="small fw-light mb-0">10:30pm</p>
									</div>
								</a><a
									class="d-block d-flex align-items-center text-reset text-decoration-none bg-dash-dark-2 py-2 px-3"
									href="#">
									<div class="position-relative">
										<img class="avatar" src="/reseller/resources/img/avatar-1.jpg"
											alt=""><span class="availability-status bg-success"></span>
									</div>
									<div class="ms-3">
										<p class="fw-bold mb-0">Nader Magdy</p>
										<p class="text-sm fw-light mb-0">lorem ipsum dolor sit
											amit</p>
										<p class="small fw-light mb-0">9:47pm</p>
									</div>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			</section>
			<section class="pt-0">
			<div class="container-fluid">
				<div class="row gy-4">
					<div class="col-lg-4">
						<div class="card">
							<div class="card-body">
								<h3 class="h4 mb-0">Credit Sales</h3>
								<p class="text-sm fw-light mb-5">Lorem ipsum dolor sit</p>
								<div class="position-relative text-center">
									<canvas id="pieChartHome1"></canvas>
									<div class="position-absolute top-50 start-50 translate-middle">
										<strong class="text-lg d-block">$2.145</strong><span
											class="d-block">Sales</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="card">
							<div class="card-body">
								<h3 class="h4 mb-0">Channel Sales</h3>
								<p class="text-sm fw-light mb-5">Lorem ipsum dolor sit</p>
								<div class="position-relative text-center">
									<canvas id="pieChartHome2"></canvas>
									<div class="position-absolute top-50 start-50 translate-middle">
										<strong class="text-lg d-block">$7.784</strong><span
											class="d-block">Sales</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="card">
							<div class="card-body">
								<h3 class="h4 mb-0">Direct Sales</h3>
								<p class="text-sm fw-light mb-5">Lorem ipsum dolor sit</p>
								<div class="position-relative text-center">
									<canvas id="pieChartHome3"></canvas>
									<div class="position-absolute top-50 start-50 translate-middle">
										<strong class="text-lg d-block">$4.957</strong><span
											class="d-block">Sales</span>
									</div>
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
	<script src="/reseller/resources/vendor/chart.js/Chart.min.js"></script>
	<script
		src="/reseller/resources/vendor/choices.js/public/assets/scripts/choices.min.js"></script>
	<script src="/reseller/resources/js/charts-home.js"></script>
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