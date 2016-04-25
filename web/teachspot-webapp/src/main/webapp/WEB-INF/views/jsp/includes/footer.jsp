<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
    <head>
    </head>

    <body>
        <!-- BEGIN CORE TEMPLATE JS -->
        <script src="<c:url value="/js/pages.js" />" type="text/javascript"></script>
        <!-- END CORE TEMPLATE JS -->
        <!-- BEGIN PAGE LEVEL JS -->
        <script type="text/javascript" src="<c:url value="/assets/js/scripts.js" />"></script>
        <!-- END PAGE LEVEL JS -->

        <script>
            angular.element(document).ready(function () {
                (function($) {
                    'use strict';
                    // Initialize layouts and plugins
                    //$.Pages.init();
                })(window.jQuery);
            });
            //Angular breaks if this is done earlier than document ready.

        </script>
    </body>

</html>