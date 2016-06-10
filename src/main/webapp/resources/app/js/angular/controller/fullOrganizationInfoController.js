/**
 * Created by pc9 on 02.06.16.
 */
mainApp.controller('fullOrganizationInfoController', ['$scope','shareServise',function ($scope,shareServise) {
        var orgorganization = shareServise.getOrg()

    $scope.organization = orgorganization;

}]);