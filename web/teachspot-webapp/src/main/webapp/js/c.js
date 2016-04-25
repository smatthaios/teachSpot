$.extend($.gritter.options, {
    class_name: 'gritter-center', // for light notifications (can be added directly to $.gritter.add too)
    position: 'top-right', // possibilities: bottom-left, bottom-right, top-left, top-right
    fade_in_speed: 100, // how fast notifications fade in (string or int)
    fade_out_speed: 100, // how fast the notices fade out
    time: 2000 // hang on the screen for...
});

Validator = (function () {
    var numericCls = 'numeric';
    var numericPositiveCls = 'numericPositive';
    var mandatoryCls = 'mandatory';
    var inputErrorCls = 'error';
    var tooltipErrorCls = 'tooltip-error';
    var tipPlacement = 'right';

    function wrapTitle(title) {
        return '<span class="btn-danger">' + title + '</span>'
    }

    function init() {
        $('.' + mandatoryCls).each(function (index, el) {
            $(el).on('input', function () {
                validateMandatory($(this));
            })
        });

        $('.' + numericCls).each(function (index, el) {
            $(el).on('input', function () {
                validateNumber(el, false);
            })
        });

        $('.' + numericPositiveCls).each(function (index, el) {
            $(el).on('input', function () {
                validateNumber(el, true);
            })
        });

        $('input[type="email"]').each(function (index, el) {
            $(el).on('input', function () {
                validateEmail(el);
            })
        });
    }

    function execute(area) {
        $((area ? area : 'body' )).find('.' + numericCls).not(':hidden').each(function (index, el) {
            if ($(el).hasClass(inputErrorCls)) {
                return false;
            }
            validateNumber(el);
        });

        $((area ? area : 'body' )).find('.' + mandatoryCls).not(':hidden').each(function (index, el) {
            if ($(el).hasClass(inputErrorCls)) {
                return false;
            }
            validateMandatory(el);
        });

        $((area ? area : 'body' )).find('input[type="email"]').not(':hidden').each(function (index, el) {
            if ($(el).hasClass(inputErrorCls)) {
                return false;
            }
            validateEmail(el);
        });
    }

    function isValid(area) {
        Validator.execute(area);
        return $((area ? area : 'body')).find('.' + inputErrorCls).length == 0;
    }

    function validateNumber(el, positive) {
        var jEl = $(el);
        if (jEl.is(':hidden')) {
            return;
        }
        var value = jEl.val();
        if (value && !isNumeric(value)) {
            showErrorMessage(jEl, 'Please provide a valid number');
        } else if (positive) {
            if (parseFloat(value) <= 0) {
                showErrorMessage(jEl, 'Please provide a valid positive (> 0) number');
            } else {
                jEl.tooltip('destroy').removeClass(inputErrorCls + ' ' + tooltipErrorCls);
            }
        } else {
            jEl.tooltip('destroy').removeClass(inputErrorCls + ' ' + tooltipErrorCls);
        }
    }

    function validateMandatory(el) {
        var jEl = $(el);
        var value = jEl.val();

        if (jEl.hasClass('select2') && jEl.is('select')) {
            return;
        } else if (jEl.hasClass('select2')) {
            value = jEl.select2('val');
        }

        if (jEl.is(":hidden")) {
            jEl = $("#" + el.id + "_chosen");
            if (jEl.length == 0) {
                return;
            }
        }

        if (!value) {
            showErrorMessage(jEl, 'This field&nbsp;is mandatory');
        } else {
            removeValidationMessage(jEl);
        }
    }

    /**
     * Validates if content is a valid email address.
     */
    function validateEmail(el) {
        var jEl = $(el);
        if (jEl.val().length > 0) {
            if (!isEmail(jEl.val())) {
                showErrorMessage(jEl, 'Email is not valid');
                return false;
            } else {
                removeValidationMessage(jEl);
            }
        } else {
            removeValidationMessage(jEl);
        }
        return true;
    }

    function showErrorMessage(element, message) {
		console.log('Show error message')
        element.tooltip({
            title: message,
            placement: tipPlacement,
            html: true,
            delay: { show: 200 }
        }).addClass(inputErrorCls + ' ' + tooltipErrorCls).tooltip('show');
    }

    /**
     * Checks the validity of email provided.
     */
    function isEmail() {
        if (arguments[0]) {
            if (!(/^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-]+\.)+([a-zA-Z]{2,5})$/).test(arguments[0])) return false;
        }
        return true;
    }

    function isNumeric() {
        if (!arguments[0]) {
            return false;
        }
        return $.isNumeric(arguments[0]);
    }

    function removeValidationMessage(el) {
        el.tooltip('destroy').removeClass(inputErrorCls + ' ' + tooltipErrorCls).next('.tooltip').remove();
    }

    function reset(parentElementId) {
        var errorElements = parentElementId ? $(parentElementId).find('.' + inputErrorCls) : $('.' + inputErrorCls);
        var tooltipElements = parentElementId ? $(parentElementId).find('.tooltip') : $('.tooltip');

        errorElements.each(function () {
            removeValidationMessage($(this));
        });
    }

    return {
        execute: execute,
        init: init,
        reset: reset,
        isValid: isValid,
        showErrorMessage: showErrorMessage
    }
})();

