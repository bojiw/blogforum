<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BlogForum Admin</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="css/font-awesome.min.css" rel="stylesheet">

<!-- ionicons -->
<link href="css/ionicons.min.css" rel="stylesheet">

<!-- Morris -->
<link href="css/morris.css" rel="stylesheet" />

<!-- Datepicker -->
<link href="css/datepicker.css" rel="stylesheet" />

<!-- Animate -->
<link href="css/animate.min.css" rel="stylesheet">

<!-- Owl Carousel -->
<link href="css/owl.carousel.min.css" rel="stylesheet">
<link href="css/owl.theme.default.min.css" rel="stylesheet">

<!-- Simplify -->
<link href="css/simplify.min.css" rel="stylesheet">

<!-- 修改默认字体 -->
<link href="css/typeface.css" rel="stylesheet">



</head>

  	<body class="overflow-hidden">
		<div class="wrapper preload">
			
			<header class="top-nav">
				<div class="top-nav-inner">
					<div class="nav-header">
						<button type="button" class="navbar-toggle pull-left sidebar-toggle" id="sidebarToggleSM">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						
						<a href="index.action" class="brand">
							<span class="brand-name">BlogForum ADMIN</span>
						</a>
					</div>
					<div class="nav-container">
						<button type="button" class="navbar-toggle pull-left sidebar-toggle" id="sidebarToggleLG">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<ul class="nav-notification">	
							<li class="search-list">
								<div class="search-input-wrapper">
									<div class="search-input">
										<input type="text" class="form-control input-sm inline-block">
										<a href="#" class="input-icon text-normal"><i class="ion-ios7-search-strong"></i></a>
									</div>
								</div>
							</li>
						</ul>
						<div class="pull-right m-right-sm">
							<div class="user-block hidden-xs">
								<a href="#" id="userToggle" data-toggle="dropdown">
									<img src="images/profile/profile1.jpg" alt="" class="img-circle inline-block user-profile-pic">
									<div class="user-detail inline-block">
										${adminUserName}
										<i class="fa fa-angle-down"></i>
									</div>
								</a>
								<div class="panel border dropdown-menu user-panel">
									<div class="panel-body paddingTB-sm">
										<ul>
											<li>
												<a href="loginout.action">
													<i class="fa fa-power-off fa-lg"></i><span class="m-left-xs">退出</span>
												</a>
											</li>
										</ul>
									</div>
								</div>
							</div>
	
						</div>
					</div>
				</div><!-- ./top-nav-inner -->	
			</header>
			<aside class="sidebar-menu fixed">
				<div class="sidebar-inner scrollable-sidebar">
					<div class="main-menu">
						<ul class="accordion">
							<li class="menu-header">
								Main Menu
							</li>
							<li class="bg-palette1 active">
								<a href="index.action">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-home fa-lg"></i></span>
										<span class="text m-left-sm">主页</span>
									</span>
									<span class="menu-content-hover block">
										Home
									</span>
								</a>
							</li>

							<li class="openable bg-palette3">
								<a href="#">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-list fa-lg"></i></span>
										<span class="text m-left-sm">审批博客</span>
										<span class="submenu-icon"></span>
									</span>
									<span class="menu-content-hover block">
										审批博客
									</span>
								</a>
								<ul class="submenu bg-palette4">
									<li><a class="J_menuItem" href="adminUserShow.jsp"><span class="submenu-label">审批发布博客</span></a></li>
									<li><a class="J_menuItem" href="dropzone.html"><span class="submenu-label">审批评论</span></a></li>
								</ul>
							</li>
							<li class="openable bg-palette3">
								<a href="#">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-list fa-lg"></i></span>
										<span class="text m-left-sm">人员管理</span>
										<span class="submenu-icon"></span>
									</span>
									<span class="menu-content-hover block">
										人员管理
									</span>
								</a>
								<ul class="submenu bg-palette4">
									<li><a class="J_menuItem" href="usermanager/adminUserShow.jsp"><span class="submenu-label">管理员用户设置</span></a></li>
									<li><a class="J_menuItem" href="dropzone.html"><span class="submenu-label">角色设置</span></a></li>
									<li><a class="J_menuItem" href="dropzone.html"><span class="submenu-label">权限设置</span></a></li>
									<li><a class="J_menuItem" href="form_wizard.html"><span class="submenu-label">用户查询</span></a></li>
									<li><a class="J_menuItem" href="dropzone.html"><span class="submenu-label">用户设置</span></a></li>
								</ul>
							</li>

						</ul>
					</div>	
					<div class="sidebar-fix-bottom clearfix">
						<div class="user-dropdown dropup pull-left">

						</div>
						<a href="loginout.action" class="pull-right font-18"><i class="ion-log-out"></i></a>
					</div>
				</div><!-- sidebar-inner -->
			</aside>
			
			<div id = "J_iframe" class="main-container">
				<div class="padding-md">
					<div class="row">
						<div class="col-sm-6">
							<div class="page-title">
								仪表板
							</div>
							<div class="page-sub-header">
								欢迎回来,${adminUserName}
							</div>
						</div>

					</div>

					<div class="row m-top-md">
						<div class="col-lg-3 col-sm-6">
							<div class="statistic-box bg-danger m-bottom-md">
								<div class="statistic-title">
									当天游客量
								</div>

								<div class="statistic-value">
									96.7k
								</div>

								<div class="m-top-md">11% Higher than last week</div>

								<div class="statistic-icon-background">
									<i class="ion-eye"></i>
								</div>
							</div>
						</div>

						<div class="col-lg-3 col-sm-6">
							<div class="statistic-box bg-info m-bottom-md">
								<div class="statistic-title">
									当天用户量
								</div>

								<div class="statistic-value">
									751
								</div>

								<div class="m-top-md">8% Higher than last week</div>

								<div class="statistic-icon-background">
									<i class="ion-ios7-cart-outline"></i>
								</div>
							</div>
						</div>

						<div class="col-lg-3 col-sm-6">
							<div class="statistic-box bg-purple m-bottom-md">
								<div class="statistic-title">
									用户注册量
								</div>

								<div class="statistic-value">
									${userCount}
								</div>

								<div class="m-top-md">3% Higher than last week</div>

								<div class="statistic-icon-background">
									<i class="ion-person-add"></i>
								</div>
							</div>
						</div>

						<div class="col-lg-3 col-sm-6">
							<div class="statistic-box bg-success m-bottom-md">
								<div class="statistic-title">
									总访客量
								</div>

								<div class="statistic-value">
									$124.45k
								</div>

								<div class="m-top-md">7% Higher than last week</div>

								<div class="statistic-icon-background">
									<i class="ion-stats-bars"></i>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-6">
							<div class="smart-widget widget-dark-blue">
								<div class="smart-widget-header">
									TOTAL VISITS
									<span class="smart-widget-option">
										<span class="refresh-icon-animated">
											<i class="fa fa-circle-o-notch fa-spin"></i>
										</span>
			                            <a href="#" class="widget-toggle-hidden-option">
			                                <i class="fa fa-cog"></i>
			                            </a>
			                            <a href="#" class="widget-collapse-option" data-toggle="collapse">
			                                <i class="fa fa-chevron-up"></i>
			                            </a>
			                            <a href="#" class="widget-refresh-option">
			                                <i class="fa fa-refresh"></i>
			                            </a>
			                            <a href="#" class="widget-remove-option">
			                                <i class="fa fa-times"></i>
			                            </a>
			                        </span>
								</div>
								<div class="smart-widget-inner">
									<div class="smart-widget-hidden-section">
										<ul class="widget-color-list clearfix">
											<li style="background-color:#20232b;" data-color="widget-dark"></li>
											<li style="background-color:#4c5f70;" data-color="widget-dark-blue"></li>
											<li style="background-color:#23b7e5;" data-color="widget-blue"></li>
											<li style="background-color:#2baab1;" data-color="widget-green"></li>
											<li style="background-color:#edbc6c;" data-color="widget-yellow"></li>
											<li style="background-color:#fbc852;" data-color="widget-orange"></li>
											<li style="background-color:#e36159;" data-color="widget-red"></li>
											<li style="background-color:#7266ba;" data-color="widget-purple"></li>
											<li style="background-color:#f5f5f5;" data-color="widget-light-grey"></li>
											<li style="background-color:#fff;" data-color="reset"></li>
										</ul>
									</div>
									<div class="smart-widget-body no-padding">
										<div class="padding-md">
											<div id="totalSalesChart" class="morris-chart" style="height:250px;"></div>
										</div>
										
										<div class="bg-grey">
											<div class="row">
												<div class="col-xs-4 text-center">
													<h3 class="m-top-sm">999</h3>
													<small class="m-bottom-sm block">Total Visits</small>
												</div>
												<div class="col-xs-4 text-center">
													<h3 class="m-top-sm">102</h3>
													<small class="m-bottom-sm block">New Visits</small>
												</div>
												<div class="col-xs-4 text-center">
													<h3 class="m-top-sm">690</h3>
													<small class="m-bottom-sm block">Bounce Rate</small>
												</div>
											</div>
										</div>
									</div>
								</div><!-- ./smart-widget-inner -->
							</div><!-- ./smart-widget -->
						</div><!-- ./col -->
						<div class="col-lg-6">
							<div class="smart-widget widget-dark-blue">
								<div class="smart-widget-header">
									TOTAL SALES
									<span class="smart-widget-option">
										<span class="refresh-icon-animated">
											<i class="fa fa-circle-o-notch fa-spin"></i>
										</span>
			                            <a href="#" class="widget-toggle-hidden-option">
			                                <i class="fa fa-cog"></i>
			                            </a>
			                            <a href="#" class="widget-collapse-option" data-toggle="collapse">
			                                <i class="fa fa-chevron-up"></i>
			                            </a>
			                            <a href="#" class="widget-refresh-option">
			                                <i class="fa fa-refresh"></i>
			                            </a>
			                            <a href="#" class="widget-remove-option">
			                                <i class="fa fa-times"></i>
			                            </a>
			                        </span>
								</div>
								<div class="smart-widget-inner">
									<div class="smart-widget-hidden-section">
										<ul class="widget-color-list clearfix">
											<li style="background-color:#20232b;" data-color="widget-dark"></li>
											<li style="background-color:#4c5f70;" data-color="widget-dark-blue"></li>
											<li style="background-color:#23b7e5;" data-color="widget-blue"></li>
											<li style="background-color:#2baab1;" data-color="widget-green"></li>
											<li style="background-color:#edbc6c;" data-color="widget-yellow"></li>
											<li style="background-color:#fbc852;" data-color="widget-orange"></li>
											<li style="background-color:#e36159;" data-color="widget-red"></li>
											<li style="background-color:#7266ba;" data-color="widget-purple"></li>
											<li style="background-color:#f5f5f5;" data-color="widget-light-grey"></li>
											<li style="background-color:#fff;" data-color="reset"></li>
										</ul>
									</div>
									<div class="smart-widget-body no-padding">
										<div class="padding-md">
											<div id="placeholder" style="height:250px;"></div>
										</div>

										<div class="bg-grey">
											<div class="row">
												<div class="col-xs-4 text-center">
													<h3 class="m-top-sm">3491</h3>
													<small class="m-bottom-sm block">Total Sales</small>
												</div>
												<div class="col-xs-4 text-center">
													<h3 class="m-top-sm">721</h3>
													<small class="m-bottom-sm block">New Orders</small>
												</div>
												<div class="col-xs-4 text-center">
													<h3 class="m-top-sm">$8103</h3>
													<small class="m-bottom-sm block">Total Earnings</small>
												</div>
											</div>
										</div>
									</div>
								</div><!-- ./smart-widget-inner -->
							</div><!-- ./smart-widget -->
						</div><!-- ./col -->
					</div>

					</div><!-- ./row -->

					<div class="row">
						<div class="col-md-3">
							<div class="panel panel-default weather-widget">
								<div class="panel-body bg-success text-white">
									<div class="h4 text-white text-center">Today Weather</div>

									<div class="m-top-md m-bottom-md text-center">
										<canvas id="skycon1" width="120" height="120"></canvas>
									</div>

									<div class="degree-text text-center">22°</div>
								</div>
								<div class="panel-footer bg-white text-center padding-md">
									<div class="h4 text-upper">New York <i class="fa fa-map-marker"></i></div>
									<div class="text-muted font-12 m-top-xs">Rainy Day</div>
								</div>
							</div><!-- ./panel -->
						</div><!-- ./col -->
						<div class="col-md-3">
							<div class="panel panel-default weather-widget">
								<div class="panel-body bg-warning text-white">
									<div class="h4 text-white text-center">Today Weather</div>

									<div class="m-top-md m-bottom-md text-center">
										<canvas id="skycon2" width="120" height="120"></canvas>
									</div>

									<div class="degree-text text-center">37°</div>
								</div>
								<div class="panel-footer bg-white text-center padding-md">
									<div class="h4 text-upper">London <i class="fa fa-map-marker"></i></div>
									<div class="text-muted font-12 m-top-xs">Cloudy Day</div>
								</div>
							</div><!-- ./panel -->
						</div><!-- ./col -->
						<div class="col-md-3">
							<div class="panel panel-default weather-widget">
								<div class="panel-body bg-danger text-white">
									<div class="h4 text-white text-center">Today Weather</div>

									<div class="m-top-md m-bottom-md text-center">
										<canvas id="skycon3" width="120" height="120"></canvas>
									</div>

									<div class="degree-text text-center">21°</div>
								</div>
								<div class="panel-footer bg-white text-center padding-md">
									<div class="h4 text-upper">Bangkok <i class="fa fa-map-marker"></i></div>
									<div class="text-muted font-12 m-top-xs">Wind</div>
								</div>
							</div><!-- ./panel -->
						</div><!-- ./col -->
						<div class="col-md-3">
							<div class="panel panel-default weather-widget">
								<div class="panel-body bg-info text-white">
									<div class="h4 text-white text-center">Today Weather</div>

									<div class="m-top-md m-bottom-md text-center">
										<canvas id="skycon4" width="120" height="120"></canvas>
									</div>

									<div class="degree-text text-center">14°</div>
								</div>
								<div class="panel-footer bg-white text-center padding-md">
									<div class="h4 text-upper">Tokyo <i class="fa fa-map-marker"></i></div>
									<div class="text-muted font-12 m-top-xs">Clear Day</div>
								</div>
							</div><!-- ./panel -->
						</div><!-- ./col -->
					</div>
				</div><!-- ./padding-md -->
			</div><!-- /main-container -->


		</div><!-- /wrapper -->

		<a href="#" class="scroll-to-top hidden-print"><i class="fa fa-chevron-up fa-lg"></i></a>

		<!-- Delete Widget Confirmation -->
		<div class="custom-popup delete-widget-popup delete-confirmation-popup" id="deleteWidgetConfirm">
			<div class="popup-header text-center">
				<span class="fa-stack fa-4x">
				  <i class="fa fa-circle fa-stack-2x"></i>
				  <i class="fa fa-lock fa-stack-1x fa-inverse"></i>
				</span>
			</div>
			<div class="popup-body text-center">
				<h5>Are you sure to delete this widget?</h5>
				<strong class="block m-top-xs"><i class="fa fa-exclamation-circle m-right-xs text-danger"></i>This action cannot be undone</strong>
			
				<div class="text-center m-top-lg">
					<a class="btn btn-success m-right-sm remove-widget-btn">Delete</a>
					<a class="btn btn-default deleteWidgetConfirm_close">Cancel</a>
				</div>
			</div>
		</div>

		
	    <!-- Le javascript
	    ================================================== -->
	    <!-- Placed at the end of the document so the pages load faster -->
		
		<!-- Jquery -->
		<script src="js/jquery-1.11.1.min.js"></script>
		
		<!-- Bootstrap -->
	    <script src="bootstrap/js/bootstrap.min.js"></script>
	  
		<!-- Flot -->
		<script src='js/jquery.flot.min.js'></script>

		<!-- Slimscroll -->
		<script src='js/jquery.slimscroll.min.js'></script>
		
		<!-- Morris -->
		<script src='js/rapheal.min.js'></script>	
		<script src='js/morris.min.js'></script>	

		<!-- Datepicker -->
		<script src='js/uncompressed/datepicker.js'></script>

		<!-- Sparkline -->
		<script src='js/sparkline.min.js'></script>

		<!-- Skycons -->
		<script src='js/uncompressed/skycons.js'></script>
		
		<!-- Popup Overlay -->
		<script src='js/jquery.popupoverlay.min.js'></script>

		<!-- Easy Pie Chart -->
		<script src='js/jquery.easypiechart.min.js'></script>

		<!-- Sortable -->
		<script src='js/uncompressed/jquery.sortable.js'></script>

		<!-- Owl Carousel -->
		<script src='js/owl.carousel.min.js'></script>

		<!-- Modernizr -->
		<script src='js/modernizr.min.js'></script>
		
		<!-- Simplify -->
		<script src="js/simplify/simplify.js"></script>
		<script src="js/simplify/simplify_dashboard.js"></script>
		
		<!-- 页面加载 -->
		<script src="js/index.js"></script>


		<script>
			$(function()	{
				$('.chart').easyPieChart({
					easing: 'easeOutBounce',
					size: '140',
					lineWidth: '7',
					barColor: '#7266ba',
					onStep: function(from, to, percent) {
						$(this.el).find('.percent').text(Math.round(percent));
					}
				});

				$('.sortable-list').sortable();

				$('.todo-checkbox').click(function()	{
					
					var _activeCheckbox = $(this).find('input[type="checkbox"]');

					if(_activeCheckbox.is(':checked'))	{
						$(this).parent().addClass('selected');					
					}
					else	{
						$(this).parent().removeClass('selected');
					}
				
				});

				//Delete Widget Confirmation
				$('#deleteWidgetConfirm').popup({
					vertical: 'top',
					pagecontainer: '.container',
					transition: 'all 0.3s'
				});
			});
			
		</script>
	
  	</body>
</html>
