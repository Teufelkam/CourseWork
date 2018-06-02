package com.example.demo.service;

import com.example.demo.enums.ScienceRank;
import com.example.demo.enums.SpecializationOfDoctor;
import com.example.demo.enums.SpecializationOfWorker;
import com.example.demo.model.*;

import java.sql.Date;
import java.util.List;

public interface IRequestService {
    //1.1
    List<Doctor> getDoctorBySpecialization(SpecializationOfDoctor type);
    //1.2
    List<Doctor> getDoctorBySpecializationAndClinic(SpecializationOfDoctor type, int clinic_id);
//    //1.3
    List<Doctor> getDoctorBySpecializationAndHospital(SpecializationOfDoctor type, int hospital_id);

    List<Worker> getWorkerBySpecialization (SpecializationOfWorker type);
    List<Worker> getWorkerBySpecializationAndHospital (SpecializationOfWorker type, int hospital_id);
    List<Worker> getWorkerBySpecializationAndClinic (SpecializationOfWorker type, int clinic_id);
//    //2.1
    List<Doctor> getDoctorByOperationAmount(int operationAmount);
//    //2.2
    List<Doctor> getDoctorByScienceRank(ScienceRank scienceRank);
    List<Doctor> getDoctorByScienceRankAndHospital(ScienceRank scienceRank, int hospital_id);
    List<Doctor> getDoctorByScienceRankAndClinic(ScienceRank scienceRank, int clinic_id);
//    //3.1
    List<Patient> getPatientByHospital(int hospital_id);
//    //3.2
    List<Patient> getPatientByCot(int cotId);
//    //3.3
    List<Patient> getPatientByClinicDoctor(int doctorId);
//    //4
    Hospital getInfoAboutHospital(int hospitalId);

    List<Osad> getGroupBy();
//    //5
//    List<SportsmanSportCoach> getCoachesBySportsman(int sportsmanId);
//    //6.1
//    List<Competition> getCompetitionsByDateInterval(Date firstDate, Date secondDate);
//    //6.2
//    List<Competition> getCompetitionsByDateIntervalAndOrganizer(
//            Date firstDate, Date secondDate, int organizerId);
//    //7.1
//    List<SportsmanCompetition> getWinnersByCompetition(int competitionId);
//    //7.2
//    List<SportsmanCompetition> getAllParticipantsByCompetition(int competitionId);
//    //8.1
//    List<Competition> getCompetitionsByBuilding(int sportBuildingId);
//    //8.2
//    List<Competition> getCompetitionsBySport(int sportId);
//    //9
//    List<SportClubAndAmountOfSportsmen> getSportClubAndSportsmenByDateInterval(Date firstDate, Date secondDate);
//    //10
//    List<Coach> getCoachesBySport(int sportId);
//    //11
//    List<Sportsman> getSportsmenNotCompetitionParticipantsByDateInterval(Date firstDate, Date secondDate);
//    //12
//    List<OrganizerAndAmountOfCompetitions> getOrganizerCompetitionsByDateInterval(Date firstDate, Date secondDate);
//    //13
//    List<Competition> getSportBuildingByDateInterval(Date firstDate, Date secondDate);

}