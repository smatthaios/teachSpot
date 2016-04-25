/**
 * Profile Controller is responsible to manipulate Users profile.
 */
app.controller('Profile', ['$scope', '$rootScope', 'UserService',
	function ($scope, $rootScope, UserService) {
		var infoPanel = $('#information'),
			newPassword = $('#newPassword'),
			firstName = $('#firstName'),
			lastName = $('#lastName'),
			newPasswordConfirm = $('#newPasswordConfirm'),
			changePasswordPanel = $('#change-password');

		/**
		 * Creates the scope functions of the Controller.
		 */
		function createScopeFunctions() {
			/**
			 * Resets the active User profile info in the view (not the back end).
			 */
			$scope.resetProfileInfo = function () {
				Validator.reset(infoPanel);
			}

			/**
			 * Saves the active User Profile.
			 */
			$scope.updateProfile = function () {
				if (!$scope.newFirstName) {
					Validator.showErrorMessage(firstName, 'First Name cannot be empty.');
					return;
				}
				if (!$scope.newLastName) {
					Validator.showErrorMessage(lastName, 'Last Name cannot be empty.');
					return;
				}

				infoPanel.mask(true);
				UserService.updateProfile($rootScope.activeUser.id, $scope.newFirstName, $scope.newLastName).then(function (data) {
					$rootScope.activeUser = data[0];
					infoPanel.mask(false);

					$.notify(Locale.get('userUpdated'), "success");
				});
			}

			/**
			 * Changes the active User password.
			 */
			$scope.changePassword = function () {
				if (!Validator.isValid(changePasswordPanel)) {
					return;
				}
				if ($scope.newPassword != $scope.newPasswordConfirm) {
					//$.notify('Password ' + newPassword + ' and ' + newPasswordConfirm + ' are not the same.', "error");


					Validator.showErrorMessage(newPassword, 'Passwords are not the same.');
					Validator.showErrorMessage(newPasswordConfirm, 'Passwords are not the same.');
					return;
				}
				if (!passwordRegExp.test($scope.newPassword)) {
					Validator.showErrorMessage(newPassword, 'Password requires one lower case letter, one upper case letter, one digit, 6-13 length, and no spaces');
					return;
				}

				changePasswordPanel.mask(true);
				/*UserService.changePassword($scope.oldPassword, $scope.newPassword).then(function () {
					changePasswordPanel.mask(false);
					Notify.info('User successfully updated.');
				});*/
			}
		}

		/**
		 * Initializes the scope functions of the Controller.
		 */
		function initScopeVariables() {
			if ($rootScope.activeUser) {
				$scope.newFirstName = $rootScope.activeUser.firstName;
				$scope.newLastName = $rootScope.activeUser.lastName;
				$scope.defaultProjectId = $rootScope.activeUser.defaultProjectId;
				$scope.introEnabled = $rootScope.activeUser.introEnabled;
			}
		}

		/**
		 * Initializes actions on UI components.
		 */
		function setActions() {
			var rootWatch = $rootScope.$watch('activeUser', function (activeUser) {
				if (activeUser) {
					initScopeVariables();
				}
			});
			$scope.$on('$destroy', function () {
				rootWatch();
			});
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
