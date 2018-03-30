$(function(){
	$("#modal").modal({backdrop:false, keyboard:false});
	
	$("#modal01").modal("show");
	window.open("index.html"); 
	setTimeout(function(){
		$("#modal01").modal("hide");
	}, 3000);
});

/*$(function alerta(){
	$(".open").click(function(){
		$('#myAlert').show()
	});
}); */ 
document.querySelector('form input').oninvalid = function(evt) {
    // cancela comportamento padrão do browser
    evt.preventDefault();

    // checa validade e mostra alert
    if (!this.validity.valid) {
        alert("Nome obrigatório!");
    }
};
/*$(function(){
    $(".close").click(function(){
       $("#myAlert").alert("hide");
    }, 3000);
 });  

$(function(){
    $(".close").click(function(){
       $("#myAlert").alert('close');
    });
 });  

$('#myAlert').on('closed.bs.alert', function () {
	setTimeout(function(){
		$("#myAlert").modal("hide");
	}, 3000);
})*/