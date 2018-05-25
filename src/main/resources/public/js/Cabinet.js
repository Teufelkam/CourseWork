var app = angular.module('demo',[]);

app.controller('Cabinets',function ($http,$scope) {
    $scope.cabinets = [];
    $http.get('/cabinets/get').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.cabinets = response.data;
        //  console.log(response);
    });

    this.insertCabinet = function add() {
        var cabinetNumber = document.getElementById("CabinetNumber").value;
        var cabinetClinic = document.getElementById("CabinetClinic").value;

        var req = {
            method: 'POST',
            url: '/cabinets/insert',
            data: {
                number: cabinetNumber,
                clinic_id: cabinetClinic
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };
    var clinic_id;
    this.beforeUpdate = function startUpdate(id, cabinetNumber, cabinetClinic, clinicId, selectedDoctors) {
        $http.get('/doctors/get').then(function (response) {
            var doctors = response.data;
            var selector = document.getElementById("doctorUPD");
            $(selector).empty();
            for (var i = 0; i < doctors.length; i++) {
                var option = document.createElement("option");
                for (var j = 0; j < selectedDoctors.length; j++){
                    if (doctors[i].id == selectedDoctors[j].id){
                        option.selected = 'selected';
                    }
                }
                option.text = doctors[i].name + ' ' + doctors[i].surname;
                option.value = doctors[i].id;
                selector.add(option);
            }
        });
       document.getElementById("CabinetIdUPD").value = id;
       document.getElementById("CabinetNumberUPD").value = cabinetNumber;
       document.getElementById("CabinetClinicUPD").value = cabinetClinic;
       clinic_id = clinicId;
    };

    this.updateCabinet = function update() {
        var id = document.getElementById("CabinetIdUPD").value;
        var cabinetNumber = document.getElementById("CabinetNumberUPD").value;
        
        var req = {
            method: 'POST',
            url: '/cabinets/update?id=' + id,
            data: {
                number: cabinetNumber,
                clinic_id: clinic_id,

            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.deleteCabinet = function del(id) {
        $http.get('/cabinets/delete?id=' + id).then(function () {
            window.location.reload();
        });
    };
});

