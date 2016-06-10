/**
 * Created by pc9 on 09.06.16.
 */
adminApp.controller('adminOrganInfo',
    ['$scope', '$http','$location','$rootScope','shareAdmin',
        function($scope, $http, $location,$rootScope,shareAdmin){
        var config = {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
            }
        }
        $scope.organization = shareAdmin.getOrg()
        $scope.setAgreedOrg = function(organization){
            $http.post('/agree',('id='+organization.id), config)
                    .success(function(data, status, headers, config) {
                        $location.url('/admin');
                    })
                    .error(function(data, status, headers, config) {
                    });

            $http.get('/getDisagreedOrgs').success(function (data) {
                $rootScope.organizations = data;
            });

        };

    }]);
