package patient.in.service;

import patient.in.dto.PatientIdAndFnmDto;
import patient.in.dto.PatientResponseDto;
import patient.in.dto.PatientReuestDto;
import patient.in.exception.NotFoundException;

public interface PatientService {

    public String savePatientDetails(PatientReuestDto reuestDto);
    public PatientResponseDto getPatientById(Integer patientId) throws NotFoundException;
    public PatientResponseDto getPatientDetailsByIdAndFullName( PatientIdAndFnmDto dto) throws NotFoundException;
}
