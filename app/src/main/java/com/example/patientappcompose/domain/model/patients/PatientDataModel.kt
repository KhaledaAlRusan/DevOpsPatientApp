package com.example.patientappcompose.domain.model.patients

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Data model representing a patient's details.
 */
@JsonClass(generateAdapter = true)
data class PatientDataModel(
    @Json(name = "_id")
    val id: String,

    @Json(name = "name")
    val name: String,

    @Json(name = "email")
    val email: String,

    @Json(name = "mobile")
    val mobile: String,

    @Json(name = "gender")
    val gender: String,

    @Json(name = "birthdate")
    val birthdate: String,

    @Json(name = "address")
    val address: String,

    @Json(name = "photo")
    val photo: String,

    @Json(name = "condition")
    val condition: String,

    @Json(name = "tests")
    val tests: List<Any>,

    @Json(name = "createdAt")
    val createdAt: String,

    @Json(name = "updatedAt")
    val updatedAt: String,

    @Json(name = "__v")
    val v: Int,

    // Local variable to keep track of selection state
    var selected: Boolean = false
) {
    /**
     * Generates a concise patient information string.
     * @return String with patient's address, email, and birthdate.
     */
    fun getPatientInfo(): String {
        return "Lives in $address \nEmail: $email \nBorn on $birthdate"
    }
}
