app.factory('UserRestService', ['$http', '$q', function ($http, $q) {
	var url = baseUrl + 'users';
	return {
		changePassword: function (oldPassword, newPassword) {
			var deferred = $q.defer();
			$http.post(url, {
				oldPassword: oldPassword,
				newPassword: newPassword
			}, prepareFormConfig({'action': 'changePassword'})).success(function (response) {
				successCallback(response, deferred)
			}).error(errorCallback);
			return deferred.promise;
		},
		updateProfile: function (userId, firstName, lastName) {
			var deferred = $q.defer();
			$http.post(url, {
				userId: userId, firstName: firstName, lastName: lastName
			}, prepareFormConfig({'action': 'updateProfile'})).success(function (response) {
				successCallback(response, deferred)
			}).error(errorCallback);
			return deferred.promise;
		},
		update: function (user) {
			var deferred = $q.defer();
			$http.post(url + '/' + user.id, {
				firstName: user.firstName, lastName: user.lastName, accountId: user.accountId, status: user.status, role: user.role
			}, prepareFormConfig({'action': 'update'})).success(function (response) {
				successCallback(response, deferred)
			}).error(errorCallback);
			return deferred.promise;
		},
		create: function (user) {
			var deferred = $q.defer();
			$http.post(url, {
				firstName: user.firstName, lastName: user.lastName, accountId: user.accountId, email: user.email, role: user.role, status: user.status
			}, prepareFormConfig()).success(function (response) {
				successCallback(response, deferred, false, false, true)
			}).error(errorCallback);
			return deferred.promise;
		},
		deleteUser: function (userId) {
			var deferred = $q.defer();
			$http.post(url, {userId: userId}, prepareFormConfig({'action': 'delete'})).success(function (response) {
				successCallback(response, deferred)
			}).error(errorCallback);
			return deferred.promise;
		},
		getAll: function () {
			var deferred = $q.defer();
			$http.get(url).success(function (response) {
				successCallback(response, deferred)
			}).error(errorCallback);
			return deferred.promise;
		},
		getAllActive: function () {
			var deferred = $q.defer();
			$http.get(url + "/allActive").success(function (response) {
				successCallback(response, deferred)
			}).error(errorCallback);
			return deferred.promise;
		},
		authenticate: function (username, password) {
			var deferred = $q.defer();
			$http.post(url, {
				username: username,
				password: password
			}, prepareFormConfig({'action': 'authenticate'})).success(function (response) {
				if (isResponseValid(response)) {
					window.location.href = baseUrl + 'main.html';
				} else {
					$(window).unblock();
				}
			}).error(errorCallback);
			return deferred.promise;
		},
		getActive: function () {
			var deferred = $q.defer();
			$http.get(url + '/active').success(function (response) {
				successCallback(response, deferred)
			}).error(errorCallback);
			return deferred.promise;
		},
		updateStatus: function (user) {
			var deferred = $q.defer();
			$http.put(url + "/" + user.id + '/status/' + user.status).success(function (response) {
				successCallback(response, deferred)
			}).error(errorCallback);
			return deferred.promise;
		},
		get: function (userId) {
			var deferred = $q.defer();
			$http.get(baseUrl + 'users/' + userId).success(function (response) {
				successCallback(response, deferred)
			}).error(errorCallback);
			return deferred.promise;
		},
		resetPassword: function (email) {
			var deferred = $q.defer();
			$http.post(url, {email: email.trim()}, prepareFormConfig({'action': 'resetPassword'})).success(function (response) {
				successCallback(response, deferred)
			}).error(errorCallback);
			return deferred.promise;
		},
		changePasswordAfterReset: function (token, password) {
			var deferred = $q.defer();
			$http.post(url, {
				passwordToken: token,
				newPassword: password
			}, prepareFormConfig({'action': 'recover'})).success(function (response) {
				successCallback(response, deferred)
			}).error(errorCallback);
			return deferred.promise;
		},
		findByAccount: function (accountId) {
			var deferred = $q.defer();
			$http.get(baseUrl + 'users/account/' + accountId).success(function (response) {
				successCallback(response, deferred)
			}).error(errorCallback);
			return deferred.promise;
		}
	};
}]);