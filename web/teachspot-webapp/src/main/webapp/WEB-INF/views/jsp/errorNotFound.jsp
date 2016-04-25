<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" session="false" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>
    <head>
        <c:import url="/WEB-INF/views/jsp/includes/headBasic.jsp" />
    </head>
    <%
    /*
    1. id="ng-app" is required for IE.
    2. The ngCloak directive is used to prevent the Angular html template from being briefly displayed by the
    browser in its raw (uncompiled) form while your application is loading
    */
%>
    <body class="login-body">
        <c:import url="/WEB-INF/views/jsp/includes/headerBasic.jsp" />
        <div class="space-6"></div>
        <div class="overflow-hidden">
            <div class="row">

                <div class="col-lg-offset-3 col-lg-6 col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-10" >

                    <div class="row">
                        <div class="col-xs-12">
                            <!-- PAGE CONTENT BEGINS -->

                            <div class="error-container">
                                <div class="well">
                                    <h1 class="grey lighter smaller">
                                        <span class="blue bigger-125"><i class="icon-sitemap"></i></span>&nbsp;<fmt:message key="error.label.pageNotFound" />
                                    </h1>

                                    <hr>
                                    <h3 class="lighter smaller"><fmt:message key="error.label.title" /></h3>

                                    <div>
                                             <div class="space"></div>
                                        <h4 class="smaller"><fmt:message key="error.label.text1" /></h4>

                                        <ul class="list-unstyled spaced inline bigger-110 margin-15">
                                            <li>
                                                <i class="icon-hand-o-right blue"></i>
                                                <fmt:message key="error.label.text2" />
                                            </li>
                                            <li>
                                                <i class="icon-hand-o-right blue"></i>
                                                <fmt:message key="error.label.text3" />
                                            </li>
                                        </ul>
                                    </div>

                                </div>
                            </div>
                            <!-- PAGE CONTENT ENDS -->
                        </div><!-- /.col -->
                    </div>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.main-container -->
    </body>
</html>



