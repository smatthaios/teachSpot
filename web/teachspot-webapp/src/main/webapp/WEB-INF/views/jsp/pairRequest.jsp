<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--<c:if test="${empty param.uuid}"> <c:redirect url="/login.html" /> </c:if> <!doctype html>--%>
<html>
	<head>
		<c:import url="includes/headLight.jsp" />
	</head>

	<body <%--ng-app="app" id="ng-app" ng-cloak class="login-body"--%>>
		<c:import url="includes/headerLight.jsp" />
		<div ng-controller="Login" class="overflow-hidden">
            <img src="<c:url value="/img/temp.png"/>" class="img-responsive cart" />
			<div class="visible-sm visible-md visible-lg">
				<div class="space-32"></div>
				<div class="space-32"></div>
				<div class="space-32"></div>
			</div>
			<div class="space-32"></div>
			<form autocomplete="off" class="col-lg-offset-3 col-lg-6 col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-10">
				<div class="grid2">
					<div class="b"><fmt:message key="general.label.newPassword" />:</div>ASDASD
					<div class="input-group form-group">
                        <span class="input-group-addon">
                            <i class="icon-key smaller-80"></i>
                        </span> <input id="newPassword" type="password" ng-model="newPassword" required placeholder="<fmt:message key="general.label.newPassword" />" class="form-control" />
					</div>
					<div class="input-group form-group">
                        <span class="input-group-addon">
                            <i class="icon-key smaller-80"></i>
                        </span>
						<input id="confirmNewPassword" type="password" placeholder="<fmt:message key="generic.label.confirmNewPass" />" ng-model="confirmNewPassword" required class="form-control" />
					</div>
					<div class="form-group text-right">
						<button class="btn btn-sm btn-success" ng-click="setPassword('${param.uuid}')"><fmt:message key="general.button.submit" /></button>
					</div>
				</div>
				<div class="grid2">
                    <span>
                        <fmt:message key="general.label.rightDisclaimer" />
                    </span>
				</div>
			</form>
	</body>
</html>
