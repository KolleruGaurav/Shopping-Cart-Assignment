// Date Picker//

$(document).ready(function(){

loadingImage = new Image();
loadingImage.src = "images/loading2.gif";
 
$('.datetimepicker').on('change', function(){
    //alert("hi");
	datetimepicker.trigger('close.xdsoft');
});

});

function show_loadingDiv() {
	
	var el1 = $("#blanket");
	if (el1)
		
		el1.css("display", "block");
	var el = $("#loadingDiv");
	if (el) {
		
		blanket_size("loadingDiv");
		el.css("display", "block");
		el.append(loadingImage);
	}
	
	
	/*var el1 = document.getElementById("blanket");
	if (el1) 
		el1.style.display = 'block';		
	var el = document.getElementById("loadingDiv");
	if (el) {		
		blanket_size("loadingDiv");
		el.style.display = 'block';
		//el.innerHTML = '<img src="images/loading2.gif">';
		//el.innerHTML = '<img src="' + document.getElementById("msactx").value + '/images/loading2.gif">';		
		el.appendChild(loadingImage);
	}*/
	
}

function close_loadingDiv() {
	var el = document.getElementById("loadingDiv");
	if(el)
		el.style.display = 'none';
	var el1 = document.getElementById("blanket");
	if(el1)
		el1.style.display = 'none';
}

function blanket_size(popUpDivVar) {
	if (typeof window.innerWidth != 'undefined') {
		viewportheight = window.innerHeight;
	} else {
		viewportheight = document.documentElement.clientHeight;
	}
	if ((viewportheight > document.body.parentNode.scrollHeight) && (viewportheight > document.body.parentNode.clientHeight)) {
		blanket_height = viewportheight;
	} else {
		if (document.body.parentNode.clientHeight > document.body.parentNode.scrollHeight) {
			blanket_height = document.body.parentNode.clientHeight;
		} else {
			blanket_height = document.body.parentNode.scrollHeight;
		}
	}
	blanket_height = blanket_height+40;
	var blanket = document.getElementById('blanket');
	blanket.style.height = blanket_height + 'px';
	var popUpDiv = document.getElementById(popUpDivVar);
	popUpDiv_height=blanket_height/2-150;//150 is half popup's height
	//popUpDiv.style.top = popUpDiv_height + 'px';
	
}