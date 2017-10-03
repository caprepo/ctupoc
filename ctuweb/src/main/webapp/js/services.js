'use strict';

/* Services */
var ctuServices = angular.module('ctuServices',
		[ 'ngResource' ]);

ctuServices.factory('InvoiceService', [
		'$http',
		'$location',
		'$rootScope',
		function($http, $location, $rootScope) {
			var service = {};
			service.getInvoiceList = function() {
	            var mainurl = "http://104.197.4.247:8090";
	            if ($rootScope.location.$$host == "localhost") {
	            	mainurl = "http://localhost:8090";
	            }
				return $http
						.get(mainurl + "/ctuervices/invoices");
			};

			return service;
		} ]);
	ctuServices.factory('ImageService', [
	'$http',
	'$location',
	'$rootScope',
	function($http, $location, $rootScope) {
		var service = {};
		service.getImageList = function() {
            var mainurl = "http://104.197.4.247:8090";
            if ($rootScope.location.$$host == "localhost") {
            	mainurl = "http://localhost:8090";
            }
			return $http
					.get(mainurl + "/ctuervices/imageList");
		};

		return service;
	} ]);

