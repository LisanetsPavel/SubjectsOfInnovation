/**
 * Created by pc9 on 28.04.16.
 */
'use strict';
(function() {

    var app = angular.module("AdminModule", []);
    app.controller("HttpGetController", ['$scope', '$http' , function ($scope, $http) {

        $scope.SendData = function () {

            var data = $scope.param.toString();


            $http.get('http://localhost:8080/sendData', data )
                .success(function (data, status, headers, config) {

                    alert( 'test ' + data)

                    $scope.PostDataResponse = data;
                })
                .error(function (data, status, header, config) {
                    $scope.ResponseDetails = "Data: " + data +
                        "<hr />status: " + status +
                        "<hr />headers: " + header +
                        "<hr />config: " + config;
                });
        };

    }]);







    /*var app = angular.module('AdminModule', []);

    app.controller('SettestDataController',
        ['$scope', '$http', function($scope, $http){
            $scope.testData = [];

            var config = {
                headers : {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                }
            }

            $http.post('http://localhost:8080/index', data, config)
                .success(function (data, status, headers, config) {
                    $scope.PostDataResponse = data;
                })


            $http.get('http://localhost:8080/index').success(function(data) {
                $scope.organizations = data;
            });
        }]);*/


})();