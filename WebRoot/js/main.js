/**
 * 动态加载js
 */
function loadJs(_url, _callBack){
	$.getScript(_url).done(function () { 
		//全局处理
		
		//回调函数
		if(_callBack && typeof _callBack == 'function'){
			_callBack();
		}
	}); 
}






