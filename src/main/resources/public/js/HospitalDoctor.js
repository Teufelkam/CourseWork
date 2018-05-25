var app = angular.module('demo',[]);

app.controller('HospitalDoctors',function ($http,$scope) {

    $scope.hospitalDoctors = [];
    $http.get('/hospitalDoctors/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.hospitalDoctors = response.data;
        //  console.log(response);
    });

    this.insertHospitalDoctor = function add() {
        var department = document.getElementById("Department").value;
        var doctor = document.getElementById("Doctor").value;
        var salary = document.getElementById("Salary").value;
        var vacation = document.getElementById("Vacation").value;
        var req = {
            method: 'POST',
            url: '/hospitalDoctors/insert',
            data: {
                doctorId: doctor,
                departmentId: department,
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

    this.startUpdatingHospitalDoctor = function startUpdate(id, departmentId, doctorId, salary, vacation) {
        document.getElementById("IdUPD").value = id;
        document.getElementById("DepartmentUPD").value = departmentId;
        document.getElementById("DoctorUPD").value = doctorId;
        document.getElementById("SalaryUPD").value = salary;
        document.getElementById("VacationUPD").value = vacation;
    };

    this.updateHospitalDoctor = function update() {
        var id = document.getElementById("IdUPD").value;
        var salary = document.getElementById("SalaryUPD").value;
        var vacation = document.getElementById("VacationUPD").value;
        var departmentId = document.getElementById("DepartmentUPD").value;
        var doctorId = document.getElementById("DoctorUPD").value;
        var req = {
            method: 'POST',
            url: '/hospitalDoctors/update?id=' + id,
            data: {
                departmentId: departmentId,
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

    this.deleteHospitalDoctor = function del(id) {
        $http.get('/hospitalDoctors/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };
});
