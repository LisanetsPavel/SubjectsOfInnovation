/**
 * Created by pc9 on 22.04.16.
 */
//
'use strict';
(function () {
    var app = angular.module('InnoModule', []);




    app.controller('TestController',['$scope','foo2', function($scope,foo2){
        alert('testController')
        foo2.success(function(data) {
            $scope.allData = data;
        });
    }]);

    app.controller('CheckBoxController', ['$scope', function ($scope) {
        $scope.checkboxModel = {
            value1: false,
            value2: false,
            value3: false
        }
    }]);

    app.controller('SelectController', function () {
       this.myarray = [5, 6, 7, 8, 9, 10];

    });


})();



