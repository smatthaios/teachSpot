/**
 * Defines/Initiates Angular Application
 */

var passwordRegExp = new RegExp("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).{6,13}$");

app = angular.module('app', ['ngRoute', 'ui.select2', 'smart-table'])
    .run(['$rootScope', 'UserRestService', function ($rootScope, UserRestService) {

		// Active User retrieved from Spring MVC.
		//$rootScope.activeUser = JSON.parse(activeUser);

		$rootScope.logout = function () {
			sessionStorage.clear();
			window.location.href = baseUrl + 'login.html';
		}

		function setActiveUser(data) {
			if (data) {
				$rootScope.activeUser = data[0];
			}
		}

		UserRestService.getActive().then(setActiveUser);

    }])
    .config(['$routeProvider', '$locationProvider', '$httpProvider', function ($routeProvider, $locationProvider/*, $httpProvider*/) {
        /*$httpProvider.interceptors.push('noCacheInterceptor');*/
        $locationProvider.hashPrefix('!').html5Mode(false);
        $routeProvider
            .when('/mainboard', { controller: 'MainBoard', templateUrl: baseUrl + 'sections/mainboard.html' })
            .when('/profile', { controller: 'Profile', templateUrl: baseUrl + 'sections/profile.html' })
            .when('/users', { controller: 'UserManagement', templateUrl: baseUrl + 'sections/userManagement.html' })
            .when('/users/:id', { controller: 'UserManagement', templateUrl: baseUrl + 'sections/userManagement.html' })
            .otherwise({ redirectTo: '/mainboard' });
    }])
    .factory('noCacheInterceptor', function () {
        return {
            request: function (config) {
                if (config.method == 'GET') {
                    config.headers['Cache-Control'] = 'no-cache, no-store';
                    config.headers['Pragma'] = 'no-cache';
                    config.headers['Expires'] = 'Thu, 01 Jan 1970 00:00:00 GMT';
                }
                return config;
            }
        };
    });

$('.nav-tabs a').click(function (e) {
	e.preventDefault();
	$(this).tab('show');
});

ResponseStatusLocal = {
	OK: "OK",
	ERROR: "ERROR",
	NOT_FOUND: "NOT_FOUND",
	INVALID_DATA: "INVALID_DATA",
	SESSION_EXPIRED: "SESSION_EXPIRED"
};

Response = {
    OK: "OK",
    ERROR: "ERROR",
    WARNING: "WARNING",
    NOT_FOUND: "NOT_FOUND",
    INVALID_DATA: "INVALID_DATA"
};

