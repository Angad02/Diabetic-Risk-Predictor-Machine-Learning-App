package com.example.hp1.deephack.rest;


import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class MedicalData {
    @SerializedName("admission_source_id")
    Integer admissionSourceId;

    @SerializedName("num_lab_procedures")
    Integer numLabProcedures;

    @SerializedName("diag_1")
    Integer diag1;

    @SerializedName("num_diagnoses")
    Integer numDiagnoses;

    @SerializedName("num_procedures")
    Integer numProcedures;

    @SerializedName("num_medication")
    Integer numMedication;

    @SerializedName("max_glu_serum")
    Integer maxGluSerum;

    public MedicalData(int admissionSourceId,
                       int numLabProcedures,
                       int diag1,
                       int numDiagnoses,
                       int numProcedures,
                       int numMedication,
                       int maxGluSerum) {
        this.admissionSourceId = admissionSourceId;
        this.numLabProcedures = numLabProcedures;
        this.diag1 = diag1;
        this.numDiagnoses = numDiagnoses;
        this.numProcedures = numProcedures;
        this.numMedication = numMedication;
        this.maxGluSerum = maxGluSerum;
    }
}
