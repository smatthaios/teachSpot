<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html ng-app="app" id="ng-app" ng-cloak>
	<head>
		<c:import url="includes/head.jsp" />
		<script>
			var authenticationFailed = '<%=request.getParameter("e")%>';
		</script>
	</head>

	<%
        /*
            1. id="ng-app" is required for IE.
            2. The ngCloak directive is used to prevent the Angular html template from being briefly displayed by the
            browser in its raw (uncompiled) form while your application is loading
        */
    %>

    <body class="fixed-header">
        <!-- BEGIN LOGIN-WRAPPER -->
        <div class="login-wrapper">

            <div class="bg-pic">

                <img src="<c:url value="/img/login.jpg" />" data-src="<c:url value="/img/login.jpg" />" data-src-retina="<c:url value="/img/login.jpg"/>" alt="" style="width: 100%; opacity: 1" class="lazy">


                <div class="bg-caption pull-bottom sm-pull-bottom text-white p-l-20 m-b-20">
                    <h2 class="semi-bold text-white">
                       Welcome to TeachSpot Administration Console</h2>
                    <p class="small">
                        Work and copyright © 2016-2017 DreamBig.
                    </p>
                </div>
            </div>

            <div class="login-container bg-white" ng-controller="Login">
                <div class="p-l-50 m-l-20 p-r-50 m-r-20 p-t-50 m-t-30 sm-p-l-15 sm-p-r-15 sm-p-t-40">
                    <img src="assets/img/logo.png" alt="logo" data-src="assets/img/logo.png" data-src-retina="assets/img/logo.png">
                    <p class="p-t-35">Login to Admin Console</p>

                    <div id="form-login" class="p-t-15" role="form">

                        <div class="form-group form-group-default">
                            <label>Login</label>
                            <div class="controls">
                                <input type="text" ng-model="username" name="username" placeholder="User Name" class="form-control" required>
                            </div>
                        </div>


                        <div class="form-group form-group-default">
                            <label>Password</label>
                            <div class="controls">
                                <input type="password" ng-model="password" class="form-control" name="password" placeholder="Credentials" required>
                            </div>
                        </div>

                        <%--<div class="row">
                            <div class="col-md-6 no-padding">
                                <div class="checkbox ">
                                    <input type="checkbox" value="1" id="checkbox1">
                                    <label for="checkbox1">Keep Me Signed in</label>
                                </div>
                            </div>
                            <div class="col-md-6 text-right">
                                <a href="#" class="text-info small">Help? Contact Support</a>
                            </div>
                        </div>--%>

                        <button class="btn btn-primary btn-cons m-t-10" ng-click="submit()"><fmt:message key="login.submit" /></button>
                    </div>
                </div>
            </div>

        </div>
        <!-- END LOGIN-WRAPPER-->
        <c:import url="includes/footer.jsp" />
    </body>
</html>
