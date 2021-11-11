// IIFE - Immediately Invoked Function Expression
(function (code) {

    code(window.jQuery, window, document);

}(function ($, window, document) {

    $(function () {

        // Eventos
        $('.cep').on('focusout', function (event) {
            event.preventDefault();            
            const cep = $(this).val().replace('-', '');

            if (cep != "") { 
	            var url = `https://viacep.com.br/ws/${cep}/json`;
	            
	            const xmlHttp = new XMLHttpRequest();
			    xmlHttp.open( "GET", url, false ); // false for synchronous request
			    xmlHttp.send( null );
			    const response = JSON.parse(xmlHttp.responseText);
	
				$('.uf').val(response.uf);
				$('.cidade').val(response.localidade);
				
				if (response.bairro != "" && response.logradouro != "") {
					$('.bairro').attr("readonly", true);
					$('.bairro').val(response.bairro);
					$('.logradouro').attr("readonly", true);
					$('.logradouro').val(response.logradouro);
				} else {
					$('.bairro').attr("readonly", false);
					$('.bairro').val(response.bairro);
					$('.logradouro').attr("readonly", false);
					$('.logradouro').val(response.logradouro);
				}
			} else {
				$('.uf').val("AC");
				$('.cidade').val("");
				$('.bairro').val("");
				$('.logradouro').val("");
			}
        });
    });
}));