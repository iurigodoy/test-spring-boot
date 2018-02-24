
// Tooltip
function funcaoTooltip() {
    $('[data-toggle="tooltip"]').tooltip({
        container: 'body'
    });
};
// /Tooltip

// Edit record
function funcaoEditar(){
	$('.table').on( 'click', 'button.Modal', function () {
		$(".spin-load").css("visibility", "visible");
	 	var id			= $(this).data('id');
	 	
	  	$.post(edition_param, {'id' : id}, function(resposta) {
			$("#modal_content").html(resposta);
			$(".spin-load").css("visibility", "hidden");
	  	});
	});
}

// Delete a record
function funcaoDeletar(){
	$('#datatable-pt_br-responsivo').on( 'click', 'button.delete-button', function () {
	 	var id = $(this).data('id');
		
		// Jquery confirm
	 	$.confirm({
	 		title: 'Você tem certeza?',
	 	    content: delete_message,
	 	    type: 'red',
	 	    typeAnimated: true,
	 	    
	 	    closeIcon: true,
	 	    closeIconClass: 'fa fa-close',
	 	    
	 	    backgroundDismiss: true, // this will just close the modal
	 	    
	 	    buttons: {
	 	        cancelar: {
	 	            text: 'Não',
	 	            keys: ['esc', 'n']
	 	        },
	 	        deletar: {
	 	            text: 'Sim',
	 	            keys: ['enter', 's'],
	 	            btnClass: 'btn-red',
	
	 	            action: function(){
	     			    $.post(delete_param, {'id' : id}, function(resposta) {
	     			    	$("#tr_"+id).css('background-color','#f2dede');
	     			    	$("#edition-buttons_"+id).remove();
	   					});
	 	            }
	 	        },
	 	    }
		});
	});
}