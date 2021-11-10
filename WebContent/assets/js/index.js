// IIFE - Immediately Invoked Function Expression
(function (code) {

    code(window.jQuery, window, document);

}(function ($, window, document) {

    MutationObserver = window.MutationObserver || window.WebKitMutationObserver;
    
    // Eventos
    $(function () {
    
    });
    
    // Funções globais
    window.showNotification = function (type, message, title = null) {
        var timer = 5000, icon, from, align;

        if (type == 'success') {
            from = 'top';
            align = 'right';
            icon = 'fas fa-check-circle';
        }

        if (type == 'info' || type == 'primary' || type == 'default' || type == '') {
            from = 'top';
            align = 'right';
            icon = 'fa fa-info-circle';
        }

        if (type == 'warning') {
            from = 'top';
            align = 'right';
            icon = 'fa fa-exclamation-triangle';
        }

        if (type == 'danger') {
            from = 'top';
            align = 'right';
            icon = 'fa fa-exclamation-circle';
        }

        if (type == undefined) {
            from = 'top';
            align = 'right';
            icon = 'fa fa-info-circle';
        }

        var notify = $.notify({
            icon: icon,
            title: title,
            message: message
        }, {
                type: type,
                placement: {
                    from: from,
                    align: align
                },
                timer: timer,
                template: '<div data-notify="container" class="col-xs-10 col-sm-4 alert alert-{0}" role="alert">' +
                    '<button type="button" aria-hidden="true" class="close" data-notify="dismiss">&times;</button>' +
                    '<span data-notify="icon" class="pull-left fa-3x" style="padding-right: 10px"></span> ' +
                    '<span data-notify="title"><h4>{1}</h4></span> ' +
                    '<span data-notify="message">{2}</span>' +
                    '<div id="notify-progress-bar" class="progress" data-notify="progressbar" style="height:10px !important; margin:10px 0 -10px">' +
                    '<div class="progress-bar progress-bar-{0}" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"></div>' +
                    '</div>' +
                    '<a href="{3}" target="{4}" data-notify="url"></a>' +
                    '</div>'
            });
    }
    
    // Funções locais
    function validateForm(input) {
        var form = input.parents('form').get(0);

        if (form) {
            if (form.checkValidity()) {
                $(this).parents('form').find('[type="submit"]').prop('disabled', false);
            }
            else {
                $(this).parents('form').find('[type="submit"]').prop('disabled', true);
            }

            if (input[0].validity.valid) {
                input.parent().removeClass('has-error');
            }
            else {
                input.parent().addClass('has-error');
            }
        }
    }

    observer.observe($('html').get(0), { attribute: true, characterData: true, childList: true, subtree: true });
}));