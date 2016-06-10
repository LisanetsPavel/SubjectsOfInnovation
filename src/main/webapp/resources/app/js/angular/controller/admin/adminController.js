/**
 * Created by pc9 on 26.05.16.
 */
adminApp.controller('adminController',
    ['$scope', '$http','$location','$rootScope',function($scope, $http, $location,$rootScope){

        $http.get('/getDisagreedOrgs').success(function (data) {
            $rootScope.organizations = data;
        });



        $scope.goToAdminOrgInfo = function () {
            $location.url('/admin/orgInfo');
        };
        $scope.goToAddFields = function () {
            $location.url('/admin/addFields');
        };
        $scope.goToMainAdminPage = function () {
            $location.url('/admin');
        };



    }]);
