package com.example.demo.service;

import com.example.demo.enums.ScienceRank;
import com.example.demo.enums.SpecializationOfDoctor;
import com.example.demo.enums.SpecializationOfWorker;
import com.example.demo.model.*;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.HospitalRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RequestService implements IRequestService{
    @Autowired
    DoctorRepository doctorsRepository;

    @Autowired
    WorkerRepository workerRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    HospitalRepository hospitalRepository;

    @Override
    public List<Doctor> getDoctorBySpecialization(SpecializationOfDoctor type){
        System.out.println(doctorsRepository.getDoctorBySpecialization(type).get(0));
        return doctorsRepository.getDoctorBySpecialization(type);
    }

    @Override
    public List<Doctor> getDoctorBySpecializationAndClinic(SpecializationOfDoctor type, int clinic_id) {
        return doctorsRepository.getDoctorBySpecializationAndClinic(type,clinic_id);
    }

    @Override
    public List<Doctor> getDoctorBySpecializationAndHospital(SpecializationOfDoctor type, int hospital_id) {
        return doctorsRepository.getDoctorBySpecializationAndHospital(type,hospital_id);
    }

    @Override
    public List<Worker> getWorkerBySpecialization(SpecializationOfWorker type) {
        return workerRepository.getWorkerBySpecialization(type);
    }

    @Override
    public List<Worker> getWorkerBySpecializationAndHospital(SpecializationOfWorker type, int hospital_id) {
        return workerRepository.getWorkerBySpecializationAndHospital(type, hospital_id);
    }

    @Override
    public List<Worker> getWorkerBySpecializationAndClinic(SpecializationOfWorker type, int clinic_id) {
        return workerRepository.getWorkerBySpecializationAndClinic(type, clinic_id);
    }

    @Override
    public List<Doctor> getDoctorByOperationAmount(int operationAmount) {
        return doctorsRepository.getDoctorByOperationAmount(operationAmount);
    }

    @Override
    public List<Doctor> getDoctorByScienceRank(ScienceRank scienceRank) {
        return doctorsRepository.getDoctorByScienceRank(scienceRank);
    }

    @Override
    public List<Doctor> getDoctorByScienceRankAndHospital(ScienceRank scienceRank, int hospital_id) {
        return doctorsRepository.getDoctorByScienceRankAndHospital(scienceRank, hospital_id);
    }

    @Override
    public List<Doctor> getDoctorByScienceRankAndClinic(ScienceRank scienceRank, int clinic_id) {
        return doctorsRepository.getDoctorByScienceRankAndClinic(scienceRank, clinic_id);
    }

    @Override
    public List<Patient> getPatientByHospital(int hospital_id) {
        return patientRepository.getPatientByHospital(hospital_id);
    }

    @Override
    public List<Patient> getPatientByCot(int cotId) {
        return patientRepository.getPatientByCot(cotId);
    }

    @Override
    public List<Patient> getPatientByClinicDoctor(int doctorId) {
        return patientRepository.getPatientByClinicDoctor(doctorId);
    }

    @Override
    public Hospital getInfoAboutHospital(int hospitalId) {
        return hospitalRepository.getInfoAboutHospital(hospitalId);
    }

    @Override
    public List<Osad> getGroupBy() {
        List<Osad> osads = new ArrayList<>();
        List<Long> longs = doctorsRepository.getDoctorByGroup1();
        List<SpecializationOfDoctor> specializationOfDoctors = doctorsRepository.getDoctorByGroup2();
        for (int i = 0; i < longs.size(); i++) {
            osads.add(new Osad(longs.get(i), specializationOfDoctors.get(i)));
        }

        return osads;
    }


}
