package com.example.patientappcompose.data.datasource

import com.example.patientappcompose.domain.model.add.AddPatientModel
import com.example.patientappcompose.domain.model.delete.DeletePatientRemoteModel
import com.example.patientappcompose.domain.model.details.DetailsPatientRemoteModel
import com.example.patientappcompose.domain.model.patients.PatientDataModel
import com.example.patientappcompose.domain.model.patients.PatientsRemoteResponseModel
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * DataSource interface for patient-related operations using Retrofit.
 */
interface PatientDataSource {

    // CRUD operations ordered: Create, Read, Update, Delete (Though "Update" isn't present here)

    /**
     * Adds a new patient.
     * @param addPatientModel The patient details to be added.
     * @return PatientDataModel of the added patient.
     */
    @POST("patients")
    suspend fun addPatient(@Body addPatientModel: AddPatientModel): PatientDataModel

    /**
     * Fetches the list of all patients.
     * @return PatientsRemoteResponseModel containing the list of patients.
     */
    @GET("patients")
    suspend fun getPatients(): PatientsRemoteResponseModel

    /**
     * Retrieves details of a specific patient.
     * @param id The patient's ID.
     * @return DetailsPatientRemoteModel containing details of the specified patient.
     */
    @GET("patients/{id}")
    suspend fun getPatient(@Path("id") id: String): DetailsPatientRemoteModel

    /**
     * Deletes a specific patient.
     * @param id The patient's ID.
     * @return DeletePatientRemoteModel containing the result of the delete operation.
     */
    @DELETE("patients/{id}")
    suspend fun deletePatient(@Path("id") id: String): DeletePatientRemoteModel
}
