/**
 * Created by pc9 on 20.05.16.
 */
'use strict';

mainApp.controller('searchController', ['$scope', '$http','$location'
                                      ,'$rootScope','shareService',
                                      function ($scope, $http,$location
                                                ,$rootScope,shareService) {

        $scope.goToOrgInfo = function(organization) {

                shareService.setOrg(organization)
                $location.url('/organizationsInfo');
            };
}]);









