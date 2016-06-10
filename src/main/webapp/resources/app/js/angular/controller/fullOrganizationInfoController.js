/**
 * Created by pc9 on 02.06.16.
 */
mainApp.controller('fullOrganizationInfoController', ['$scope','shareService',function ($scope,shareService) {

    var organization = shareService.getOrg();

    $scope.organization = organization;
    $scope.spheres = organization.scopes;
    $scope.phases = organization.phases;
}]);