/**
 * Created by pc9 on 22.04.16.
 */
//
'use strict';

var adminApp = angular.module('AdminModule', ['ngRoute']);


adminApp.config(['$routeProvider','$locationProvider', function($routeProvider,$locationProvider) {
    $routeProvider
        .when('/admin',           {templateUrl: '/app/js/angular/view/adminView/adminOrganizationList.html',controller: 'adminController'})
        .when('/admin/orgInfo',   {templateUrl: '/app/js/angular/view/adminView/FullInfoForAdmin.html'     ,controller: 'adminOrganInfo'})
        .when('/admin/addFields', {templateUrl: '/app/js/angular/view/adminView/AddFields.html'            ,controller: 'addOrganFieldController'})

        .otherwise({redirectTo: '/admin'});

        $locationProvider.html5Mode({
            enabled: true,
            requireBase: false
        });
},
]);




