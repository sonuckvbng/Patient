package patient.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import patient.in.dto.PatientIdAndFnmDto;
import patient.in.dto.PatientResponseDto;
import patient.in.dto.PatientReuestDto;
import patient.in.exception.NotFoundException;
import patient.in.service.PatientService;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;
     @PostMapping("/save")
    public String savePatientData(@RequestBody PatientReuestDto reuestDto){

         return patientService.savePatientDetails(reuestDto);
    }

    @GetMapping("/get/{patientId}")
    public PatientResponseDto getPatientById(@PathVariable Integer patientId) throws NotFoundException {

       return  patientService.getPatientById(patientId);
    }

    @GetMapping("/getall")
    public PatientResponseDto getPatientByIdAndName(@RequestBody PatientIdAndFnmDto patientIdAndFnmDto) throws NotFoundException {

         return  patientService.getPatientDetailsByIdAndFullName(patientIdAndFnmDto);


    }
}
