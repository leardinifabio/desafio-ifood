// IIFE - Immediately Invoked Function Expression
(function (code) {

    code(window.jQuery, window, document);

}(function ($, window, document) {

    MutationObserver = window.MutationObserver || window.WebKitMutationObserver;
    
    // Eventos
    $(function () {
    	// Instancia as máscaras de input.
        $('[data-inputmask]').inputmask();
        $('[data-inputmask-regex]').inputmask('Regex');
    
    	// Instancia o tooltip do bootstrap
		$('[data-toggle="tooltip"]').tooltip();
    });
    
}));