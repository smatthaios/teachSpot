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
                                <li><a href="#" class="active">Profile</a>
                                </li>
                            </ul>
                            <!-- END BREADCRUMB -->
                        </div>
                    </div>
                </div>
                <!-- END JUMBOTRON -->
                <!-- START CONTAINER FLUID -->
                <div class="container-fluid container-fixed-lg">
                    <div id="rootwizard" class="m-t-50">

                        <ul class="nav nav-tabs nav-tabs-linetriangle nav-tabs-separator nav-stack-sm">
                            <li class="active">
                                <a data-toggle="tab" href="#tab1"><i class="fa fa-user tab-icon"></i> <span>Personal Information</span></a>
                            </li>
                            <li class="">
                                <a data-toggle="tab" href="#tab2"><i class="fa fa-key tab-icon"></i> <span>Change Password</span></a>
                            </li>
                        </ul>

                        <div class="tab-content" style="overflow: visible">
                            <div class="tab-pane padding-20 active slide-left" id="tab1">
                                <div class="row row-same-height" style="overflow: visible">
                                    <div class="panel panel-default" style="overflow: visible">
                                        <div class="panel-heading">
                                            <div class="panel-title">
                                                User Profile
                                            </div>
                                        </div>
                                        <div class="panel-body" style="overflow: visible">
                                            <h5>
                                                Profile Information
                                            </h5>
                                            <form role="form">
                                                <div class="form-group">
                                                    <label>Username</label>
                                                    <input type="text" value="{{activeUser.email}}" disabled class="form-control" required>
                                                </div>
                                                <div class="form-group">
                                                    <label>First Name</label>
                                                    <input type="text" id="firstName" ng-model="newFirstName" class="form-control"<%-- required--%>>
                                                </div>
                                                <div class="form-group">
                                                    <label>Last Name</label>
                                                    <input type="text" id="lastName" ng-model="newLastName" class="form-control" <%--required--%>>
                                                </div>

                                                <div class="form-group pull-right">
                                                    <button class="btn btn-success" ng-click="updateProfile()">Submit</button>
                                                    <button class="btn btn-default">Clear</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane slide-left padding-20" id="tab2" style="overflow: visible">
                                <div class="row row-same-height" style="overflow: visible">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <div class="panel-title">
                                                User Credentials
                                            </div>
                                        </div>
                                        <div class="panel-body">
                                            <h5>
                                                Change Password
                                            </h5>
                                            <form role="form">
                                                <div class="form-group">
                                                    <label>Old Password</label>
                                                    <input type="password" ng-model="oldPassword" class="form-control" required>
                                                </div>
                                                <div class="form-group">
                                                    <label>New Password</label>
                                                    <input type="password" id="newPassword" ng-model="newPassword" class="form-control" required>
                                                </div>
                                                <div class="form-group">
                                                    <label>Confirm New Password</label>
                                                    <input type="password" id="newPasswordConfirm" ng-model="newPasswordConfirm" class="form-control" required>
                                                </div>

                                                <div class="form-group pull-right">
                                                    <button class="btn btn-success" ng-click="changePassword()">Submit</button>
                                                    <button class="btn btn-default">Clear</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- END CONTAINER FLUID -->
            </div>
            <!-- END PAGE CONTENT -->
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