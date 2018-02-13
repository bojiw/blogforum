$(function	()	{
	
	//scrollable sidebar
	$('.scrollable-sidebar').slimScroll({
		height: '100%',
		size: '0px'
	});
	
	//Collapsible Sidebar Menu
	$('.sidebar-menu .openable > a').click(function()	{
		
		if(!$('aside').hasClass('sidebar-mini') || Modernizr.mq('(max-width: 991px)'))	{
			if( $(this).parent().children('.submenu').is(':hidden') ) {
				$(this).parent().siblings().removeClass('open').children('.submenu').slideUp(200);
				$(this).parent().addClass('open').children('.submenu').slideDown(200);
			}
			else	{
				$(this).parent().removeClass('open').children('.submenu').slideUp(200);
			}
		}
		
		return false;
	});

	//Open active menu
	if(!$('.sidebar-menu').hasClass('sidebar-mini') || Modernizr.mq('(max-width: 767px)'))	{
		$('.openable.open').children('.submenu').slideDown(200);
	}
	
	//Toggle User container on sidebar menu
	$('#btn-collapse').click(function()	{
		$('.sidebar-header').toggleClass('active');
	});
	
	//theme setting
	$("#theme-setting-icon").click(function()	{ 
		if($('#theme-setting').hasClass('open'))	{
			$('#theme-setting').removeClass('open');
			$('#theme-setting-icon').removeClass('open');
		}
		else	{
			$('#theme-setting').addClass('open');
			$('#theme-setting-icon').addClass('open');
		}

		return false;
	});
	//点击菜单栏右侧弹出隐藏
	$('#sidebarToggleLG').click(function()	{
		if($('.wrapper').hasClass('display-right'))	{
			$('.wrapper').removeClass('display-right');
			$('.sidebar-right').removeClass('active');
		}
		else{
			//点击菜单栏隐藏和显示的时候 搜索框也进行相应的隐藏和显示
			$("#noteBookSearch").toggle();
			//$('.nav-header').toggleClass('hide');
			$('.top-nav').toggleClass('sidebar-mini');
			$("#noteLeft").css("width","");
			$('aside').toggleClass('sidebar-mini');
			if($('aside').hasClass('sidebar-mini')){
				$("#noteSplit").css("left","0px");
				$("#noteRight").css("padding-left","60px");
			}else{
				$("#noteSplit").css("left","240px");
				$("#noteRight").css("padding-left","240px");
			}
			
			$('footer').toggleClass('sidebar-mini');
			$('.main-container').toggleClass('sidebar-mini');
			$('.main-menu').find('.openable').removeClass('open');
			$('.main-menu').find('.submenu').removeAttr('style');
		}		
	});
	
	$('#sidebarToggleSM').click(function()	{
		$('aside').toggleClass('active');
		$('.wrapper').toggleClass('display-left');
	});
	
	$('.sidebarRight-toggle').click(function()	{
		$('.sidebar-right').toggleClass('active');
		$('.wrapper').toggleClass('display-right');
		$('footer').toggleClass('display-right');

		return false;
	});
	
	$('.dropdown-menu input').click(function(e) {
        e.stopPropagation(); //This will prevent the event from bubbling up and close the dropdown when you type/click on text boxes.
    });
	
	//to do list
	$('.task-finish').click(function()	{ 
		if($(this).is(':checked'))	{
			$(this).parent().parent().addClass('selected');					
		}
		else	{
			$(this).parent().parent().removeClass('selected');
		}
	});

	//Delete to do list
	$('.task-del').click(function()	{			
		var activeList = $(this).parent().parent();

		activeList.addClass('removed');
				
		setTimeout(function() {
			activeList.remove();
		}, 1000);
			
		return false;
	});
	
	var $activeWidget = '';
	var $activeWidgetHeader;
	var $headerHeight;
	var $screenHeight;
	var $widgetHeight;
	var $borderHeight = 3;

	//Smart Widget

	// Refresh Widget
	$('.widget-refresh-option').click(function()	{

		$activeWidget = $(this).parent().parent().parent();
		
		var $activeSpinIcon = $activeWidget.find('.refresh-icon-animated').fadeIn();

		setTimeout(function() {
			$activeSpinIcon.fadeOut();
		},2000);

		return false;
	});

	// Collasible Widget
	$('.widget-collapse-option').click(function()	{
		$activeWidget = $(this).parent().parent().parent();

		$activeWidget.find('.smart-widget-inner').slideToggle();
		$activeWidget.toggleClass('smart-widget-collapsed');

		var $activeSpinIcon = $activeWidget.find('.refresh-icon-animated').fadeIn();

		setTimeout(function() {
			$activeSpinIcon.fadeOut();
		},500);

		$activeWidget = '';

		return false;
	});

	//Changing Widget Color
	$('.widget-toggle-hidden-option').click(function()	{
		$activeWidget = $(this).parent().parent().parent();

		$activeWidget.find('.smart-widget-hidden-section').slideToggle();	

		var $activeSpinIcon = $activeWidget.find('.refresh-icon-animated').fadeIn();

		setTimeout(function() {
			$activeSpinIcon.fadeOut();
		},500);


		$activeWidget = '';			

		return false;
	});

	//Changing Widget Header Background
	$('.widget-color-list li').click(function()	{
		$activeWidget = $(this).parent().parent().parent().parent();
		$selectedColor = $(this).data('color');

		$activeWidget.removeClass('widget-light-grey');
		$activeWidget.removeClass('widget-dark');
		$activeWidget.removeClass('widget-dark-blue');
		$activeWidget.removeClass('widget-blue');
		$activeWidget.removeClass('widget-green');
		$activeWidget.removeClass('widget-yellow');
		$activeWidget.removeClass('widget-orange');
		$activeWidget.removeClass('widget-red');
		$activeWidget.removeClass('widget-purple');

		if($selectedColor != 'reset')
			$activeWidget.addClass($selectedColor);
		
		return false;
	});

	// Remove Widget
	$('.widget-remove-option').click(function()	{

		$activeWidget = $(this).parent().parent().parent();

		$('#deleteWidgetConfirm').popup('show');

		return false;

	});

	$('.remove-widget-btn').click(function()	{
		$('#deleteWidgetConfirm').popup('hide');
		$activeWidget.fadeOut();

		$activeWidget = '';

		return false;
	});

	//Scroll to Top
	$(".scroll-to-top").click(function()	{
		$("html, body").animate({ scrollTop: 0 }, 600);
		 return false;
	});

	// Popover
    $("[data-toggle=popover]").popover();
	
	// Tooltip
    $("[data-toggle=tooltip]").tooltip();
	$("[rel=tooltip]").tooltip();
});


