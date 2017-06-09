<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>人员管理</title>
	<meta name="keywords" content="" />
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- The styles -->
	<link id="bs-css" href="css/bootstrap-cerulean.css" rel="stylesheet">
	<style type="text/css">
	  body {
		padding-bottom: 40px;
	  }
	  .sidebar-nav {
		padding: 9px 0;
	  }
	</style>
	<link href="css/bootstrap-responsive.css" rel="stylesheet">
	<link href='css/jquery.iphone.toggle.css' rel='stylesheet'>


	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

	<!-- The fav icon -->
	<link rel="shortcut icon" href="img/favicon.ico">
		
</head>

<body>
			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-user"></i> 管理员信息</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
						</div>
					</div>
							<div class="panel-body">
								<div class="table-responsive">	
									<div class="row">
										<div class="col-sm-6">
											<div class="bk-margin-bottom-10">
												<button id="addToTable" class="btn btn-info">Add <i class="fa fa-plus"></i></button>
											</div>
										</div>
									</div>
										<table class="table table-striped table-bordered bootstrap-datatable datatable ">
									<thead>
										<tr>
											<th>编号</th>
											<th>用户名</th>
											<th>角色</th>
											<th>状态</th>
											<th>操作</th>
										</tr>
									</thead>   
									<tbody>								
										<tr>
											<td>Willson</td>
											<td>Developer</td>
											<td>2563$</td>
											<td>
												<span class="label label-warning">Pending</span>
											</td>
											<td>
												<a class="btn btn-success" href="table.html#">
													<i class="fa fa-search-plus "></i>                                            
												</a>
												<a class="btn btn-info" href="table.html#">
													<i class="fa fa-edit "></i>                                            
												</a>
												<a class="btn btn-danger" href="table.html#">
													<i class="fa fa-trash-o "></i> 

												</a>
											</td>
										</tr>
										<tr>
											<td>James</td>
											<td>SEO</td>
											<td>5000$</td>
											<td>
												<span class="label label-warning">Pending</span>
											</td>
											<td>
												<a class="btn btn-success" href="table.html#">
													<i class="fa fa-search-plus "></i>                                            
												</a>
												<a class="btn btn-info" href="table.html#">
													<i class="fa fa-edit "></i>                                            
												</a>
												<a class="btn btn-danger" href="table.html#">
													<i class="fa fa-trash-o "></i> 
												</a>
											</td>
										</tr>
										<tr>
											<td>Steven</td>
											<td>Photographer</td>
											<td>1269$</td>
											<td>
												<span class="label label-warning">Pending</span>
											</td>
											<td>
												<a class="btn btn-success" href="table.html#">
													<i class="fa fa-search-plus "></i>                                            
												</a>
												<a class="btn btn-info" href="table.html#">
													<i class="fa fa-edit "></i>                                            
												</a>
												<a class="btn btn-danger" href="table.html#">
													<i class="fa fa-trash-o "></i> 
												</a>
											</td>
										</tr>
										<tr>
											<td>Aselay</td>
											<td>Project manger</td>
											<td>6253$</td>
											<td>
												<span class="label label-warning">Pending</span>
											</td>
											<td>
												<a class="btn btn-success" href="table.html#">
													<i class="fa fa-search-plus "></i>                                            
												</a>
												<a class="btn btn-info" href="table.html#">
													<i class="fa fa-edit "></i>                                            
												</a>
												<a class="btn btn-danger" href="table.html#">
													<i class="fa fa-trash-o "></i> 
												</a>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
				</div><!--/span-->
			
			</div><!--/row-->


	
		
</body>
</html>
