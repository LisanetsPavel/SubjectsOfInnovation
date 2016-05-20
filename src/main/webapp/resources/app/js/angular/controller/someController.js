/**
 * Created by pc9 on 20.05.16.
 */
'use strict';
app2.controller('FixController',['$scope','$http',
    function($scope,$http){
    alert('testController');
        $http.get('/getOrgs').success(function (data) {
            $scope.organizations =data;
            alert('organs '+ data)
        });
        $http.get('/getScopes').success(function (data) {
            $scope.spheres =data;
            alert('spheres ' + data)
        });
        $http.get('/getPhases').success(function (data) {
            $scope.phases =data;
            alert(data)
        });
        $http.get('/getSubjects').success(function (data) {
            $scope.subjects =data;
            alert(data)
        });
        $http.get('/getLocations').success(function (data) {
            $scope.locations =data;
            alert(data)
        });
        $http.get('/getMemberships').success(function (data) {
            $scope.memberships =data;
            alert(data)
        });


}]);