$(window).load(function() {
	$('body').removeClass('overflow-hidden');

	//Enable animation
	$('.wrapper').removeClass('preload');

	//Chat Notification on top navigation
	setTimeout(function() {
		$('.chat-notification').find('.badge').addClass('active');
		$('.chat-alert').addClass('active');
	}, 3000);

	setTimeout(function() {
		$('.chat-alert').removeClass('active');
	}, 8000);
});

// Toggle Scroll to Top button
$(window).scroll(function(){
		
	 var position = $(window).scrollTop();
	
	 if(position >= 200)	{
		$('.scroll-to-top').addClass('active')
	 }
	 else	{
		$('.scroll-to-top').removeClass('active')
	 }
});



/**div拖拽自动变换宽度*/
window.onload = function() {
var oBoxBody = document.getElementById("boxBody"), oNoteLeft = document.getElementById("noteLeft"), oNoteRight = document.getElementById("noteRight"), oNoteSqlit = document.getElementById("noteBookSplit");
	oNoteSqlit.onmousedown = function(e) {
	 var disX = (e || event).clientX;
	 oNoteSqlit.left = oNoteSqlit.offsetLeft;
	 document.onmousemove = function(e) { 
	  var iT = oNoteSqlit.left + ((e || event).clientX - disX);
	 var e=e||window.event,tarnameb=e.target||e.srcElement;
	  var maxT = oBoxBody.clientWight - oNoteSqlit.offsetWidth;
	  oNoteSqlit.style.margin = 0;
	  iT < 0 && (iT = 0);
	  iT > maxT && (iT = maxT);
	  oNoteSqlit.style.left = oNoteLeft.style.width = iT + "px";
	  oNoteRight.style.paddingLeft = iT + "px";
	  return false
	 }; 
	 document.onmouseup = function() {
	  document.onmousemove = null;
	  document.onmouseup = null; 
	  oNoteSqlit.releaseCapture && oNoteSqlit.releaseCapture()
	 };
	oNoteSqlit.setCapture && oNoteSqlit.setCapture();
	return false
	};
};



