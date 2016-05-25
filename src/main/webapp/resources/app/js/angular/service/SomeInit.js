/**
 * Created by pc9 on 20.05.16.
 */

app.factory('foo2',['$http',function($http){
    alert('foo2');
    var getData = function(url){
        $http.get(url).success(function (data) {
            return data;
        });
    };
    var adressInfo = [
        {name: 'organization',
            url: '/getOrgs'
        },
        {name: 'locations',
            url: '/getLocations'
        },
        {name: 'membership',
            url: '/getMemberships'
        }
    ]
    var res = [];
    for(var i = 0; i < adressInfo.length ; i++){

        var tmp = {
            name: adressInfo[i].name,
            data: getData(adressInfo[i].url)
        }
        res.push(tmp)
    }
    return res;
}]);


