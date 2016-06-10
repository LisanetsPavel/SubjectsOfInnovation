/**
 * Created by pc9 on 20.05.16.
 */
'use strict';

mainApp.controller('searchController', ['$scope', '$http','$location'
                                      ,'$rootScope','shareServise',
                                      function ($scope, $http,$location
                                                ,$rootScope,shareServise) {
        $scope.goToOrg = function(organization) {
                shareServise.setOrg(organization)
                $location.url('/organizationsInfo');
            };
}]);









