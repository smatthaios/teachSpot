<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" %>
<div>
    <!-- START PAGE SIDEBAR -->
    <c:import url="../includes/sideBar.jsp" />
    <!-- END PAGE SIDEBAR -->

    <!-- START PAGE-CONTAINER -->
    <div class="page-container">
        <!-- START PAGE HEADER WRAPPER -->
        <c:import url="../includes/header.jsp" />
        <!-- END PAGE HEADER WRAPPER -->

        <!-- START PAGE CONTENT WRAPPER -->
        <div class="page-content-wrapper">
            <!-- START PAGE CONTENT -->
            <div class="content">
                <!-- START JUMBOTRON -->
                <div class="jumbotron" data-pages="parallax">
                    <div class="container-fluid container-fixed-lg sm-p-l-20 sm-p-r-20">
                        <div class="inner">
                            <!-- START BREADCRUMB -->
                            <ul class="breadcrumb">
                                <li>
                                    <p><a href="#!/mainboard">TeachSpot</a></p>
                                </li>
                                <li><a class="active">MainBoard</a>
                                </li>
                            </ul>
                            <!-- END BREADCRUMB -->
                        </div>
                    </div>
                </div>
                <!-- END JUMBOTRON -->
                <!-- START CONTAINER FLUID -->
                <div class="container-fluid container-fixed-lg">
                    <!-- BEGIN PlACE PAGE CONTENT HERE -->
                    <div class="container-fluid container-fixed-lg">
                        <div class="row">
                            <div class="col-md-8">

                                <div class="panel panel-transparent">
                                    <div class="panel-heading">
                                        <div class="panel-title"><h1>Welcome to TeachSpot!</h1></div>
                                    </div>
                                    <div class="panel-body">
                                       <%-- <table st-table="rowCollection" class="table table-striped">
                                            <thead>
                                                <tr>
                                                    <th colspan="5"><input st-search="" class="form-control" placeholder="global search ..." type="text"/></th>
                                                </tr>
                                                <tr>
                                                    <th>first name</th>
                                                    <th>last name</th>
                                                    <th>birth date</th>
                                                    <th>balance</th>
                                                    <th>email</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr ng-repeat="row in rowCollection">
                                                    <td>{{row.firstName}}</td>
                                                    <td>{{row.lastName}}</td>
                                                    <td>{{row.birthDate}}</td>
                                                    <td>{{row.balance}}</td>
                                                    <td>{{row.email}}</td>
                                                </tr>
                                            </tbody>
                                        </table>--%>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <!-- END PLACE PAGE CONTENT HERE -->
                </div>
                <!-- END CONTAINER FLUID -->
            </div>
            <!-- END PAGE CONTENT -->
            <!-- START FOOTER -->
           <%-- <div class="container-fluid container-fixed-lg footer">
                <div class="copyright sm-text-center">
                    <p class="small no-margin pull-left sm-pull-reset">
                        <span class="hint-text">Copyright © 2014</span>
                        <span class="font-montserrat">REVOX</span>.
                        <span class="hint-text">All rights reserved.</span>
                  <span class="sm-block"><a href="#" class="m-l-10 m-r-10">Terms of use</a> | <a href="#" class="m-l-10">Privacy Policy</a>
                            </span>
                    </p>
                    <p class="small no-margin pull-right sm-pull-reset">
                        <a href="#">Hand-crafted</a>
                        <span class="hint-text">&amp; Made with Love ®</span>
                    </p>
                    <div class="clearfix"></div>
                </div>
            </div>--%>
            <!-- END FOOTER -->
        </div>
        <!-- END PAGE CONTENT WRAPPER -->
    </div>
    <!-- END PAGE CONTAINER -->
</div>
<script>
    (function($) {
        'use strict';

        if(PAGES_INITIALIZED == false || true){
            // Initialize layouts and plugins
            $.Pages.init();
            PAGES_INITIALIZED = true;
        }

    })(window.jQuery);
</script>