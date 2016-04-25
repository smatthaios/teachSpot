/**
 * User Management Controller is responsible to manipulate the users of the application.
 */
app.controller('UserManagement', ['$scope', '$rootScope',
	function ($scope, $rootScope) {


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

			$scope.rowCollection = [
				{firstName: 'User 1', lastName: 'Renard', birthDate: new Date('1987-05-21'), balance: 102, email: 'whatever@gmail.com'},
				{firstName: 'User 2', lastName: 'Faivre', birthDate: new Date('1987-04-25'), balance: -2323.22, email: 'oufblandou@gmail.com'},
				{firstName: 'User 3', lastName: 'Frere', birthDate: new Date('1955-08-27'), balance: 42343, email: 'raymondef@gmail.com'}
			];
		}

		initializeController();
	}]);
