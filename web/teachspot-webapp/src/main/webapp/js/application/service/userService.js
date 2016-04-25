/* User Service handles all functions related to a User.  */
(function() {
	'use strict';

	angular
		.module('app')
		.factory('UserService', ['UserRestService', '$q', UserService]);

	function UserService(UserRestService, $q) {

		/**
		 * Updates a Users profile.
		 *
		 * @param userId The user Id.
		 * @param newFirstName The new first name.
		 * @param newLastName The new last name.
		 *
		 * @returns The updated User.
		 */
		var updateProfile = function updateProfile(userId, newFirstName, newLastName) {
			return UserRestService.updateProfile(userId, newFirstName, newLastName);
		}

		return {
			updateProfile: updateProfile
		}
	}
})();

