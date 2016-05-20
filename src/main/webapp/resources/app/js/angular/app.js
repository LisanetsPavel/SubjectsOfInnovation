/**
 * Created by pc9 on 22.04.16.
 */
//
'use strict';
(function () {
    var app = angular.module('InnoModule', []);


    /*app.controller('OrganizationController',
        ['$scope', '$http', function ($scope, $http) {
            var obj ={
                key: 'http://localhost:8080/getOrgs',
                value: $scope.organizations
            }
            $scope.organizations = []
            var adress = ['http://localhost:8080/getOrgs'];
             var getTer = function(){
               $http.get(adress[0]).success(function (data) {
                  //

                   $scope.organizations.put(data);

                   
                  //$scope.organizations = data;
                   obj.value.push(data);
                    return data;
               });
           }

            this.organs = getTer();
            alert(this.organs)


        }]);*/

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



