/*app = angular.module('app', []);*/

app.controller('Login', ['$scope', 'UserRestService', function ($scope, UserRestService) {
	var forgotBox = $('#forgot-password');

	function createScopeFunctions() {
		$scope.reset = function () {
			Validator.reset();
			$scope.username = $scope.password = $scope.emailPassword = '';
		}

		$scope.submit = function () {
			console.log('sub=mit')

			if (!Validator.isValid()) {
				return;
			}
			if (!($scope.username && $scope.password)) {
				return;
			}
			$(window).mask(true);
			UserRestService.authenticate($scope.username, $scope.password)
				.then(function () {
					window.location.href = 'main.html';
				});
		}

		$scope.submitPasswordRemind = function () {
			if (!Validator.isValid(forgotBox)) {
				return;
			}
			forgotBox.mask(true);
			UserRestService.resetPassword($scope.emailPassword)
				.then(function () {
					forgotBox.mask(false).modal('hide');
					$scope.reset();
					Notify.info(Locale.get('passwordReminder'));
				}, function () {
					forgotBox.mask(false);
				});
		}

		$scope.setPassword = function (uuid) {
			if (!$scope.newPassword) {
				$('#newPassword').attr('data-original-title', 'Password is empty').addClass('error').tooltip('show');
				return;
			}

			if (!$scope.confirmNewPassword) {
				$('#confirmNewPassword').attr('data-original-title', 'Password is empty').addClass('error').tooltip('show');
				return;
			}

			if ($scope.confirmNewPassword != $scope.newPassword) {
				$('#confirmNewPassword').attr('data-original-title', 'The two password are not identical. Please confirm password.').addClass('error').tooltip('show');
				return;
			}

			UserRestService.setPassword(uuid, $scope.newPassword)
				.then(function () {
					Fx.hideModal('new-password');
					$scope.reset();
					Notify.info(Locale.get('passwordChanged'));
				});
		}
	}

	function setActions() {
		$(document).keydown(function (event) {
			if (27 == event.keyCode) { // ESC key
				$scope.reset();
				$scope.$apply();
				$('.bootbox button').click();
			}
		})
	}

	createScopeFunctions();
	setActions();

	Validator.init();
}]);