/**
 * Created by pc9 on 20.05.16.
 */
'use strict';
app2.factory('foo2',['$http',function($http){
    alert('foo2')

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

    for(var i = 0; i < adressInfo.length ; i++){
        var  tmpData;
        $http.get('/getOrgs').success(function (data) {
            tmpData =data;
            alert(tmpData)
        });
        var tmp = {
            name: adressInfo[i].name,
            data: tmpData
            }
        alert(tmp.name + tmp.data + tmpData)
        res.push(tmp)
        }



    return nill;
}]);

/*$http.get('getOrgs').success(function (data) {
    alert('sucsess' +
        '');
});*/




/*

*/


