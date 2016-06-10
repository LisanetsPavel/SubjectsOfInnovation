/**
 * Created by pc9 on 26.05.16.
 */
adminApp.controller('adminController',
    ['$scope', '$http','$location', function($scope, $http, $location){
        var config = {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
            }
        }

        $scope.goToAdminOrgInfo = function () {
            $location.url('/admin/orgInfo');
        };
        $scope.goToAddField = function () {
            $location.url('/admin/addFields');
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
            $scope.selection = [];
        };


        $http.get('/getDisagreedOrgs').success(function (data) {
            $scope.organizations = data;
            alert("succsussss" + data)
        });
        var router = function(array, flag){
            for(var i = 0; i<array.length; i++ ){

                if (array[i].name == flag){
                    return array[i];
                }
            }
        }
        $scope.SendData = function (flag) {
            var adresses = [
                    {name: 'location', url: '/setLocation', data: 'name=' + $scope.location},
                    {name: 'membership', url: '/setMembership', data: 'name=' + $scope.membership},
                    {name: 'sphere', url: '/setScope', data: 'name=' + $scope.sphere},
                    {name: 'phase', url: '/setPhase', data: 'name=' + $scope.phase},
                    {name: 'subject',url: '/setSubject',data: 'name=' + $scope.subjectName + '&url=' + $scope.subjectUrl}
                ];

            var adress = router(adresses, flag);
            var data   = adress.data;
            var url    = adress.url;

            $http.post(url, data, config)
                .success(function (data, status, headers, config) {
                    $scope.message = data;
                    data = null;
                })
                .error(function (data, status, headers, config) {
                    alert("failure message: " + JSON.stringify({data: data}));
                });
        }
    }]);













/*
adminApp.controller('adminController',
    ['$scope', '$http', function($scope, $http){

        $scope.SendData = function(flag){
            var adresses = [
                {name: 'location',    url: '/setLocation',  data: 'name=' + $scope.location},
                {name: 'membership',  url: '/setMembership',data: 'name=' + $scope.membership},
                {name: 'sphere',      url: '/setScope',     data: 'name=' + $scope.sphere},
                {name: 'phase',       url: '/setPhase',     data: 'name=' + $scope.phase},
                {name: 'subject',     url: '/setSubject',   data: 'name=' + $scope.subjectName + '&url=' + $scope.subjectUrl},
            ];
            var config = {
                headers : {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                }
            }
            var adress = router(adresses, flag);
            var data = adress.data;
            var url  = adress.url;
            $http.post(url, data, config)
                .success(function(data, status, headers, config) {
                    data = null;
                })
                .error(function(data, status, headers, config) {
                    alert( "failure message: " + JSON.stringify({data: data}));
                });
        }




    }]);
*/
