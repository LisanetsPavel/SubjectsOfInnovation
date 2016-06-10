/**
 * Created by pc9 on 09.06.16.
 */
adminApp.controller('addOrganFieldController',
    ['$scope', '$http','$location', function($scope, $http, $location){
        var config = {
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                }
        }

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




