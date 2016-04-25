<%@ page import="org.springframework.web.servlet.i18n.SessionLocaleResolver" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
<meta content="" name="description" />
<meta content="" name="author" />
<!-- BEGIN Vendor CSS-->
<link href="<c:url value="/assets/plugins/pace/pace-theme-flash.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/assets/plugins/boostrapv3/css/bootstrap.min.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/assets/plugins/font-awesome/css/font-awesome.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/assets/plugins/jquery-scrollbar/jquery.scrollbar.css" />" rel="stylesheet" type="text/css" media="screen" />
<link href="<c:url value="/assets/plugins/bootstrap-select2/select2.css" />" rel="stylesheet" type="text/css" media="screen" />
<link href="<c:url value="/assets/plugins/switchery/css/switchery.min.css" />" rel="stylesheet" type="text/css" media="screen" />
<%--<link href="<c:url value="/styles/app.css" />" rel="stylesheet" type="text/css" media="screen" />--%>
<!-- BEGIN Pages CSS-->
<link href="<c:url value="/styles/pages-icons.css" />" rel="stylesheet" type="text/css">
<link class="main-stylesheet" href="<c:url value="/styles/pages.css" />" rel="stylesheet" type="text/css" />

<script type="text/javascript">
    window.onload = function()
    {
        // fix for windows 8
        if (navigator.appVersion.indexOf("Windows NT 6.2") != -1){
            document.head.innerHTML += '<link rel="stylesheet" type="text/css" href="<c:url value="/styles/windows.chrome.fix.css" />" />'
        }
    }

    var PAGES_INITIALIZED = false;
</script>

<%--<link rel="stylesheet" type="text/css" href="<c:url value="/styles/ext/ext-theme-gray-all.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/styles/b.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/styles/generic.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/styles/ace.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/styles/app.css" />" />--%>
<%--<link rel="stylesheet" type="text/css" href="<c:url value="/styles/app.css" />" />--%>
<%--<link rel="stylesheet" type="text/css" href="<c:url value="/styles/bootstrap/css/bootstrap-timepicker.css" />" />--%>

<%--<link href="<c:url value="/styles/pace/pace-theme-flash.css" />" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/styles/bootstrap/css/bootstrap.min.css" />" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/assets/plugins/font-awesome/css/font-awesome.css" />" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/styles/jquery/jquery.scrollbar.css" />" rel="stylesheet" type="text/css" media="screen"/>
<link href="<c:url value="/styles/select2/select2.css" />" rel="stylesheet" type="text/css" media="screen"/>
<link href="<c:url value="/styles/switchery/switchery.min.css" />" rel="stylesheet" type="text/css" media="screen"/>
<link href="<c:url value="/styles/codrops-dialogFx/dialog.css" />" rel="stylesheet" type="text/css" media="screen"/>
<link href="<c:url value="/styles/codrops-dialogFx/dialog-sandra.css" />" rel="stylesheet" type="text/css" media="screen"/>
<link href="<c:url value="/styles/owl-carousel/owl.carousel.css" />" rel="stylesheet" type="text/css" media="screen"/>
<link href="<c:url value="/styles/jquery/jquery.nouislider.css" />" rel="stylesheet" type="text/css" media="screen"/>
<link href="<c:url value="/styles/pages-icons.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/styles/pages.css" />" rel="stylesheet" type="text/css">--%>

<%--<script type='text/javascript' src="<c:url value="/js/jquery/jquery.min.js" />"></script>--%>
<%--<script type='text/javascript' src="<c:url value="/assets/plugins/jquery/jquery-1.11.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/jquery/jquery.slimscroll.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/jquery/jquery.hotkeys.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/jquery/jquery-ui.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/jquery/jquery.validate.min.js" />"></script>



<script type="text/javascript" src="<c:url value="/js/bootstrap/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/bootstrap/typeahead-bs2.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/bootstrap/bootbox.min.js" />"></script>

