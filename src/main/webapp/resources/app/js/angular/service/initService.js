/*
/!**
 * Created by pc9 on 19.05.16.
 *!/
app.factory('initService', ['$http', function($http) {

    var reqFields = [
        {name: 'organization', url: '/getOrgs', fields: +getData('/getOrgs')},
        {name: 'location', url: '/getLocations', fields: (getData('/getLocations'))},
        {name: 'membership', url: '/getMemberships', fields: getData('/getMemberships')},
        {name: 'sphere', url: '/getScopes', fields: getData('/getScopes')},
        {name: 'phase', url: '/getPhases', fields: getData('/getPhases')},
        {name: 'subject', url: '/getSubjects', fields: getData('/getSubjects') } ]


    var resFields = [
        {name: 'organization', url: '/getOrgs', fields: null},
        {name: 'location', url: '/getLocations', fields: null},
        {name: 'membership', url: '/getMemberships', fields:null},
        {name: 'sphere', url: '/getScopes', fields: null},
        {name: 'phase', url: '/getPhases', fields: null},
        {name: 'subject', url: '/getSubjects', fields:null } ]

    for(var  i = 0; i < reqFields.length; i++){
        $http.get(reqFields[i].url).success(function(data) {
            alert('data' + data)
            resFields.destination = data;
        });
    return






    $http.get('https://s3.amazonaws.com/codecademy-content/courses/ltp4/forecast-api/forecast.json')
        .success(function(data) {
            return data;
        })
        .error(function(err) {
            return err;
        });
}]);



    /!**
     * Created by pc9 on 22.04.16.
     *!/
//
    'use strict';
    (function () {
        var app = angular.module('InnoModule', []);






        app.controller('InitController',
            ['$scope', '$http', function($scope, $http){
                var getData = function (url){
                    var result = null;
                    $http.get(url).success(function(data) {

                        result = data;
                        alert('data' + result)
                        return result;
                    });

                };



                $scope.searchFields = [
                    {name: 'organization', url: '/getOrgs', fields: getData('/getOrgs')},
                    {name: 'location', url: '/getLocations', fields: getData('/getLocations')},
                    {name: 'membership', url: '/getMemberships', fields: getData('/getMemberships')},
                    {name: 'sphere', url: '/getScopes', fields: getData('/getScopes')},
                    {name: 'phase', url: '/getPhases', fields: getData('/getPhases')},
                    {name: 'subject', url: '/getSubjects', fields: getData('/getSubjects') } ]

                for(var  i = 0; i < $scope.searchFields.length; i++){
                    $http.get($scope.searchFields[i].url).success(function(data) {
                        alert('data' + data)
                        $scope.searchFields[i].fields = data;
                    });
                }



            }]);

        app.controller('GETController',
            ['$scope', '$http', function($scope, $http){
                //var data =  $scope.organizations;
                $scope.organizations = [];
                $http.get('http://localhost:8080/index').success(function(data) {
                    $scope.organizations = data;
                });
            }]);
        app.controller('SelectController', function () {
            this.myarray = [5, 6, 7, 8, 9, 10];

        });


    })();




*/
