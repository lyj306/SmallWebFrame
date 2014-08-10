$(function(){
   $(".menu li a").live("click",function(){
     $(this).parents("li").addClass("choosed");
   });
   //菜单
   $(".item").live("click",function(){
     var _this=$(this);
     _this.find(".subItem").show().end()
          .find("s").hide(); 
   });
    $(".item").hover(function(){
     var _this=$(this);
       _this.find(".subItem").show().end()
          .find("s").hide(); 
   },function(){
      var _this=$(this);
       _this.find(".subItem").hide().end()
          .find("s").show(); 
   });
   //banner
   $(".rollNum li").live("click",function(){
    var _this=$(this),_index=_this.index();
	_this.addClass("selectedStyle").siblings().removeClass("selectedStyle");
	$(".slider li").hide();
    $(".slider li").eq(_index).show();
   });
   $(".slider").banner(300,"left");
   //抢购
   $(".newProductShow").hide();
   $(".newProductShow:eq(0)").show();
   $(".newProduct li").live("click",function(){
    var _this=$(this),_index=_this.index();
      _this.addClass("selectOne").siblings().removeClass("selectOne");
	  _this.parents(".newProduct").siblings(".newProductShow").hide();
	  _this.parents(".newProduct").siblings(".newProductShow").eq(_index).show();
   });
   //一周销量排行
   $(".numBuy").hide();
   $(".numBuy:eq(0)").show();
   $(".saleNum li").live("click",function(){
     var _this=$(this);
     _this.find(".num").addClass("numChoose");
	 _this.find(".numBuy").show();
	 _this.siblings().find(".num").removeClass("numChoose");
	 _this.siblings().find(".numBuy").hide();              
   });
   //礼品中心
   $(".giftDetail").hide();
   $(".giftDetail:eq(0)").show();
   $(".giftType li").live("click",function(){
    var _this=$(this),_index=_this.index();
      _this.addClass("selectGift").siblings().removeClass("selectGift");
	  _this.parents(".giftType").siblings(".giftDetail").hide();
	  _this.parents(".giftType").siblings(".giftDetail").eq(_index).show();
   });
});
;(function($){
       //幻灯片 滚动$(div).banner(s,"left");s是多少毫秒,向左滚动。
   $.fn.banner=function(s){
		var id=$(this),$ul=id.find("ul"),$uli=$ul.find("li"),n=$uli.length,_ol="<ol>";
		for(var i=0;i<n;i++){_ol+="<li>"+(i+1)+"</li>";}
		_ol+="</ol>";
		id.append(_ol);
    var $ol=id.find("ol"),$oli=$ol.find("li");
		$oli.eq(0).addClass("hover");
		var ctrl = $oli,cnt = $ul,timer = null,current = 0;
		var $ulWidth =$uli.get(0).offsetWidth,$ulHeight = $uli.get(0).offsetHeight,$ulse=$ulHeight,direction="top";
    $ul.se=$ul.height;
    if(arguments[1]=="top"){direction=arguments[1];$ul.se=$ul.height;$ulse=$ulHeight;}
    if(arguments[1]=="left"){direction=arguments[1];$ul.se=$ul.width;$ulse=$ulWidth;}
		$ul.se($ul.se()*$oli.length);
		function play(){
			timer = setInterval(
				function(){
					$ul.animate(eval("({"+direction+":-(++current%$oli.length)*$ulse})"),s,function(){
						$oli.removeClass().eq(current%$oli.length).addClass('hover');
					});
					if(current == $oli.length-1) current = -1;
			},3600);
		}
		play();
		$($oli).each(function(i){
			$(this).hover(function(){
				clearInterval(timer);
				$ul.stop().animate(eval("({"+direction+":-i*$ulse})"),s,function(){current=i;});
				$oli.removeClass().eq(i).addClass("hover");
			},function(){play();}
			);
		});
		return id;
	}

})(jQuery);
