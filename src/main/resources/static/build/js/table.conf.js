var table;

$(document).ready(function() {
	
	var table = $('#datatable-pt_br-responsivo').DataTable({
    	dom:
	        "<'row'<'col-sm-6'l><'col-sm-3'f><'col-sm-3 text-right'C>>" +
	        "<'row'<'col-sm-12'tr>>" +
	        "<'row'<'col-sm-5'i><'col-sm-7'p>>",
	        
    		language: {
    	        decimal: ",",
    	        
		        "sEmptyTable": "Nenhum registro encontrado",
		        "sInfo": "Mostrando de _START_ at&eacute _END_ de _TOTAL_ registros",
		        "sInfoEmpty": "Mostrando 0 at&eacute 0 de 0 registros",
		        "sInfoFiltered": "(Filtrados de _MAX_ registros)",
		        "sInfoPostFix": "",
		        "sInfoThousands": ".",
		        "sLengthMenu": "_MENU_ resultados por p&aacutegina",
		        "sLoadingRecords": "Carregando...",
		        "sProcessing": "Processando...",
		        "sZeroRecords": "Nenhum registro encontrado",
		        "sSearch": "Pesquisar",
		        "oPaginate": {
		            "sNext": "Pr&oacuteximo",
		            "sPrevious": "Anterior",
		            "sFirst": "Primeiro",
		            "sLast": "&Uacuteltimo"
		        },
		        "oAria": {
		            "sSortAscending": ": Ordenar colunas de forma ascendente",
		            "sSortDescending": ": Ordenar colunas de forma descendente"
		        }
		    }
    });
 
    // Edit record
    $('#datatable-pt_br-responsivo').on( 'click', 'button.Modal', function () {
		$(".spin-load").css("visibility", "visible");
	 	var id			= $(this).data('id');
	 	
	  	$.post(edition_param, {'id' : id}, function(resposta) {
			$("#modal_content").html(resposta);
			$(".spin-load").css("visibility", "hidden");
	  	});
    });

	// Delete a record
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
	   				      //$("#tr_"+id).fadeOut();
	     			    	$("#tr_"+id).css('background-color','#f2dede');
	     			    	$("#edition-buttons_"+id).remove();
	     			    	//$("#edition-buttons_"+id).html(function(){ return'<button type="button" data-id="'+id+'" class="btn btn-success btn-xs restore-button" id="restore_'+id+'"> <i class="fa fa-refresh"></i> Restaurar</button>'});
	   					});
	 	            }
	 	        },
	 	    }
		});
    });

	// Restore a record
	$('#datatable-pt_br-responsivo').on( 'click', 'button.restore-button', function () {
	 	var id = $(this).data('id');
	 	
	    $.post(restore_param, {'id' : id}, function(resposta) {
		    $("#restore_"+id).remove();
		    $(".restore-info").fadeIn();
		});
	 	$("#tr_"+id).data('history') != 'true';
	});
	
	$(".toolbox-history-return, .restore-button").css("display", "none");
	
	$.fn.dataTable.ext.search.push(
      function(settings, data, dataIndex) {
          return $(table.row(dataIndex).node()).attr('data-history') != 'true';
        }
    );
    table.draw();

	// Pega variável
	$(".toolbox-history").click(function() {
		
	    $.fn.dataTable.ext.search.pop();
	    table.draw();
		
		$(".toolbox-history, .edition-buttons").css("display", "none");
		$(".toolbox-history-return, .restore-button").css("display", "block");
	});


	// Pega variável
	$(".toolbox-history-return").click(function() {
		
		$.fn.dataTable.ext.search.push(
	      function(settings, data, dataIndex) {
	          return $(table.row(dataIndex).node()).attr('data-history') != 'true';
	        }
	    );
	    table.draw();

		$(".toolbox-history, .edition-buttons").css("display", "block");
		$(".toolbox-history-return, .restore-button").css("display", "none");
	});
});
	