var app = angular.module('demo',[]);

app.controller('ClinicDoctors',function ($http,$scope) {

    $scope.clinicDoctors = [];
    $http.get('/clinicDoctors/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.clinicDoctors = response.data;
        //  console.log(response);
    });

    this.insertClinicDoctor = function add() {
        var clinicDoctorClinic = document.getElementById("ClinicDoctorClinic").value;
        var clinicDoctorDoctor = document.getElementById("ClinicDoctorDoctor").value;
        var clinicDoctorSalary = document.getElementById("ClinicDoctorSalary").value;
        var clinicDoctorVacation = document.getElementById("ClinicDoctorVacation").value;
        var req = {
            method: 'POST',
            url: '/clinicDoctors/insert',
            data: {
                cabinetId: clinicDoctorClinic,
                doctorId: clinicDoctorDoctor,
                salary: clinicDoctorSalary,
                vacation: clinicDoctorVacation
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.startUpdatingClinicDoctor = function startUpdate(id, cabinetId, doctorId, salary, vacation) {
        document.getElementById("IdUPD").value = id;
        document.getElementById("CabinetUPD").value = cabinetId;
        document.getElementById("DoctorUPD").value = doctorId;
        document.getElementById("SalaryUPD").value = salary;
        document.getElementById("VacationUPD").value = vacation;
    };

    this.updateClinicDoctor = function update() {
        var id = document.getElementById("IdUPD").value;
        var salary = document.getElementById("SalaryUPD").value;
        var vacation = document.getElementById("VacationUPD").value;
        var clinicId = document.getElementById("CabinetUPD").value;
        var doctorId = document.getElementById("DoctorUPD").value;
        var req = {
            method: 'POST',
            url: '/clinicDoctors/update?id=' + id,
            data: {
                cabinetId: clinicId,
                doctorId: doctorId,
                salary: salary,
                vacation: vacation
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.deleteClinicDoctor = function del(id) {
        $http.get('/clinicDoctors/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };

});