<script type="text/javascript" src="<c:url value="/js/ace/ace-elements.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/ace/ace.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/ace/ace-extra.min.js" />"></script>

<script type="text/javascript" src="<c:url value="/js/generic/modernizr.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/generic/prettify.js" />"></script>



<script type="text/javascript" src="<c:url value="/js/pages.min.${minifiedAddon}js" />"></script>--%>
<%--<script type="text/javascript" src="<c:url value="/js/pages.${minifiedAddon}js" />"></script>--%>

<!-- BEGIN VENDOR JS -->
<script src="<c:url value="/assets/plugins/pace/pace.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/assets/plugins/jquery/jquery-1.11.1.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/assets/plugins/modernizr.custom.js" />" type="text/javascript"></script>
<script src="<c:url value="/assets/plugins/jquery-ui/jquery-ui.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/assets/plugins/boostrapv3/js/bootstrap.min.js" />" type="text/javascript"></script>
<script type="text/javascript" src="<c:url value="/js/bootstrap/bootbox.min.js" />"></script>
<script src="<c:url value="/assets/plugins/jquery/jquery-easy.js" />" type="text/javascript"></script>
<script src="<c:url value="/assets/plugins/jquery-unveil/jquery.unveil.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/assets/plugins/jquery-bez/jquery.bez.min.js" />"></script>
<script src="<c:url value="/assets/plugins/jquery-ios-list/jquery.ioslist.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/assets/plugins/imagesloaded/imagesloaded.pkgd.min.js" />"></script>
<script src="<c:url value="/assets/plugins/jquery-actual/jquery.actual.min.js" />"></script>
<script src="<c:url value="/assets/plugins/jquery-scrollbar/jquery.scrollbar.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/jquery/jquery.blockUI.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/jquery/jquery.gritter.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/generic/notify.min.js" />"></script>

<script type="text/javascript" src="<c:url value="/js/angular/angular.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/angular/angular-route.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/angular/select2.js" />"></script>

<script type="text/javascript" src="<c:url value="/js/smartTables/smart-table.min.js" />"></script>

<script type="text/javascript" src="<c:url value="/js/generic/underscore-min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/generic/moment.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/generic/select2.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/generic/daterangepicker.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/highcharts/highstock.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/highcharts/no-data-to-display.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/highcharts/highcharts-more.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/highcharts/exporting.js" />"></script>

<!-- END VENDOR JS -->

<script type="text/javascript" src="<c:url value="/js/app.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/c.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/messages.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/application/controller/login.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/application/controller/mainboard.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/application/controller/profile.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/application/controller/sideBar.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/application/controller/userManagement.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/application/service/userService.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/application/service/rest/userServiceRest.js" />"></script>

<script type="text/javascript" src="<c:url value="/js/configuration/highChartsConf.js" />"></script>
<%--<script type="text/javascript" src="<c:url value="/js/configuration/appConf.js" />"></script>--%>

<%-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries  --%>
<!--[if lt IE 9]>
<!--<script type="text/javascript" src="<c:url value='/js/ie/html5shiv.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/ie/respond.min.js' />"></script>-->
<![endif]-->









<!--[if IE ]>
<!--<script type="text/javascript" src="<c:url value="/js/generic/json3.min.js" />"></script>-->
<![endif]-->

<link type="image/x-icon" rel="shortcut icon" href="<c:url value="/img/favicon.ico" />" />

<!--[if lte IE 8]>
<script>
window.location = "browserCompatibility.html"
</script>
<![endif]-->
<script>
    baseUrl = '<c:url value="/" />';
    var isMobile = Modernizr.touch;

    Locale.setLocale(Locale.ENGLISH);

    /** Fix to get modal with tabindex='-1' work with select2.js. (We override enforceFocus constructor) */
    //$.fn.modal.Constructor.prototype.enforceFocus = function() {};

    /** Prevent block ui from showing cursor at wait mode, after execution (IE8 bug). */
    //$.blockUI.defaults.css.cursor = 'default';
</script>
<title><fmt:message key="general.label.title" /></title>
