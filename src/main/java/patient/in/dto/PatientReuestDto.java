package patient.in.dto;

import lombok.Data;
import patient.in.entity.PatientAddress;

import java.time.LocalDate;
@Data
public class PatientReuestDto {
    private String fullName;
    private  String status;
    private LocalDate dob;
    private PatientAddressRequestDto patientAddressRequestDto;

}
