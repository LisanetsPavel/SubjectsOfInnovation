/**
 * Created by pc9 on 20.05.16.
 */
'use strict';
mainApp.controller('initController', ['$scope', '$http',
    function ($scope, $http) {
        $http.get('/getOrgs').success(function (data) {
            $scope.organizations = data;
        });
        $http.get('/getScopes').success(function (data) {
            $scope.spheres = data;
        });
        $http.get('/getPhases').success(function (data) {
            $scope.phases = data;
        });
        $http.get('/getSubjects').success(function (data) {
            $scope.subjects = data;
        });
        $http.get('/getLocations').success(function (data) {
            $scope.locations = data;
        });
        $http.get('/getMemberships').success(function (data) {
            $scope.memberships = data;
        });
    }]);


mainApp.controller('OrganizationController',
    ['$scope', '$http', function ($scope, $http) {
        $scope.abs = function(a){
            alert(a)
            $scope.flag = a;
        }
        var fitter = function   (array){
            var result= []
            for (var i = 0; i < array.length; i++){
                result[i] = {
                    id:array[i].id,
                    name:array[i].name
                }
            }
            alert(result);
            return result;
        }
        $scope.setOrg = function () {

            var url =  '/setOrg';
            var data = {
                fullName: $scope.full_name,
                shortName: $scope.short_name,
                fullNameEng: $scope.full_name_eng,
                form: $scope.form,
                subordination: $scope.subordination,
                projects: $scope.projects,
                code: $scope.code,
                legalAdress: $scope.legal_adress,
                factualAdress: $scope.factual_adress,
                phoneNumber: $scope.phone_number,
                site: $scope.site,
                email: $scope.email,
                nameOfDirector: $scope.name_of_director,
                founder: $scope.name_of_foundeer,
                subject: {
                    id: $scope.subject_for_orgs.id,
                    name: $scope.subject_for_orgs.name,
                    url: $scope.subject_for_orgs.url,
                    memberships: $scope.subject_for_orgs.memberships
                },
                location: {
                    id: $scope.location_for_orgs.id,
                    name: $scope.location_for_orgs.name
                },
                membership:{
                    id: $scope.membership_for_orgs.id,
                    name: $scope.membership_for_orgs.name
                }
            };
            data.scopes = fitter($scope.sphere_for_orgs);
            data.phases = fitter($scope.phase_for_orgs);
            var config = {
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                }
            }

            var json = 'organization=' + JSON.stringify(data);
            alert('json   ' + json);
            $http.post(url, json, config)
                .success(function (json, status, headers, config) {
                    alert('organ data' + json)
                    data = null;
                })
                .error(function (data, status, headers, config) {
                    alert("failure message: " + JSON.stringify({data: data}));
                });
        }


    }]);



