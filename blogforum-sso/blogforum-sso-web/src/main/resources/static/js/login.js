// JavaScript Document

//键盘回车会执行.block类的点击事件
	$(document).keyup(function(event){
	  if(event.keyCode ==13){
		$("#login").trigger("click");
	  }
	});


	$("#login").click(function(){
		var name = $.trim($("[name = 'username']").val());
		if(name == ""){
			layer.tips('用户名未填写!','[name = "username"]',{tips:[2,"#3595CC"]});
			$("[name = 'username']").focus();
			return false;
		}
		var password = $.trim($("[name = 'password']").val());
		if(password == ""){
			layer.tips('密码未填写!','[name = "password"]',{tips:[2,"#3595CC"]});
			$("[name = 'password']").focus();
			return false;
		}
		$.post("/user/loginregister",{
			username:name,
			password:password,
			cmCode:"login"
			},
			function(data) {
			if(data.status != "200") {
				layer.msg(data.msg);
				$("[name='name']").focus();
			} else {
				location.href="http://www.baidu.com";
			}
			if(data.status == "703"){
				location.href="http://www.baidu.com";
			}
		});
		
		
	});
