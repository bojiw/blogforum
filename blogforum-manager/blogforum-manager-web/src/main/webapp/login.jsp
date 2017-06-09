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
		
		<!-- Simplify -->
		<link href="css/simplify.min.css" rel="stylesheet">
</head>
  	<body class="overflow-hidden light-background">
  	<div style="width: 20%;height: 20%"></div>
		<div class="wrapper no-navigation preload">
			<div class="sign-in-wrapper">
				<div class="sign-in-inner">
					<div class="login-brand text-center">
						 BlogForum <strong class="text-skin">Admin</strong>
					</div>

					<form>
						<div class="form-group m-bottom-md">
							<input type="text" name = "username" class="form-control" placeholder="Username">
						</div>
						<div class="form-group">
							<input type="password" name = "password" class="form-control" placeholder="Password">
						</div>

					<!--  
						<div class="form-group">
							<div class="custom-checkbox">
								<input type="checkbox" id="chkRemember">
								<label for="chkRemember"></label>
							</div>
							记住我
						</div>
					-->
						<div class="m-top-md p-top-sm">
							<a id = "login" href="#" class="btn btn-success block">登录</a>
						</div>

						<div class="m-top-md p-top-sm">
							<div class="font-12 text-center m-bottom-xs">
								<a href="#" class="font-12"></a>
							</div>
						</div>
					</form>
				</div><!-- ./sign-in-inner -->
			</div><!-- ./sign-in-wrapper -->
		</div><!-- /wrapper -->

		<a href="" id="scroll-to-top" class="hidden-print"><i class="icon-chevron-up"></i></a>

	    <!-- Le javascript
	    ================================================== -->
	    <!-- Placed at the end of the document so the pages load faster -->



		<!-- Jquery -->
		<script src="js/jquery-1.11.1.min.js"></script>
		
		<!-- Bootstrap -->
	    <script src="bootstrap/js/bootstrap.min.js"></script>
		
		<!-- Slimscroll -->
		<script src='js/jquery.slimscroll.min.js'></script>
		
		<!-- Popup Overlay -->
		<script src='js/jquery.popupoverlay.min.js'></script>

		<!-- Modernizr -->
		<script src='js/modernizr.min.js'></script>
		
		<!-- Simplify -->
		<script src="js/simplify/simplify.js"></script>
        
        <!-- layer -->
        <script src="js/layer/layer.js"></script>
        
        <!-- 页面js -->
		<script src="js/login.js"></script>
  	</body>
</html>