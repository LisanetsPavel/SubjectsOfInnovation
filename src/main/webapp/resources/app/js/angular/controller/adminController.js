/**
 * Created by pc9 on 26.05.16.
 */
adminApp.controller('POSTController',
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
