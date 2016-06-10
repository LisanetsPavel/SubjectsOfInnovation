/**
 * Created by pc9 on 06.06.16.
 */

mainApp.controller('indexController', ['$scope', '$http', '$location', '$rootScope','$window','shareService',
    function ($scope, $http, $location,
              $rootScope,$window,shareService) {

        $http.get('/getAgreedOrgs').success(function (data) {
            $rootScope.organizations = data;
        });
        $http.get('/getScopes').success(function (data) {
            $rootScope.spheres = data;
        });
        $http.get('/getPhases').success(function (data) {
            $rootScope.phases = data;
        });
        $http.get('/getSubjects').success(function (data) {
            $rootScope.subjects = data;
        });
        $http.get('/getLocations').success(function (data) {
            $rootScope.locations = data;
        });
        $http.get('/getMemberships').success(function (data) {
            $rootScope.memberships = data;
        });


        $scope.goToAddOrg = function () {
            $location.url('/addOrg');
        };
        $scope.goToStupidInfo = function () {
            $location.url('/stupidInfo');
        };
        $scope.goToMainPage = function () {
            $location.url('/');
        };
        $scope.goToAdminPage = function () {
            $window.location.href = 'http://localhost:8080/admin';
        };
    }])

