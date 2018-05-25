var app = angular.module('demo',[]);

app.controller('Departments',function ($http,$scope) {

    $scope.departments = [];
    $http.get('/departments/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.departments = response.data;
        //  console.log(response);
    });

    this.insertDepartment = function add() {
        var departmentType = document.getElementById("DepartmentType").value;
        var departmentCorp = document.getElementById("DepartmentCorp").value;
        var req = {
            method: 'POST',
            url: '/departments/insert',
            data: {
                type: departmentType,
                corpsId: departmentCorp
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.startUpdatingDepartment = function startUpdate(id, type, corpsId) {
        document.getElementById("IdUPD").value = id;
        document.getElementById("TypeUPD").value = type;
        document.getElementById("CorpsUPD").value = corpsId;
    };

    this.updateDepartment = function update() {
        var id = document.getElementById("IdUPD").value;
        var type = document.getElementById("TypeUPD").value;
        var corps = document.getElementById("CorpsUPD").value;
        var req = {
            method: 'POST',
            url: '/departments/update?id=' + id,
            data: {
                type: type,
                corpsId: corps
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.deleteDepartment = function del(id) {
        $http.get('/departments/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };
});
