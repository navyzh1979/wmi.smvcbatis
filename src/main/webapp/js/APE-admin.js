//分级菜单
$.fn.multiMenu=function(opt){
	var data={
		obj:this,
		list:"ul",
		item:"li"
	};
	var menuToggle = function(e){
		$(this).siblings().children(data.list).hide();
		$(this).children(data.list+":first-child").toggle();
		if(data.itemStyle){
			$(this).toggleClass(data.itemStyle).siblings().removeClass(data.itemStyle);
		};
	};
	var init=function(){
		$.extend(data,opt);
		data.obj.find(data.list).hide();
		
		//.addClass(data.itemStyle)
		data.obj.find(data.item).each(function(){
			$(this).bind("click",function(e){
				e.stopPropagation();
			});
			if($(this).find(data.item).length!==0){
				$(this).css("cursor","pointer");
				$(this).bind("click",menuToggle);
			};
		});
		if(data.itemStyle){
			data.obj.find("a").bind("click",function(){
				data.obj.find("a").parent().removeClass("arrow");
				$(this).parent().addClass("arrow");
			});
		};
	}();
};

//标签切换
$.fn.tabs = function(opt){
	var data = {
		obj:this,
		nav:".tabs-nav",
		panel:".tabs-panel",
		sel:"hover"
	};
	
	$.extend(data,opt);
	data.obj.find(data.nav+">li").eq(0).addClass(data.sel);
	data.obj.find(data.panel+">li").eq(0).show().siblings().hide();
	
	data.obj.find(data.nav+">li").bind("click",function(){
		$(this).addClass(data.sel).siblings().removeClass(data.sel);;
		data.obj.find(data.panel+">li").eq(data.obj.find(data.nav+" li").index($(this))).show().siblings().hide();
	});
};
// 表格排序
$.fn.sortable=function(opt){
	var data={
		obj:this,
		list:{},
		tlist:[],
		slist:[],
		handle:null,
		c:1, //用来判断表格内的内容是否修改，如果没修改就不重新计算
		order:"asc"
	};
	var method={
		getList:function(handleIndex){
			data.slist.length=0;
			data.tlist.length=0;
			//获取表格内容
			data.list=data.obj.find("tbody tr");
			//对内容排序，末尾的x用来记录排序前的下标
			for(var x=0;x<data.list.length;x++){
				data.tlist.push(data.list.eq(x).find("td").eq(handleIndex).html()+x);
			}
			data.tlist=data.tlist.sort(sortNumber);
			//获取排序后下标数组
			for(x in data.tlist){
				data.slist.push(data.tlist[x].slice(data.tlist[x].lastIndexOf(".")+3));
			}
			data.c=0;
		},
		sortList:function(){
			data.obj.find("tbody tr").remove();
			if(data.order=="asc"){
				for(x in data.slist){
					data.obj.find("tbody").append(data.list.eq(data.slist[x]));
				}
				data.order="desc";
			}else if(data.order=="desc"){
				for(x in data.slist){
					data.obj.find("tbody").prepend(data.list.eq(data.slist[x]));
				}
				data.order="asc";
			}
		}
	};
	var init=function(){
		$.extend(data,opt);
		data.handle=data.handle?data.handle:data.obj.find("th");
		data.handle.addClass(data.sortTips);
		
		data.handle.each(function(){
			$(this).click(function(){
				var handleIndex=data.obj.find("th").index($(this));
				if(data.c==1){
					method.getList(handleIndex);
				}
				method.sortList();
			});
		});
	}();
}

var sortNumber=function(a,b){
	return a-b;
};