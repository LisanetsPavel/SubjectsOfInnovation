/**
 * Created by pc9 on 22.04.16.
 */
//
'use strict';
(function(){
    var app = angular.module('InnoModule',[]);



    app.controller('OrganizationController',
        ['$scope', '$http', function($scope, $http){
            $scope.organizations = [];
            $http.get('http://localhost:8080/index').success(function(data) {
                $scope.organizations = data;
            });
    }]);

















    app.controller('CheckBoxController', ['$scope', function($scope){
        $scope.checkboxModel = {
            value1: false,
            value2: false,
            value3: false
        }
        }]);

        app.controller('SelectController', function(){
            this.myarray = [5,6,7,8,9,10];

    });




})();




