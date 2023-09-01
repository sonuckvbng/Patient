package patient.in.dto;

import lombok.Data;

@Data
public class PatientAddressRequestDto {
    private  String addrline1;
    private  String addrline2;
    private Integer pincode;
}
