
$(function() {
	
		var noteId ;
		var noteBodyId;
	
		//标签
		var tag = $('#tags').tagsInput({
			'autocomplete':{selectFirst:true,width:'10px',autoFill:true},
			   'height':'100%',
			   'width':'100%',
			   'interactive':true,
			   'defaultText':'添加标签...',
			   'delimiter': [',',';'],   // Or a string with a single delimiter. Ex: ';'
			   'removeWithBackspace' : true,
			   'minChars' : 0,
			   'maxChars' : 0, // if not provided there is no limit
			   'placeholderColor' : '#d1d1d1'
		});
		$(".tagsinput").css("border","0px");
		$(".tagsinput").css("padding","0px 0px");
		
        var editor = editormd("editormd", {
            path : "js/md/lib/", // Autoload modules mode, codemirror, marked... dependents libs path
			width   : "100%",
            height  : "100%",
	        toolbarIcons : function() {
	            // 自定义工具类 如果在中间加,"||",代表右边的会显示在右边
	            return ["undo", "redo", "|", "bold", "hr", "quote", "|", "list-ul", "list-ol", "hr", "|", "link", "myimage", "preformatted-text", "code-block", "table", "html-entities", "|", "watch","preview","search","help"]
	        },
	        //自定义上传图片
	        toolbarCustomIcons : {
	            myimage   : "<a title='上传图片' unselectable='on'><i class='fa fa-picture-o' onclick='upimage()' unselectable='on'></i></a>"
	        },
	        tocm: true,
	        tex: true,                   // 开启科学公式TeX语言支持，默认关闭
	        flowChart: true,             // 开启流程图支持，默认关闭
	        sequenceDiagram: true,       // 开启时序/序列图支持，默认关闭,
            //启动本地图片上传功能
			imageUpload:true,
			imageFormats   : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
			saveHTMLToTextarea : true
        });

        //判断如果是查看笔记不是新建 则从后台获取数据显示
        if($("#noteId").attr("value") != null){
        	noteId = $("#noteId").attr("value");
	   		 $.ajax({  
		         type : "get",  
		          url : "/note/getNoteBody",  
		          data : {id:noteId},  
		          async : false,  
		          success : function(data){  
						if(data.status != "200") {
							layer.close(loading);
							layer.msg(data.msg);
						}else{
							var noteBody = data.data;
							if(noteBody.label != null){
								var tags = noteBody.label.split(",,;");
								$.each(tags, function(i,item){ 
									tag.addTag(item);
								});
								
							}
							if(noteBody.noteTitleName != null){
								$("#noteTitle").val(noteBody.noteTitleName);
							}
							if(noteBody.textType != null){
								$("#textType").val(noteBody.textType);
							}
							//设置md内容
							if(noteBody.mdNoteBody != null){
								$("#editormdText").text(noteBody.mdNoteBody);
								$(".markdown-body").html(noteBody.noteBody);
							}
							noteBodyId=noteBody.id;
							
						}
		          }  
		     }); 
        	
        	
        }
        
        
        refresh();
    	//历史记录功能
    	function clickHistory(){
    		layer.open({
    			  type: 2,
    			  title: '历史记录',
    			  shadeClose: true,
    			  shade: 0.8,
    			  area: ['900px', '600px'],
    			  content: 'historynote?noteBodyId=' + noteBodyId
    		}); 
    	}
        
        
        
        //绑定粘贴事件图片上传七牛云
		document.getElementById("editormd").addEventListener('paste', function(event){
			var event = event || window.event;
			var text = paste(event);
		});
        //粘贴图片上传七牛云
		function paste(event) {
			var clipboardData = event.clipboardData || window.clipboardData;
		    var items, item, types;
		    if (clipboardData) {
		        items = clipboardData.items;
		        if (!items) {
		            return;
		        }
		        // 保存在剪贴板中的数据类型
		        types = clipboardData.types || [];
		        for (var i = 0; i < types.length; i++) {
		            if (types[i] === 'Files') {
		                item = items[i];
		                break;
		            }
		        }
		       // 判断是否为图片数据
		        if (item && item.kind === 'file' && item.type.match(/^image\//i)) {
		            // 读取该图片
		            var file = item.getAsFile();
					//上传图片时显示过度图标
					var loading = layer.load(1, {shade: [0.1,'#fff']}); //0.1透明度的白色背景
				    var formData = new FormData();
				    formData.append('file', file);
				    //如果文件名为空代表是通过截图粘贴 则明明为随机字符串
				    if(!file.name){
				    	file.name = Math.random().toString(36).substr(2);
				    }
				    formData.append('key', currentTime() + file.name);
				    $.get('/qiniuyun/upload',null,function(data){
				   	 formData.append('token',data.data);
				   	 //上传七牛云
				   	 $.ajax({
				   	     url: 'http://upload.qiniu.com/',
				   	     type: 'POST',
				   	     cache: false,
				   	     data: formData,
				   	     processData: false,
				   	     contentType: false
				   	     
				   	 }).done(function(res) {
				   		 //关闭等待图标
				   		layer.close(loading);
				   		var qiniuUrl = '![](http://ouqhxmwfh.bkt.clouddn.com/' + res.key + ')';
				   	 	editor.insertValue(qiniuUrl);
				   	 }).fail(function(res) {
				   		layer.close(loading);
				   		layer.msg("上传失败请重试！！！");
				   	 });
				    },null,null);   
		            
           		}

		    }
		}
		//获取时间
		function currentTime(){
			var d = new Date(),
			 str = '';
			 str += d.getFullYear();
			 str  += d.getMonth() + 1;
			 var a = str + "/";
			 str  += d.getDate();
			 str += d.getHours(); 
			 str  += d.getMinutes(); 
			str+= d.getSeconds(); 
			return a + str;
		}
		$('#updateimage').change(function(e){
			var f = document.getElementById("updateimage").files;
			var file = f[0];
			var loading = layer.load(1, {shade: [0.1,'#fff']}); //0.1透明度的白色背景
		    var formData = new FormData();
		    formData.append('file', file);
		    //如果文件名为空代表是通过截图粘贴 则明明为随机字符串
		    if(!file.name){
		    	file.name = Math.random().toString(36).substr(2);
		    }
		    formData.append('key', currentTime() + file.name);
		    $.get('/qiniuyun/upload',null,function(data){
		   	 formData.append('token',data.data);
		   	 //上传七牛云
		   	 $.ajax({
		   	     url: 'http://upload.qiniu.com/',
		   	     type: 'POST',
		   	     cache: false,
		   	     data: formData,
		   	     processData: false,
		   	     contentType: false
		   	     
		   	 }).done(function(res) {
		   		 //关闭等待图标
		   		layer.close(loading);
		   		var qiniuUrl = '![](http://ouqhxmwfh.bkt.clouddn.com/' + res.key + ')';
		   	 	editor.insertValue(qiniuUrl);
		   	 }).fail(function(res) {
		   		layer.close(loading);
		   		layer.msg("上传失败请重试！！！");
		   	 });
		    },null,null);   
		})

		document.upimage=function() {
			var image = document.getElementById("updateimage");
			return image.click();

		}
		
		
		
		
		//保存笔记
		function noteClick(){
			//遍历tag 获取所有tag内容并且拼接 因为显示需要,,;这个符号所有已这个结尾
			var label = "";
			$(".tag").each(function(i,item){
				var tagtext = $(item).children('span').eq(0).html();
				if(tagtext == null){
					return false;
				}
				var index = tagtext.indexOf("&");
				tagtext = tagtext.substring(0,index);
				label += tagtext;
				label += ",,;";
			});
			if(label.length > 1){
				label = label.substring(0,label.length - 3);
			}
			var loading = layer.load(1, {shade: [0.1,'#fff']}); //0.1透明度的白色背景
			var md = editor.getMarkdown();       // 获取 Markdown 源码
			var html = editor.getHTML();           // 获取 Textarea 保存的 HTML 源码
			var context = $(html).text().substring(0,300);
			var title  = $("#noteTitle").val();
			var noteTitleId = $("#selectedNoteId").attr("value");
			var textType = $("#textType").val();
			var noteBookId =$("#selectedBook").attr("value");
		    $.post("/note/updateNote",{
		    	noteTitleId:noteTitleId,
				noteTitle:title,
				noteBody:html,
				noteContext:context,
		    	mdNoteBody:md,
		    	label:label,
		    	noteBookId:noteBookId,
		    	textType:textType
				},
				function(data) {
					if(data.status != "200") {
						layer.close(loading);
						layer.msg(data.msg);
					}else{
						layer.close(loading);
						layer.msg("保存成功")
						$(".clickTitleNote").find(".item-title").eq(0).html(title);
						$(".clickTitleNote").find(".updated-time").eq(0).html(dateToString(new Date()));
						if(context.length > 80){
							$(".clickTitleNote").find(".desc").eq(0).html(context.substring(0,80) + "...");
						}else{
							$(".clickTitleNote").find(".desc").eq(0).html(context);
						}
					}
					
		    });
		};
		
		$('#saveMd').off('click');
		$('#saveMd').on('click',noteClick)
		
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
		
		//删除笔记
		$("#delete").click(function(){
			var noteId = $("#selectedNoteId").attr("value");
			var lay = layer.confirm('确定要删除该笔记吗!', {
				  btn: ['确定','取消'] //按钮
				}, function(index){
						 $.ajax({  
					         type : "post",  
					          url : "/note/deleteNote",  
					          data : {noteId:noteId},  
					          async : false,  
					          success : function(data){  
									if(data.status != "200") {
										layer.msg(data.msg);
									}else{
										//去掉被删除的笔记标题
										$(".clickTitleNote").remove();
										var li = $(".node-body-ul-li").eq(0);
										//如果笔记标题栏中有笔记则选择第一个笔记 并执行点击事件 如果没有则执行笔记本的点击事件
										if(li.length > 0 ){
											li.addClass("clickTitleNote");
											var id =li.find(".note").eq(0).attr("value");
											$("#selectedNoteId").attr("value",id);
											li.click();
										}else{
											$(".clickBookNote").click();
										}
										//获取笔记对应笔记本
										var noteBookId = data.data;
										var noteBook = $("span[value$='" + noteBookId +"']");
										//如果存在则减一 不存在代表是没有显示的子笔记本没关系
										if(noteBook.length > 0){
											//获取笔记本的剩余笔记 减1
											var num = noteBook.next().next();
											num.html(parseInt(num.html()) - 1);
										}
										
									}
					          }  
					     }); 
						 layer.close(lay);
					 });
			
		});
		
		
		function refresh(){
			  $('.glyphicon-time').off('click',clickHistory);
			  $('.glyphicon-time').on('click',clickHistory);
		}

		
});
