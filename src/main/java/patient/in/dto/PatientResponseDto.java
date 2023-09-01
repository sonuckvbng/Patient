package patient.in.dto;

import lombok.Data;
import patient.in.entity.PatientAddress;

import java.time.LocalDate;
@Data
public class PatientResponseDto {
    private Integer patientId;
    private String fullName;
    private LocalDate dob;
    private PatientAddress address;
}
