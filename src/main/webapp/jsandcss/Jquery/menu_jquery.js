$( document ).ready(function() {
	
	var pathname = window.location.pathname;
	var urlpathname = pathname.split("/");
	if ((pathname.indexOf("applyLeave") >= 0) || (pathname.indexOf("cancelLeave") >= 0) ){
		$('li').find('a[href*="Leaves"]').parent().addClass('active');
		$('li a[href*="Leaves"]').next('ul').slideDown('normal');
	}
	else if ((pathname.indexOf("changePassword") >= 0) || (pathname.indexOf("changePassword") >= 0) ){
			$('li').find('a[href*="Settings"]').parent().addClass('active');
			$('li a[href*="Settings"]').next('ul').slideDown('normal');
	}
	else{
		$('li').find('a[href*="'+urlpathname[2]+'"]').parent().addClass('active');
	}
	
$('#cssmenu > ul > li > a').click(function() {
	$( document ).load(function() {
	alert($(this).attr('href'));
	});
	  $('#cssmenu li').removeClass('active');
	  $(this).closest('li').addClass('active');	
	  var checkElement = $(this).next();
	  if((checkElement.is('ul')) && (checkElement.is(':visible'))) {
	    $(this).closest('li').removeClass('active');
	    checkElement.slideUp('normal');
	  }
	  if((checkElement.is('ul')) && (!checkElement.is(':visible'))) {
	    $('#cssmenu ul ul:visible').slideUp('normal');
	    checkElement.slideDown('normal');
	  }
	  if($(this).closest('li').find('ul').children().length == 0) {
	    return true;
	  } else {
	    return false;	
	  }		
});
});