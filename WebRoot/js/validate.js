//////////////////////////////////////
// validate form input @auth by lyj //
//////////////////////////////////////

var $validate = {
	focusInputArray : ['email', 'nickname', 'userkey1', 'userkey2'],
	
	cssinfo : {
		rightImg : "<img src='images/r.PNG' />" ,
		rigthColor : "#00FF00",
		wrongImg : "<img src='images/w.PNG' />" ,
		wrongColor : "#FF0000",
		
		focusBorder : "#33FF00" ,
		unFocusBorder : "#B2B2B2"
	},
	
		
	
	init : function () {
		
		for (var i=0; i<this.focusInputArray.length; i++) {
			$validate.focusInput(this.focusInputArray[i]); //
		}
	
		$("#email").change(function(){$validate.valiMail('email')}) ;
		
		$("#userkey1").change(function(){$validate.checkPassword('userkey1')}) ;
		
		$("#userkey2").change(function(){$validate.checkRePasswrod('userkey1', 'userkey2')}) ;
	},
	
	/**
	 * 
	 */
	focusInput : function (id) {
		$("#"+id).focus(function(){$(this).css({borderColor:$validate.cssinfo.focusBorder})}).blur(function(){$(this).css({borderColor:$validate.cssinfo.unFocusBorder})});
	},
	
	valiMail: function (id) {
		var flg = true ;
		var vValue = $("#"+id).val() ;
		$("#"+id).val(vValue) ;
		if(vValue == "") {
			flg = false ;
			$("#"+id+"_info").css({color:$validate.cssinfo.wrongColor}).html($validate.cssinfo.wrongImg+"Email不能为空");
		}
		var re = /^([\w]+)@([\w]+)\.([\w]+)$/;
		if(re.test(vValue) == false){
			flg = false ;
			$("#"+id+"_info").css({color:$validate.cssinfo.wrongColor}).html($validate.cssinfo.wrongImg+"请输入正确Email");
		}
		
		if (flg) {
			$("#"+id+"_info").css({color:$validate.cssinfo.rigthColor}).html($validate.cssinfo.rightImg);
		}
	},


	checkPassword : function (id){
		var flg = true ;
		var passwordValue =$("#"+id).val() ;
		if(passwordValue == ""){
			flg = false ;
			$("#"+id).val("") ;
			$("#"+id+"_info").css({color:$validate.cssinfo.wrongColor}).html($validate.cssinfo.wrongImg+"密码不能为空！");
	
		} else if(passwordValue.length < 6 || passwordValue.length > 16){
			flg = false ;
			$("#"+id).val("") ;
			$("#"+id+"_info").css({color:$validate.cssinfo.wrongColor}).html($validate.cssinfo.wrongImg+"请输入6~16位密码！");
	
		}
		
		if (flg) {
			$("#"+id+"_info").css({color:$validate.cssinfo.rigthColor}).html($validate.cssinfo.rightImg);
		}
	},
	
	/**
	 *
	 */
	checkRePasswrod : function (id1, id2){
		var flg = true ;
		var passwordValue = $("#"+id1).val() ;
		var re_passwordValue = $("#"+id2).val() ;
		
		if(passwordValue == ""){
			flg = false ;
			$("#"+id1).val("") ;
			$("#"+id2).val("") ;
			$("#"+id1+"_info").css({color:$validate.cssinfo.wrongColor}).html($validate.cssinfo.wrongImg+"请先输入6~16位密码！");
		}
		if(re_passwordValue != passwordValue){
			flg = false ;
			$("#"+id2).val("") ;
			$("#"+id2+"_info").css({color:$validate.cssinfo.wrongColor}).html($validate.cssinfo.wrongImg+"两次密码不同，请重新输入！");
		}
		
		if (flg) {
			$("#"+id2+"_info").css({color:$validate.cssinfo.rigthColor}).html($validate.cssinfo.rightImg);
		}
	}
	
};






$(function(){	
	$validate.init();
});