$(function(){
	
	//全局变量
	//选择的笔记本  笔记本名和id
	var selectedBook;
	var bookName;
	var selectedBookId
	//目前显示的笔记列表是否是搜索以后的结果
	var searchFlag = false;
	//搜索的关键字
	var keyword = "";
	//默认的分页大小
	var pageSize = 20;
	
	
	//设置笔记本点击事件
	var clickBookNote = function(){
		$(".showsetting").removeClass("clickBookNote");
		$(this).addClass("clickBookNote");
		selectedBook = $(this).find(".noteBookName");
		noteBookClick(selectedBook);
	}
	refreshMenu();
	var firstNoteBook = $("#listbooks").find(".showsetting").first();
	//如果有笔记本则执行笔记本点击按钮
	if(firstNoteBook != null){
		firstNoteBook.click();
	}
	//新建笔记
	//第一次进入页面 默认选中笔记本的id为第一个笔记本
	console.info($("#listbooks").find(".showsetting").eq(0));
	selectedBook = $("#listbooks").find(".noteBookName").first();
	selectedBookId = selectedBook.attr("value");
	bookName = selectedBook.html();
	//设置当前选中的笔记本的id和name 方便其他地方获取
	$("#selectedBook").attr("value",selectedBookId);
	$("#selectedBook").attr("name",bookName);
	
	
	//显示笔记
	function showNote(type,noteId){
	    $.ajaxSetup ({ 
	        cache: false // AJAX cache 关闭ajax缓存 防止加载只内容页的js只加载一次
	     }); 
		$(".noteRightInfo").load(type,{noteId:noteId},function(){
			if($("#selectedNoteId").attr("value") != noteId){
				showNote(type,$("#selectedNoteId").attr("value"));
			}
		});
		//延迟1秒刷新 防止历史异步加载的笔记内容页还没加载完
		setTimeout(function(){
			refreshMenu();
		},1000);
		
		
	}
	
	//第一次进入页面判断选中的笔记本里是否有笔记 有则显示第一个
	var li = $(".node-body-ul-li").eq(0);
	if(li != null){
		var noteId = li.find(".note").eq(0).attr("value");
		var type = li.find(".note").eq(0).attr("type");
		$("#selectedNoteId").attr("value",noteId);
		li.addClass("clickTitleNote");
		showNote(type,noteId);
		refreshMenu();
	}else{
		$(".noteRightInfo").load("nullnote");
	}
	
	
	//点击新建普通笔记时建立新笔记
	$(".simplenote").click(function(){
		if(selectedBookId == null){
			layer.msg("没有选中笔记本   无法创建笔记");
			return;
		}
		var type = "simplenote";
		var noteId = addNote(selectedBookId,bookName,type);
		if(noteId != "0"){
			//先删除所有的选中样式 再增加当前选中的li选中样式
			$(".node-body-ul-li").removeClass("clickTitleNote");
			//拼接第一次创建的html代码
			var lis = initNoteHtml(bookName,noteId,type,selectedBookId);
			//把新加的笔记html代码放到第一个位置
			var html = $(".node-body-ul").html();
			$(".node-body-ul").html(lis+html);
			//修改笔记本的笔记数量+1
			var count = $(".clickBookNote").children('span').eq(3).html();
			//设置选择笔记本id
			$("#selectedNoteId").attr("value",noteId);
			$(".clickBookNote").children('span').eq(3).html(parseInt(count) + 1);
			$(".noteRightInfo").load("simplenote",{noteBookName:bookName,noteBookId:selectedBookId,noteId:noteId});
			refreshMenu();
		}
	});
	//点击新建markdown笔记时建立新笔记
	$(".markdownnote").click(function(){
		if(selectedBookId == null){
			layer.msg("没有选中笔记本   无法创建笔记");
			return;
		}
		var type = "markdownnote";
		var noteId = addNote(selectedBookId,bookName,type);
		if(noteId != "0"){
			//先删除所有的选中样式 再增加当前选中的li选中样式
			$(".node-body-ul-li").removeClass("clickTitleNote");
			$("#selectedNoteId").attr("value",noteId);
			//拼接第一次创建的html代码
			var lis = initNoteHtml(bookName,noteId,type,selectedBookId);
			//把新加的笔记html代码放到第一个位置
			var html = $(".node-body-ul").html();
			$(".node-body-ul").html(lis+html);
			//修改笔记本的笔记数量+1
			var count = $(".clickBookNote").children('span').eq(3).html();
			//设置选择笔记本id
			$("#selectedNoteId").attr("value",noteId);
			$(".clickBookNote").children('span').eq(3).html(parseInt(count) + 1);
			$(".noteRightInfo").load("markdownnote",{noteBookName:bookName,noteBookId:selectedBookId,noteId:noteId});
			refreshMenu();
		}
	});
	
	
	//添加笔记
	function addNote(noteBookId,noteBookName,type){
		 var noteId = "0";
		 $.ajax({  
	         type : "post",  
	          url : "/note/addNote",  
	          data : {noteBookId:noteBookId,noteBookName:noteBookName,type:type},  
	          async : false,  
	          success : function(data){  
					if(data.status != "200") {
						layer.msg(data.msg);
					}else{
						noteId = data.data.id;
					}
	          }  
	     }); 
		 return noteId;
	}
	
	//拼接note的html代码
	function initNoteHtml(noteBookName,noteId,type,bookId){
		var lis = "<li class='node-body-ul-li clickTitleNote'>"
		lis += "<span class='note' value=";
		lis += noteId;
		lis += " type=";
		lis += type;
		lis += " />"
		lis += "<span class='noteBookId' value=" + bookId + "/>";
		lis +=	"<div class='item-desc'><p class='item-title'> ";
		lis += "</p><p class='item-info'><i class='fa fa-book'></i><span class='note-notebook'> ";
		if(noteBookName != null){
			lis += noteBookName;
		}
		lis += " </span><i class='fa fa-clock-o'> </i> <span class='updated-time'> ";
		lis += dateToString(new Date());
		lis += "</p><p class='desc'>";
		lis += "</p></div></li>";
		return lis;
		
	}
	
	//点击笔记方法
	var clickTitleNote = function(){
		//获取笔记li中的.note元素
		var note = $(this).children('span').eq(0);
		//获取noteId
		var noteId = note.attr("value");
		//获取笔记类型
		var type = note.attr("type");
		//设置当前选中的笔记id
		$("#selectedNoteId").attr("value",noteId);
		
		//获取笔记li中的.noteBookId元素
		var noteBook = $(this).children('span').eq(1);
		var noteBookId = noteBook.attr("value");
		//设置当前选中的笔记本id
		$("#selectedBook").attr("value",noteBookId);
		
		//先删除所有的选中样式 再增加当前选中的li选中样式
		$(".node-body-ul-li").removeClass("clickTitleNote");
		$(this).addClass("clickTitleNote");
		if(type == "markdownnote"){
			showNote(type,noteId);
		}else if(type == "simplenote"){
			showNote(type,noteId);
		}else{
			layer.msg("系统错误!!!");
		}
		
		
	}
	
	
	
	//鼠标经过出现设置按钮
	showsetting();
	//给获取笔记本元素绑定点击事件
	$('.glyphicon-chevron-right').on("click",getBooks);
	//设置第一个笔记本为默认选中
	$("#listbooks").find(".showsetting").first().addClass("clickBookNote");

	//笔记本点击执行的代码
	function noteBookClick(selectedBook){
		selectedBookId = selectedBook.attr("value");
		bookName = selectedBook.html();
		//设置当前选中的笔记本的id和name 方便其他地方获取 如果获取的value也就是id为空 代表当前点击的是所有笔记 设置全局选择笔记本id为空
		if(selectedBook.html() == "所有笔记"){
			$("#selectedBook").attr("value","");
		}else{
			$("#selectedBook").attr("value",selectedBookId);
		}
		$("#selectedBook").attr("name",bookName);
		$(".node-body-ul").html("");
		$("#loading").addClass("spinner");
		
		 $.ajax({  
	         type : "get",  
	          url : "/note/getNoteTitleList",  
	          data : {noteBookId: selectedBookId},  
	          async : false,  
	          success : function(data){  
	  			if(data.status != "200"){
					$("#loading").removeClass("spinner");
					layer.msg(data.msg);
					refreshMenu();
				}else{
					var html="";
					//为了防止有人点击笔记本太快出现请求两次 第二次先返回结果 第一次后返回结果 导致最终显示的笔记为第一次点击获取的笔记 加一个判断获取的笔记对应的笔记本是否是用户最终选择的笔记本 如果不是则不用运行
					var isExect = true;
					var note = null;
					jQuery.each(data.data.list,function(i,item){
						if(selectedBookId != null && item.noteBookId != selectedBookId){
							isExect = false;
							return false;
						}
						if(i == 0){
							note = item;
						}
						
						var lis = getNoteHtml(item);
						html += lis;
					});
					if(isExect){
						$("#loading").removeClass("spinner");
						$(".node-body-ul").html(html);
						//设置第一个笔记为选中并且显示
						$(".node-body-ul").find(".node-body-ul-li").eq(0).addClass("clickTitleNote");
						if(note != null){
							showNote(note.type,note.id);
							$("#selectedNoteId").attr("value",note.id);
						}else{
							showNote("nullnote","0");
						}
						
						$("#notePageNo").attr("value",data.data.pageNo);
						$("#notePageSize").attr("value",data.data.pageSize);
						$("#noteCount").attr("value",data.data.count);
						$("#noteLastPage").attr("value",data.data.lastPage);
					}else{
						showNote("nullnote","0");
					}
					refreshMenu();
				}
	          }  
	     }); 
		
	}
	function getNoteHtml(item){
		var lis = "<li class='node-body-ul-li'><span class='note' value= " + item.id + " type=" + item.type + " />";
		lis += "<span class='noteBookId' value=" + item.noteBookId + "/>";
		lis += "<div class='item-desc'><p class='item-title'>";
		if(item.noteTitle != null){
			lis += item.noteTitle;
		}
		lis += "</p><p class='item-info'><i class='fa fa-book'></i><span class='note-notebook'> ";
		if(item.noteBookName != null){
			lis += item.noteBookName;
		}
		lis += " </span><i class='fa fa-clock-o'> </i> <span class='updated-time'> ";
		lis += dateToString(new Date(item.updateDate));
		lis += "</p><p class='desc'>";
		if(item.noteContext != null){
			if(item.noteContext.length > 80){
				//对html字符转义 防止显示问题
				lis += item.noteContext.substring(0,80).replace(/[<>&"]/g,function(c){return {'<':'&lt;','>':'&gt;','&':'&amp;','"':'&quot;'}[c];});
				lis += "...";
			}else{
				lis += item.noteContext.replace(/[<>&"]/g,function(c){return {'<':'&lt;','>':'&gt;','&':'&amp;','"':'&quot;'}[c];});
			}
		}
		lis += "</p></div></li>";
		return lis;
		
	}
	
	//获取时间
	  function dateToString(date){  
		    var year = date.getFullYear();  
		    var month =(date.getMonth() + 1).toString();  
		    var day = (date.getDate()).toString();  
		    var hour = (date.getHours()).toString();  
		    var minute = (date.getMinutes()).toString();  
		    var second = (date.getSeconds()).toString();  
		    if (month.length == 1) {  
		        month = "0" + month;  
		    }  
		    if (day.length == 1) {  
		        day = "0" + day;  
		    }  
		    if (hour.length == 1) {  
		        hour = "0" + hour;  
		    }  
		    if (minute.length == 1) {  
		        minute = "0" + minute;  
		    }  
		    if (second.length == 1) {  
		        second = "0" + second;  
		    }  
		     var dateTime = year + "-" + month + "-" + day +" "+ hour +":"+minute+":"+second;  
		     return dateTime;  
	  }  
	refreshMenu();
	
	//搜索笔记
	$('#searchnote').click(function(){
		searchNote();
	});
	
	$("#searchnotetext").keyup(function(event){
        if (event.keyCode == 13) { 
        	searchNote();
        }  
		
    });
	
	
	function searchNote(){
		keyword = $.trim($('#searchnotetext').val());
		if(keyword == ''){
			layer.msg("请输入搜索关键字");
			return;
		}
		//点击搜索默认搜索第一页前20个
		var pageNo = 1;
		var noteBookId;
		//如果目前笔记列表是搜索所有笔记的内容 则noteBookId为空 因为在其他地方设置了选择笔记以后 selectedBook为选中笔记的笔记本 再搜索就会只搜索这个笔记本下的笔记了
		if($("#selectedBook").attr("name") == "所有笔记"){
			noteBookId = null;
		}else{
			noteBookId = $("#selectedBook").attr("value");
		}
		 
		var html = "";
		 $.ajax({  
	          type : "get",  
	          url : "/note/searchNote",  
	          data : {keyword: keyword,pageNo:pageNo,pageSize:pageSize,noteBookId:noteBookId},  
	          async : false,  
	          success : function(data){  
				if(data.status != "200"){
					layer.msg(data.msg);
				}else{
					if(data.data.list.length == 0){
						layer.msg("无搜索结果");
					}else{
						jQuery.each(data.data.list,function(i,item){
							var lis = getNoteHtml(item);
							html += lis;
						});
						$(".node-body-ul").html(html);
						
						searchFlag = true;
						$("#notePageNo").attr("value",data.data.pageNo);
						$("#notePageSize").attr("value",data.data.pageSize);
						$("#noteCount").attr("value",data.data.count);
						$("#noteLastPage").attr("value",data.data.lastPage);
					}
				}
				refreshMenu();
	          }  
	     }); 
	}
	
	
	
	//笔记本滚动条   http://www.jq22.com/jquery-info1425
	$('.main-menu').slimScroll({
		width: 'auto', //可滚动区域宽度
		height: '100%', //可滚动区域高度
	});
	
	
	//笔记滚动条
	$('#innerDiv').slimScroll({  
		width: 'auto', //可滚动区域宽度
		height: '98%', //可滚动区域高度
	
	});
	//笔记滚动条滚到到最底时执行的代码
	$('#innerDiv').slimScroll().bind('slimscroll', function(e, pos){  
		if(pos=='bottom'){
		   if($("#noteLastPage").attr("value") == "false"){

			   var html = $(".node-body-ul").html();
			   $("#loading").addClass("spinner");
			   var pageNo = parseInt($("#notePageNo").attr("value")) + 1;
			   //如果目前是分页的搜索结果
			   if(searchFlag){
				   $.get("note/searchNote",{
						noteBookId: selectedBookId,
						pageNo: pageNo,
						pageSize: pageSize,
						keyword: keyword
				   },function(data){
						if(data.status != "200"){
							layer.msg(data.msg);
						}else{
							setPageDate(data,html);
						}
						refreshMenu();
						$("#loading").removeClass("spinner");
				   })
				   
			   }else{
					$.get("note/getNoteTitleList", {
						noteBookId: selectedBookId,
						pageNo: pageNo
						
						},function(data){
						if(data.status != "200"){
							layer.msg(data.msg);
						}else{
							setPageDate(data,html);
						}
						refreshMenu();
						$("#loading").removeClass("spinner");
					});
			   }


		   }
		   
		}
	});  
	
	function setPageDate(data,html){
		jQuery.each(data.data.list,function(i,item){
			var lis = getNoteHtml(item);
			html += lis;
		});
		$(".node-body-ul").html(html);
		$("#notePageNo").attr("value",data.data.pageNo);
		$("#notePageSize").attr("value",data.data.pageSize);
		$("#noteCount").attr("value",data.data.count);
		$("#noteLastPage").attr("value",data.data.lastPage);
	}
	
	//左侧获取笔记本方法
	function getBooks(){
		var clickObject = $(this);
		var parentElm = clickObject.parent().parent();
		var parentClickObjeck = clickObject.parent();
		if(clickObject.hasClass("glyphicon-chevron-right")){
			$.get("/noteBook/getNoteBook/" + clickObject.next().attr("value"),function(data){
				if(data.status != "200"){
					layer.msg(data.msg);
				}else{
					var html="";
					jQuery.each(data.data,function(i,item){
						var lis = getBookHtml(item);
						html += lis;
					});
					parentClickObjeck.next().html(html);
					//关闭所有获取笔记本元素的点击事件
					$('.glyphicon-chevron-right').off("click");
					//给获取笔记本元素绑定点击事件
					$('.glyphicon-chevron-right').on("click",getBooks);
					//鼠标经过出现设置按钮
					showsetting();
				    //刷新笔记本右键和设置菜单
				    refreshMenu();
				}
			});
			clickObject.removeClass("glyphicon-chevron-right");
			clickObject.addClass("glyphicon-chevron-down");
			parentElm.children('.subtree').show();
		}else{
			clickObject.removeClass("glyphicon-chevron-down");
			clickObject.addClass("glyphicon-chevron-right");
			parentElm.children('.subtree').hide();

		}
		return false;
	}
	
	
	function getBookHtml(item){
		var lis="<li class='openable'><a href='#' class='showsetting'>";
		if(item.haveNode){
			lis += "<span class='glyphicon glyphicon-chevron-right m-right-xs folder-icon'></span>";
		}else{
			lis += "<span class='glyphicon glyphicon-chevron-right m-right-xs folder-icon' style='opacity:0'></span>";
		}
		lis += "<span class='noteBookName' value="
		lis += item.id;
		lis += " parentId="
		lis += item.parentId
		lis += ">";
		lis += item.name
		lis += "</span>";
		lis += "<span title='设置' class='booksetting glyphicon glyphicon-cog'></span>";
		lis += "<span title='笔记数量' style='float:right;font-size:14px'>" + item.noteCount +"</span>";
		lis += "</a><ul class='subtree'></ul></li>";
		return lis;
	}
	
	
	
	//退出登录
	$("#loginout").click(function(){
		  $.post("/user/loginout",
				function(data) {
				if(data.status != "200") {
				layer.msg(data.msg);
				} else {
					location.href=data.data;
				}
				
			});
		
		
	});
	
	
	
	//添加笔记本
	$('#addnotebook').click(function(){
		layer.prompt({title: '输入笔记本名，并确认', formType: 3}, function(name, index){
			  layer.close(index);
			  $.post("/noteBook/addNoteBook",{
				name:name
				},
				function(data) {
				if(data.status != "200") {
				layer.msg(data.msg);
				} else {
					  //设置内容
					  var text=getBookHtml(data.data);
					  //把内容对象转换会jQuery对象
					  var bookli = $(text);
					  //获取如果有笔记本 则把新加的笔记本加到第一个 如果没有 则把笔记本加到ul中
					  if($("#listbooks").children("li").length != 0){
						  //获取ul下的第一个li 在第一个li前加上text中的内容
						  bookli.insertBefore($("#listbooks").children().first());
					  }else{
						  $("#listbooks").html(text);
					  }
					  //刷新笔记本右键和设置菜单
					  refreshMenu();
					  $("#listbooks").find(".showsetting").first().click();
					  $("#listbooks").find(".showsetting").first().addClass("clickBookNote");
					  showsetting();
					  //刷新笔记本右键和设置菜单
					  refreshMenu();
				}
	
			  });

		});
	});
	function showsetting(){
		//鼠标经过出现设置按钮
		$(".showsetting").hover(function(){
			$(this).find(".booksetting").eq(0).css("opacity","100");
		},function(){
			$(this).find(".booksetting").eq(0).css("opacity","0");
		});
	}
	
	//typeahead搜索笔记本功能   https://www.cnblogs.com/shiyu404/p/6344591.html
	$('#noteBookSearch').typeahead({
		source: function(query, process){
			//ajax请求当前用户下所有的笔记
            return $.ajax({
                url: '/noteBook/getSearchNoteBook',
                type: 'post',
                data: {name: query},
                success: function (result) {
    				if(result.status != "200") {
    					layer.msg(data.msg);
    				}else{
                    	//对返回的结果进行处理 只需要id和name
                        var resultList = result.data.map(function (item) {
                            var aItem = {id: item.id, name: item.name};
                            //转换成json
                            return JSON.stringify(aItem);
                        });
                        return process(resultList);
    				}

                },
            });
		},
		items : 15,
		//只对name进行匹配
	    matcher: function (obj) {
	        var item = JSON.parse(obj);
	        return ~item.name.toLowerCase().indexOf(this.query.toLowerCase())
	    },
		//只对name进行高亮显示
        highlighter: function (obj) {
            var item = JSON.parse(obj);
            var query = this.query.replace(/[\-\[\]{}()*+?.,\\\^$|#\s]/g, '\\$&');
            return item.name.replace(new RegExp('(' + query + ')', 'ig'), function ($1, match) {
                return '<strong>' + match + '</strong>'
            });
        },
        //选择要搜索的笔记 只设置input框的内容为name  并且设置当前选中的笔记本id和name  然后加载当前笔记本下的笔记
        updater: function (obj) {
            var item = JSON.parse(obj);
    		$(".showsetting").removeClass("clickBookNote");
    		//循环遍历笔记本 判断已经显示的笔记本是否和搜索的笔记本id一样 如果一样则设置笔记本为点击状态
    		$(".noteBookName").each(function(){
    			if(item.id ==$(this).attr("value")){
    				$(this).parent().addClass("clickBookNote");
    				return false;
    			}
    		});
    		
    		$("#selectedBook").attr("value",item.id);
    		//设置全局的笔记本id和笔记本name
    		selectedBookId = item.id;
    		bookName = item.name;
    		var selectedBook = $("#selectedBook");
    		noteBookClick(selectedBook);
    		selectedBook.attr("name",item.name);
            return item.name;
        }
	})
	
	
	
	var book;
	var onClick = function(e) {
		//获取notebook这个元素
		book = $(this).prev();
		if(book.attr('class') != "noteBookName"){
			book = $(this).find(".noteBookName");
		}
		var items = [
						{ title: '添加子笔记本', icon: 'ion-plus-round', fn: addNodeNoteBook },
						{ title: '重命名', icon: 'ion-edit', fn: rename },
						{ title: '删除笔记本', icon: 'ion-trash-a', fn: deleteNoteBook },
					]

					basicContext.show(items, e.originalEvent)
				
				//添加子笔记本
				function addNodeNoteBook(){
					layer.prompt({title: '输入笔记本名，并确认', formType: 3}, function(name, index){
						  layer.close(index);
						  $.post("/noteBook/addNoteBook",{
							name:name,
							parentId:book.attr("value")
							},
							function(data) {
							if(data.status != "200") {
							layer.msg(data.msg);
							} else {
								  var html ="";
								  //设置内容
								  var text= getBookHtml(data.data);
								  html += text;
								  //获取笔记名前面的三角
								  var triangle = book.prev();
								  //获取subtree这个元素
								  var subtree = book.parent().next();
								  //如果三角属性为透明 则设置为不透明并且样式为下拉样式
								  if(triangle.css("opacity") == "0"){
									  triangle.css("opacity","100");
									  triangle.removeClass("glyphicon-chevron-right");
									  triangle.addClass("glyphicon-chevron-down");
									  subtree.html(html);
									  subtree.show();
									  //关闭所有获取笔记本元素的点击事件
									  $('.glyphicon-chevron-right').off("click");
									  //给获取笔记本元素绑定点击事件
									  $('.glyphicon-chevron-right').on("click",getBooks);
									  //鼠标经过出现设置按钮
									  showsetting();
									  //刷新笔记本右键和设置菜单
									  refreshMenu();
								  }else{
									  triangle.removeClass("glyphicon-chevron-right");
									  triangle.addClass("glyphicon-chevron-down");
									  subtree.html(html + subtree.html());
									  subtree.show();
									  //关闭所有获取笔记本元素的点击事件
									  $('.glyphicon-chevron-right').off("click");
									  //给获取笔记本元素绑定点击事件
									  $('.glyphicon-chevron-right').on("click",getBooks);
									  //鼠标经过出现设置按钮
									  showsetting();
									  //刷新笔记本右键和设置菜单
									  refreshMenu();
								  }
								  
							}
				
						  });

					});
				}
				
				//删除笔记本
				function deleteNoteBook(){
					//获取笔记数量
					var noteSum = book.next().next().text();
					if(noteSum != "0"){
						layer.msg("该笔记本下有笔记不可删除!!!");
						return;
					}
					//获取小三角的透明度
					var isNote = book .prev().css("opacity");
					if(isNote != "0"){
						layer.msg("该笔记本下有子笔记不可删除!!!");
						return;
					}
					
					layer.confirm('确定要删除该笔记本吗,如果有子笔记本或者有笔记无法删除', {
						  btn: ['确定','取消'] //按钮
						}, function(index){
							 $.post("/noteBook/deleteNoteBook",{
									id:book.attr("value"),
									parentId:book.attr("parentId")
									},
									function(data) {
									if(data.status != "200") {
										layer.msg(data.msg);
									} else {
										if(book.attr("parentId") == "0"){
											book.parent().parent().remove();
										}else{
											//如果父笔记本已经没有子笔记本
											if(!data.data){
												//获取父笔记本的三角设置透明度为0
												book.parent().parent().parent().prev().find(".folder-icon").first().css("opacity","0");
												book.parent().parent().remove();
											}else{
												book.parent().parent().remove();
											}
										}
										var firstNoteBook = $("#listbooks").find(".showsetting").first();
										//如果有笔记本则执行笔记本点击按钮
										if(firstNoteBook != null){
											firstNoteBook.click();
										}
										refreshMenu();
									}
							 });
							 layer.close(index);
						});
				}
					
				//重命名笔记本
				function rename(){
					layer.prompt({title: '输入新笔记本名，并确认', formType: 3}, function(name, index){
						  layer.close(index);
						  $.post("/noteBook/updateNoteBook",{
							id:book.attr("value"),
							name:name
							},
							function(data) {
							if(data.status != "200") {
							layer.msg(data.msg);
							} else {
								book.html(data.data.name);
							}
				
						  });

					});
				}
	}
	
	//笔记本右键设置按钮
	$('.showsetting').on('contextmenu', onClick);
	//笔记本设置按钮
	$('.booksetting').on('click', onClick);
	
	//刷新笔记本右键和设置菜单
	function refreshMenu(){
		  //关闭所有笔记设置按钮的点击事件 后面重新加上
		  $('.showsetting').off('click')
		  $('.showsetting').off('contextmenu');
		  //关闭所有笔记设置按钮的点击事件 后面重新加上
		  $('.booksetting').off('click');
		  //关闭笔记本点击事件 后面重新加上
		  $('.node-body-ul-li').off('click');
		  //绑定点击笔记本按钮触发事件
		  $('.showsetting').on('click',clickBookNote);
		  //笔记本右键设置按钮
		  $('.showsetting').on('contextmenu', onClick);
		  //笔记本设置按钮
		  $('.booksetting').on('click', onClick);
		  //笔记本点击事件
		  $('.node-body-ul-li').on('click',clickTitleNote);

	}
	

});

