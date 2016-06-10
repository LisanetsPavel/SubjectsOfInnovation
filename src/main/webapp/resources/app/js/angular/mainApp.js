/**
 * Created by pc9 on 20.05.16.
 */
'use strict';
var mainApp = angular.module('NewModule', ['ngRoute'])

mainApp.config(['$routeProvider','$locationProvider', function($routeProvider,$locationProvider) {
        $routeProvider

            .when('/',                    {templateUrl: 'app/js/angular/view/OrganizationSearch.html',  controller: 'indexController'})
            .when('/addOrg',              {templateUrl: 'app/js/angular/view/AddOrganization.html',     controller: 'addOrganizationController'})
            .when('/organizationsInfo',   {templateUrl: 'app/js/angular/view/OrganizationInfo.html',    controller: 'fullOrganizationInfoController'})
            .when('/stupidInfo',          {templateUrl: 'app/js/angular/view/StupidInfo.html',          controller: 'StufidInfoController'})
            .otherwise({redirectTo: '/'});

        $locationProvider.html5Mode({
            enabled: true,
            requireBase: false
        });
}]);