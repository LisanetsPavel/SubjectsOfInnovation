/**
 * Created by pc9 on 09.06.16.
 */
adminApp.controller('listDisagreeController',
    ['$scope', '$http','$location','$rootScope','shareAdmin',
        function($scope, $http, $location, $rootScope, shareAdmin){
        var config = {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
            }
        }
        $scope.goToOrgInfo = function(organization) {

            shareAdmin.setOrg(organization)
            $location.url('/admin/orgInfo');
        };


        $scope.selection = [];
        $scope.toggleSelection = function toggleSelection(orgId) {
            var idx = $scope.selection.indexOf(orgId);
            if (idx > -1) {
                $scope.selection.splice(idx, 1);
            }
            else {
                $scope.selection.push(orgId);
            }
        };
        $scope.setAgreedOrgs = function(){
            for(var i = 0; i < $scope.selection.length; i++){
                $http.post('/agree',('id='+$scope.selection[i]), config)
                    .success(function(data, status, headers, config) {
                        $scope.selection = [];
                    })
                    .error(function(data, status, headers, config) {
                    });
            }
            $http.get('/getDisagreedOrgs').success(function (data) {
                $rootScope.organizations = data;
            });
            $scope.selection = [];
        };





    }]);


