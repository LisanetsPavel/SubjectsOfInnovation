/**
 * Created by pc9 on 22.04.16.
 */
//
'use strict';
(function(){
    var app = angular.module('InnoModule',[]);



    app.controller('InitController',
        ['$scope', '$http', function($scope, $http){
            var requiredData = [
                {name: 'organization', url: '/index',        destination: $scope.organizations },
                {name: 'location',     url: '/getLocation',  destination: $scope.location},
                {name: 'membership',   url: '/getMembership',destination: $scope.membership},
                {name: 'sphere',       url: '/getScope',     destination: $scope.sphere},
                {name: 'phase',        url: '/getPhase',     destination: $scope.phase},
                {name: 'subject',      url: '/getSubject',   destination: $scope.subjectName + '&url=' + $scope.subjectUrl}
            ]
            for(var  i = 0; i < requiredData.length; i++){
                $http.get(requiredData[i].url).success(function(data) {
                    requiredData[i].destination = data;
                });
            }

    }]);

    app.controller('GETController',
        ['$scope', '$http', function($scope, $http){
           var data = [];
            $scope.getData(flag)
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




