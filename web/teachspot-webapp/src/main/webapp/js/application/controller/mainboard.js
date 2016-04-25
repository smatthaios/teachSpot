/**
 * MainBoard Controller is responsible to manage all operations in mainboard view.
 */
app.controller('MainBoard', ['$scope', '$rootScope', '$location', '$route',
	function ($scope, $rootScope, $location, $route) {
		$scope.name = 'Test';
		/**
		 * Creates the scope functions of the Controller.
		 */
		function createScopeFunctions() {

			/**
			 * Opens a modal to help User initialize a new Scenario.
			 */
			$scope.initToolUse = function () {
				toolModalWindow.modal('show');
			}

			/**
			 * Initializes the tour component of the application.
			 */
			$scope.initTour = function () {
				tourModalWindow.one('shown.bs.modal', function () {
					revealContainer.height(document.documentElement.clientHeight - 70).focus();
					Reveal.initialize({
						controls: true,
						progress: false,
						history: false,
						center: true,
						mouseWheel: false,
						embedded: true,
						overview: true,
						theme: Reveal.getQueryHash().theme, // available themes are in /css/theme
						transition: Reveal.getQueryHash().transition || 'default', // default/cube/page/concave/zoom/linear/fade/none

						// Parallax scrolling
						// parallaxBackgroundImage: 'https://s3.amazonaws.com/hakim-static/reveal-js/reveal-parallax-1.jpg',
						// parallaxBackgroundSize: '2100px 900px',

						// Optional libraries used to extend on reveal.js
						dependencies: [
							{ src: baseUrl + '/js/reveal/lib/js/classList.js', condition: function () {
								return !document.body.classList;
							} },
							{ src: baseUrl + '/js/reveal/plugin/markdown/marked.js', condition: function () {
								return !!document.querySelector('[data-markdown]');
							} },
							{ src: baseUrl + '/js/reveal/plugin/markdown/markdown.js', condition: function () {
								return !!document.querySelector('[data-markdown]');
							} },
							{ src: baseUrl + '/js/reveal/plugin/highlight/highlight.js', async: true, callback: function () {
								hljs.initHighlightingOnLoad();
							} },
							{ src: baseUrl + '/js/reveal/plugin/zoom-js/zoom.js', async: true, condition: function () {
								return !!document.body.classList;
							} }
						]
					});
				}).modal('show');
			}

			/**
			 * Updates the User Profile so that mainboard logo isn't displayed any more.
			 */
			$scope.changeMainboardFlag = function () {
				function okMethod() {
					UserService.updateProfile($rootScope.activeUser.firstName, $rootScope.activeUser.lastName, $rootScope.activeUser.defaultProjectId, false).then(
						function (data) {
							$rootScope.activeUser = data[0];
						}
					)
					Notify.infoModal(Locale.get('userIntroTip'));
					$scope.$apply();
				}

				if($scope.introEnabled == $rootScope.activeUser.introEnabled)
					Notify.warning(Locale.get('introDisablePrompt'), okMethod);
			}

			/**
			 * Navigates User to optimization view for a new scenario.
			 */
			$scope.createNewOptimization = function () {
				$location.path(TYPES.OPTIMIZATION.path);
			}

			/**
			 * Navigates User to simulation view for a new scenario.
			 */
			$scope.createNewSimulation = function () {
				$location.path(TYPES.SIMULATION.path);
			}

			/**
			 * Navigates User to shelf space simulation view for a new scenario.
			 */
			$scope.createNewSelfSpaceSimulation = function () {
				$location.path(TYPES.SHELF_SPACE_SIMULATION.path);
			}

			/**
			 * Toggles project menu contents.
			 */
			$scope.toggleProjectMenu = function () {
				$('#project-menu-contents').toggle();
			}
		}

		/**
		 * Initializes the scope functions of the Controller.
		 */
		function initializeScopeVariables() {
			$scope.projectId = null;
			$scope.categoryId = null;
			$rootScope.categoryId = null;
			$scope.$route = $route;

			// modal action selection is simulation by default
			$scope.action = TYPES.SIMULATION.id;
		}

		/**
		 * Initializes the wizard of the mainboard view.
		 */
		function initializeToolWizard() {
			toolModalWindow.find('.modal-header').ace_wizard().on('change', function (obj, currentStep) {
				if (currentStep.direction == 'previous') {
					return true;
				}
				if (currentStep.step == 1) {
					$rootScope.activeProject = _.findWhere($scope.projects, {'id': $scope.projectId});
					$rootScope.$apply();
				}

				if (currentStep.step == 2 && $scope.categoryId) {
					$scope.activeCategory = _.findWhere($scope.activeProject.categories, {'id': $scope.categoryId});
					$scope.$digest();
				}

				return Validator.isValid('#modal-step' + currentStep.step);
			}).on('finished', function () {
					// first hide the modal window and then transfer to the next page
					toolModalWindow.one('hidden.bs.modal', function () {
						// $scope.action variable contains either simulation/optimization action or the scenario id to load (this is pre-calculated)
						var type = TYPES.get($scope.action);
						if (type) {
							$rootScope.activeProject = $scope.activeProject;
							$rootScope.categoryId = $scope.activeCategory.id;
							$location.path(type.path);
						} else {
							$location.path(TYPES.SIMULATION.path + $scope.activeScenario.id);
						}
						$scope.$apply();
					}).modal('hide');
				});
		}

		/**
		 * Initializes actions on UI components.
		 */
		function setActions() {
			$scope.$watch('visualizationKpi', function (kpi) {
				if (kpi) {
					$scope.loadSimulationChart();
				}
			});
			$scope.$watch('visualizationAttribute', function (attribute) {
				if (attribute) {
					$scope.loadSimulationChart();
				}
			});
			var rootWatch = $rootScope.$watch('activeProject', function (project) {
				if (project && project.id && $rootScope.activeUser) {

					ScenarioRestService.getLatestUserScenarios($rootScope.activeUser.id, project.id, TYPES.SIMULATION.type).then(function (data) {
						$scope.simulationScenarios = data;
					});
					ScenarioRestService.getLatestUserScenarios($rootScope.activeUser.id, project.id, TYPES.OPTIMIZATION.type).then(function (data) {
						$scope.optimizationScenarios = data;
					});
					ScenarioRestService.getLatestUserScenarios($rootScope.activeUser.id, project.id, TYPES.SHELF_SPACE_SIMULATION.type).then(function (data) {
						$scope.ssSimulationScenarios = data;
					});
					ScenarioRestService.getLatestUserScenarios($rootScope.activeUser.id, project.id, TYPES.SHELF_SPACE_OPTIMIZATION.type).then(function (data) {
						$scope.ssOptimizationScenarios = data;
					});

					setTimeout(function () {
						var scenarioGrid = $('#scenario-grid');
						if (scenarioGrid.find('li.active > a').length == 0) {
							scenarioGrid.find('li:first > a').click();
						}
					}, 200);
				}
			}, true);
			$scope.$on('$destroy', function () {
				rootWatch();
			});
		}

		/**
		 * Initializes UI components.
		 */
		function initLayout() {
			$('[data-rel=tooltip]').tooltip();

			$('#project-menu-contents').click(function(e) {
				e.stopPropagation();
			});

			$(document).click(function(e) {
				if(e.target.id != "project-menu-link" &&  e.target.id != "query"
					&&  e.target.id != "project-menu-link-name"
					&&  e.target.id != "project-menu-link-caret"){
						$('#project-menu-contents').fadeOut(300);
				}
			});

			$(document).keyup(function(e) {
				if (e.keyCode == 27) {
					$('#project-menu-contents').fadeOut(300);
				}
			});
		}

		/**
		 * Initializes the Controller.
		 */
		function initializeController() {

			/*createScopeFunctions();
			initLayout();
			initializeToolWizard();
			initializeScopeVariables();
			setActions();
			Validator.init();*/

			$scope.rowCollection = [
				{firstName: 'Laurent', lastName: 'Renard', birthDate: new Date('1987-05-21'), balance: 102, email: 'whatever@gmail.com'},
				{firstName: 'Blandine', lastName: 'Faivre', birthDate: new Date('1987-04-25'), balance: -2323.22, email: 'oufblandou@gmail.com'},
				{firstName: 'Francoise', lastName: 'Frere', birthDate: new Date('1955-08-27'), balance: 42343, email: 'raymondef@gmail.com'}
			];
		}

		initializeController();
	}]);
