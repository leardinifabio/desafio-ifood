// IIFE - Immediately Invoked Function Expression
(function (code) {

    code(window.jQuery, window, document);

}(function ($, window, document) {

    $(function () {

        // Eventos
        $('.delete').on('click', function (event) {
            event.preventDefault();
            
            const href = $(this).attr('href');
            const swalWithBootstrapButtons = Swal.mixin({
            	customClass: {
	            	confirmButton: 'btn btn-success',
	                cancelButton: 'btn btn-danger'
            	},
                buttonsStyling: false
            });

            swalWithBootstrapButtons.fire({
                title: 'Deseja remover o item?',
                text: "Você não poderá reverter esta operação!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonText: 'Sim, remova!',
                cancelButtonText: 'Não, cancele!',
                reverseButtons: true
            }).then((result) => {
                if (result.value) {
                    swalWithBootstrapButtons.fire(
                        'Removido!',
                        'O item foi removido com sucesso.',
                        'success'
                    ).then(function () {
                        window.location.href = href;
                    });
                } else if (
                    // Read more about handling dismissals
                    result.dismiss === Swal.DismissReason.cancel
                ) {
                    swalWithBootstrapButtons.fire(
                        'Cancelado',
                        'Seu registro não será removido!',
                        'error'
                    )
                }
            });
        });
    });
}));