var app = angular.module("demo", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.chairs = [];
    $http.get('/chairs').then(function (response) {
        $scope.chairs = response.data;
        //   console.log(response);
    });
    $scope.students = [];
    $http.get('/students/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.students = response.data;
        //  console.log(response);
    });

    //
    // $scope.clinics = [];
    // $http.get('/clinics/get').then(function (response) {
    //     //  $http.get('http://localhost:8080/api/students').then(function (response){
    //     $scope.clinics = response.data;
    //     //  console.log(response);
    // });
    $scope.clinicDoctors = [];
    $http.get('/clinicDoctors/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.clinicDoctors = response.data;
        //  console.log(response);
    });
    $scope.clinicHistories = [];
    $http.get('/clinicHistories/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.clinicHistories = response.data;
        //  console.log(response);
    });
    $scope.clinicSurveys = [];
    $http.get('/clinicSurveys/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.clinicSurveys  = response.data;
        //  console.log(response);
    });
    // $scope.corps = [];
    // $http.get('/corps/get').then(function (response) {
    //     //  $http.get('http://localhost:8080/api/students').then(function (response){
    //     $scope.corps = response.data;
    //     //  console.log(response);
    // });
    $scope.cots = [];
    $http.get('/cots/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.cots = response.data;
        //  console.log(response);
    });
    $scope.departments = [];
    $http.get('/departments/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.departments = response.data;
        //  console.log(response);
    });
    $scope.doctors = [];
    $http.get('/doctors/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.doctors = response.data;
        //  console.log(response);
    });
    $scope.hospitals = [];
    $http.get('/hospitals/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.hospitals = response.data;
        console.log(response);
    });
    $scope.hospitalDoctors = [];
    $http.get('/hospitalDoctors/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.hospitalDoctors = response.data;
        //  console.log(response);
    });
    $scope.hospitalHistories = [];
    $http.get('/hospitalHistories/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.hospitalHistories = response.data;
        //  console.log(response);
    });
    $scope.hospitalSurveys = [];
    $http.get('/hospitalSurveys/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.hospitalSurveys = response.data;
        //  console.log(response);
    });
    $scope.laboratories = [];
    $http.get('/laboratories/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.laboratories = response.data;
        //  console.log(response);
    });
    $scope.laboratorySurveys = [];
    $http.get('/laboratorySurveys/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.laboratorySurveys = response.data;
        //  console.log(response);
    });
    $scope.patients = [];
    $http.get('/patients/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.patients = response.data;
        //  console.log(response);
    });
    $scope.statistics = [];
    $http.get('/statistics/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.statistics = response.data;
        //  console.log(response);
    });
    $scope.wards = [];
    $http.get('/wards/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.wards = response.data;
        //  console.log(response);
    });
    $scope.workers = [];
    $http.get('/workers/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.workers = response.data;
        //  console.log(response);
    });
    // this.delstud = function del(id) {
    //     $http.get('/api/student/del?id='+id).then(function (response){
    //         //  $http.get('http://localhost:8080/api/students').then(function (response){
    //         // $scope.students=response.data;
    //         window.alert('Student ' + response.data.lastName + ' ' + response.data.firstName + ' has been succesfully deleted!');
    //         window.location.reload();9
    //     });
    // }
    //
    // $scope.groups = [];
    // $http.get('/api/groups').then(function (response){
    //     //  $http.get('http://localhost:8080/api/students').then(function (response){
    //     $scope.groups=response.data;
    //     console.log(response);
    // });
    //
    //*
    this.delchair = function del(id) {
        $http.get('/api/chair/del?id=' + id).then(function (response) {
            window.alert('Chair ' + ' ' + response.data.name + ' ' + response.data.id + ' ' + response.data.abr + ' ' + ' has been succesfully deleted!');
            window.location.reload();
        });
    };


    this.insertchair = function () {
        var id = document.getElementById("id").value;
        var name = document.getElementById("name").value;
        var abr = document.getElementById("abr").value;
        var req = {
            method: 'POST',
            url: '/api/chair/insert',
            data: {
                id: id,
                name: name,
                abr: abr
            }
        };
        console.log(req);
        $http(req).then(function (resp) {

            window.location.reload();
        })
    };
    $scope.showInsert = true;
    $scope.showUpdate = false;
    $scope.disabledId = false;
    var chair;
    this.hideInsertButton = function (item) {
        document.getElementById("id").value = item.id;
        document.getElementById("name").value = item.name;
        document.getElementById("abr").value = item.abr;
        $scope.disabledId = true;
        chair = item;
        $scope.showInsert = false;
        $scope.showUpdate = true;
    };


    this.cancelUpdate = function () {
        $scope.showInsert = true;
        $scope.showUpdate = false;
        window.location.reload();
    };

    this.updatechair = function () {
        var id = document.getElementById("id").value;
        var name = document.getElementById("name").value;
        var abr = document.getElementById("abr").value;
        var req = {
            method: 'POST',
            url: '/api/chair/update',
            data: {
                id: id,
                name: name,
                abr: abr
            }
        };
        // console.log(req);
        $http(req).then(function (resp) {

            window.location.reload();
        });

    };
    $scope.showInsert = true;
    $scope.showUpdate = false;
    $scope.disabledId = false;

    this.delcabinet = function del(id) {
        $http.get('/api/cabinets/del?id=' + id).then(function (response) {
            window.alert('Chair ' + ' ' + response.data.name + ' ' + response.data.id + ' ' + response.data.abr + ' ' + ' has been succesfully deleted!');
            window.location.reload();
        });
    };


    this.insertcabinet = function () {
        var number = document.getElementById("number").value;
        var clinic_id = document.getElementById("clinicName").value;
        console.log(number);
        console.log(clinic_id);
        var req = {
            method: 'POST',
            url: '/cabinets/insert',
            data: {
                number: number,
                clinic_id: clinic_id
            }
        };
        console.log(req);
        $http(req).then(function (resp) {

            window.location.reload();
        })
    };
    $scope.showInsertCabinet = true;
    $scope.showUpdateCabinet = false;
    $scope.disabledIdCabinet = false;
    var chair;
    this.hideInsertButton = function (item) {
        document.getElementById("id").value = item.id;
        document.getElementById("number").value = item.name;
        document.getElementById("clinicName").value = item.abr;
        $scope.disabledId = true;
        chair = item;
        $scope.showInsertCabinet = false;
        $scope.showUpdateCabinet = true;
    };


    this.cancelUpdate = function () {
        $scope.showInsertCabinet = true;
        $scope.showUpdateCabinet = false;
        window.location.reload();
    };

    this.updatecabinet = function () {
        var id = document.getElementById("id").value;
        var number = document.getElementById("number").value;
        var abr = document.getElementById("clinicName").value;
        var req = {
            method: 'POST',
            url: '/api/cabinets/update',
            data: {
                id: id,
                number: number,
                clinicName: clinicName
            }
        };
        // console.log(req);
        $http(req).then(function (resp) {

            window.location.reload();
        });

    };
    $scope.showInsertCabinet = true;
    $scope.showUpdateCabinet = false;
    $scope.disabledIdCabinet = false;

});