/*
 *  Important!! This transformer should be used when we need to parse fields with @RequestParam annotation at REST layer.
 *  This is an AngularJS specific method which may accept a headers object in order to target to a specific method.
 */
function prepareFormConfig(urlHeaders, params) {

	var headers = {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'};

	if (urlHeaders) {
		headers = _.extend(headers, urlHeaders);
	}

	var urlEncodedFormConfig = {
		headers: headers,
        params: params,
		transformRequest: function (data) {
			// If this is not an object, defer to native stringification.
			if (!angular.isObject(data)) {

				return( ( data == null ) ? "" : data.toString() );

			}

			var buffer = [];

			// Serialize each key in the object.
			for (var name in data) {
				if (!data.hasOwnProperty(name)) {
					continue;
				}

				var value = data[ name ];

				buffer.push(encodeURIComponent(name) + "=" + encodeURIComponent(( value == null ) ? "" : value));

			}

			// Serialize the buffer and clean it up for transportation.
			var source = buffer
					.join("&")
					.replace(/%20/g, "+")
				;

			return( source );
		}
	};
	return urlEncodedFormConfig;
}

Notify = (function () {
    var infoId;
    var errorId;
    var warningId;
    return {
        error: function (message, title) {
            var title = title ? title : Locale.get('problem');
            bootbox.dialog({
                className: "modal-error",
                message: message,
                title: '<i class="icon-warning cred"></i>&nbsp;' + title,
                buttons: {
                    success: {
                        label: "<i class='icon-check green'></i>OK",
                        className: "btn-white btn-sm"
                    }
                },
                onEscape: function () {
                }
            });
        },
        warning: function (message, okMethod) {
            bootbox.dialog({
                className: "modal-warning",
                title: '<i class="icon-warning"></i>&nbsp;' + Locale.get('warning'),
                message: message,
                buttons: {
                    cancel: {
                        label: "<i class='icon-undo gray'></i>Cancel",
                        className: 'btn-white btn-sm'
                    },
                    success: {
                        label: "<i class='icon-check green'></i>OK",
                        className: "btn-white btn-sm",
                        callback: okMethod
                    }
                },
                onEscape: function () {
                }
            });
        },
        warningNoCancel: function (message, okMethod) {
            bootbox.dialog({
                title: '<i class="icon-warning"></i>&nbsp;' + Locale.get('warning'),
                className: "modal-warning",
                idProperty: "warningNoCancelPopup",
                message: message,
                buttons: {
                    success: {
                        label: "<i class='icon-check green'></i>OK",
                        className: "btn-white btn-sm popup",
                        callback: okMethod
                    }
                },
                onEscape: function () {
                }
            });
        },
        info: function (message, header) {
			console.log(message)
            if (infoId) {
                $.gritter.remove(infoId);
            }
            var header = header ? header : Locale.get('info');
            infoId = $.gritter.add({
                title: header,
                text: message,
                class_name: 'gritter-success'
            });
        },
        infoModal: function (message) {
            bootbox.dialog({
                title: '<i class="icon-info-circle blue"></i>&nbsp;' + Locale.get('info'),
                message: message,
                buttons: {
                    success: {
                        label: "<i class='icon-check green'></i>OK",
                        className: "btn-white btn-sm"
                    }
                },
                onEscape: function () {
                }
            });
        },
        infoModalWithMethod: function (message, okMethod) {
            bootbox.dialog({
                title: '<i class="icon-info-circle blue"></i>&nbsp;' + Locale.get('info'),
                message: message,
                closeButton: false,
                buttons: {
                    success: {
                        label: "<i class='icon-check green'></i>OK",
                        className: "btn-white btn-sm",
                        callback: okMethod
                    }
                },
                 onEscape: function () {
                 }
            });
        },
        prompt: function (message, okMethod) {
            bootbox.dialog({
                className: "modal-warning",
                title: '<i class="icon-warning cred"></i>&nbsp;' + Locale.get('warning'),
                message: message,
                buttons: {
                    cancel: {
                        label: "<i class='icon-undo gray'></i>Cancel",
                        className: 'btn-white btn-sm'
                    },
                    success: {
                        label: "<i class='icon-check green'></i>OK",
                        className: "btn-white btn-sm",
                        callback: okMethod
                    }
                },
                onEscape: function () {
                }
            });
        },
        promptSave: function (message, okMethod) {
            bootbox.dialog({
                className: "modal-warning",
                title: '<i class="icon-warning cred"></i>&nbsp;' + Locale.get('warning'),
                message: message,
                buttons: {
                    cancel: {
                        label: "<i class='icon-undo gray'></i>Cancel",
                        className: 'btn-white btn-sm'
                    },
                    success: {
                        label: "<i class='icon-save green'></i>Save",
                        className: "btn-white btn-sm",
                        callback: okMethod
                    }
                },
                onEscape: function () {
                }
            });
        },
        nonBlockingWarning: function (message, header) {
            var header = header ? header : Locale.get('warning');
            if (warningId) {
                $.gritter.remove(warningId);
            }
            warningId = $.gritter.add({
                title: header,
                text: message,
                class_name: 'gritter-warning'
            });
        },
        nonBlockingError: function (message, header) {
            var header = header ? header : Locale.get('problem');
            if (errorId) {
                $.gritter.remove(errorId);
            }
            errorId = $.gritter.add({
                title: header,
                text: message,
                class_name: 'gritter-error'
            });
        }
    }
})();

function fire($scope, eventName, data) {
    $scope.$broadcast(eventName, data);
}

function errorCallback() {
    $('.blockUI').hide();
    Notify.error(Locale.get('genericError'));
}

function successCallback(response, deferred, hideMask) {

    if (Response.ERROR == response.status) {
        deferred.reject('Execution finished with error');
        Notify.error(response.statusMessage);
        $('.blockUI').hide();
        return;
    } else if(Response.WARNING == response.status){
        deferred.reject('Execution finished with warning');
        //Notify.warningNoCancel(response.statusMessage);
        $('.blockUI').hide();
        return;
    }
    deferred.resolve(response.data);

    hideMask ? $('body').mask(hideMask) : $('body').mask(false);
}

function successCallbackWithFullResponse(response, deferred, hideMask) {

	if (Response.ERROR == response.status) {
		deferred.reject('Execution finished with error');
		Notify.error(response.statusMessage);
		$('.blockUI').hide();
		return;
	} else if(Response.WARNING == response.status){
        deferred.reject('Execution finished with warning');
        //Notify.warningNoCancel(response.statusMessage);
        $('.blockUI').hide();
        return;
    }
	deferred.resolve(response);

	hideMask ? $('body').mask(hideMask) : $('body').mask(false);
}

function isResponseValid(response, suppressError) {
	if (ResponseStatusLocal.ERROR == response.status) {
		if(!suppressError)
			Notify.error(response.statusMessage);
		return false;
	} else if (ResponseStatusLocal.SESSION_EXPIRED == response.status) {
		Notify.infoModal(response.statusMessage, function () {
			window.location.href = baseUrl;
		});
		return false;
	}
	return true;
}

/** Resource bundles support for client-side needs. */
Locale = {
    /* Supported locales, default is English locale. */
    locales: {
        FRENCH: "fr",
        ENGLISH: "en"
    },
    /* The bundles */
    bundles: {},
    /* Set the locale. */
    setLocale: function (locale) {
        Locale.locale = locale;
    },
    /* Set a resource bundle */
    setBundle: function (locale, bundle) {
        Locale.bundles[locale] = bundle;
    },
    /* Retrieve a string from the resource bundle */
    get: function (key, args) {
        return Locale.tx(Locale.bundles[Locale.locale || Locale.locales.ENGLISH][key] || Locale.bundles[Locale.locales.ENGLISH][key] || "<UNDEFINED>", args);
    },
    /* Translate a string with optional args. */
    tx: function (string, args) {
        if (typeof args == "string") {
            args = [args];
        }
        var tokens = string.match(/{\d+}/g);
        if (tokens) {
            for (var i = 0; i < tokens.length; i++) {
                string = string.replace(tokens[i], args[i]);
            }
        }
        return string;
    }
};

Fx = (function () {
    return {
        addSpinner: function (el) {
            $(el).addClass('disabled').prepend('<i class="icon-spinner icon-spin cred bigger-150"></i>');
        },
        removeSpinner: function (el) {
            $(el).removeClass('disabled').find('.icon-spin').remove();
        },
        hideModal: function (modalId) {
            $('#' + modalId).modal('hide');
        },
        showModal: function (modalId) {
            $('#' + modalId).modal('show');
        },
        showBox: function (id) {
            $('.widget-box.visible').removeClass('visible');
            $('#' + id).addClass('visible');
        }
    }
})();

/*Navigation = (function () {

    function activateMenuItem(activePath) {
        $('#sidebar li.active').removeClass('active');
        var activeElement = $("[href='#!" + activePath + "']");
        activeElement.parent().addClass('active');
        activeElement.parents('.submenu').show();
    }

    return {
        activateMenuItem: activateMenuItem
    }
}());*/

Layout = (function () {
    var equalHeightCls = 'equal-heights';
    return {
        fixHeight: function (container) {
            var containers = $(container + ' .' + equalHeightCls);
            containers.each(function () {
                var maxHeight = 0;
                var panelBodies = $(this).find('.panel-body');
                panelBodies.each(function () {
                    maxHeight = $(this).height() > maxHeight ? $(this).height() : maxHeight;
                });
                panelBodies.height(maxHeight);
            });
        },
        equalHeights: function (selector) {
            var containers = $(selector);
            var maxHeight = 0;
            containers.each(function () {
                maxHeight = $(this).height() > maxHeight ? $(this).height() : maxHeight;
            });

            containers.each(function () {
                $(this).css('min-height', maxHeight);
            });
        },
        init: function () {
            var bodyWidth = $('body').width();
            $('body,.row').css('min-width', bodyWidth);
        }
    }
}());

$.fn.extend({
    mask: function (show, message) {
        var opts = {
            css: {
                backgroundColor: 'none'
            }
        };

        var self = $(this), element;
        if (self.hasClass('modal')) {
            element = self.find('.modal-content')
        } else {
            element = self;
        }

        opts.message = message ? message : '<i class="icon-spinner icon-spin white bigger-300"></i>';

		var isBlocked = element.data('blockUI.isBlocked');
		if (show) {
			if(!isBlocked){
				element.block(opts);
			}
		} else {
			element.unblock();
		}

        return self;
    },
    blockEl: function (show) {
        this.mask(show, ' ')
    },
    scrollView: function () {
        return this.each(function () {
            $('html, body').animate({
                scrollTop: $(this).offset().top
            }, 1000);
        });
    }
});