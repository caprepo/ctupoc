'use strict';

/* App Module */
var ctuApp = angular.module(
		'ctuApp',
		[ 'routes', 'ngGrid', 'ctuServices', 'ctuControllers',
				'ctuDirectives', 'ngInputModified', 'ngProgress',
				'ngStorage' ]).run(function($rootScope, $location) {
					$rootScope.location = $location;
});