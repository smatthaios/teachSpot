/**
 * SideBar Controller is responsible to manipulate the side bar of the application.
 */
app.controller('SideBar', ['$scope', '$rootScope', 'UserService',
	function ($scope, $rootScope, UserService) {


		/**
		 * Creates the scope functions of the Controller.
		 */
		function createScopeFunctions() {
		}

		/**
		 * Initializes the scope functions of the Controller.
		 */
		function initScopeVariables() {

		}

		/**
		 * Initializes actions on UI components.
		 */
		function setActions() {

		}

		/**
		 * Initializes the Controller.
		 */
		function initializeController() {
			createScopeFunctions();
			setActions();
			initScopeVariables();
			Validator.init();
		}

		initializeController();
	}]);
