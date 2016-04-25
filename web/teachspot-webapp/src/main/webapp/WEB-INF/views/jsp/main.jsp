<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
    <head>
        <c:import url="includes/head.jsp" />
		<script>
			var activeUser = '${user}';
		</script>
    </head>
    <%
        /*
            1. id="ng-app" is required for IE.
            2. The ngCloak directive is used to prevent the Angular html template from being briefly displayed by the
            browser in its raw (uncompiled) form while your application is loading
        */
    %>
    <body ng-app="app" id="ng-app" ng-cloak class="ng-cloak fixed-header">
        <div class="wrapper">
            <%--<c:import url="includes/header.jsp" />--%>
            <div ng-view></div>
        </div>
        <c:import url="includes/footer.jsp" />
    </body>
</html>