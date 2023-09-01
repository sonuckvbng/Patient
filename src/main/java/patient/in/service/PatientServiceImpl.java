package patient.in.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import patient.in.dto.PatientIdAndFnmDto;
import patient.in.dto.PatientResponseDto;
import patient.in.dto.PatientReuestDto;
import patient.in.entity.PatientAddress;
import patient.in.entity.PatientEntity;
import patient.in.exception.NotFoundException;
import patient.in.repository.PatientRepository;

import java.util.Optional;

@Service
public class PatientServiceImpl  implements PatientService{

   @Autowired
   private PatientRepository patientRepository;

    @Override
    public String savePatientDetails(PatientReuestDto reuestDto) {
        PatientEntity entity=new PatientEntity();
        PatientAddress address=new PatientAddress();

        entity.setFullName(reuestDto.getFullName());
        entity.setDob(reuestDto.getDob());
        entity.setStatus(reuestDto.getStatus());

        address.setAddrline1(reuestDto.getPatientAddressRequestDto().getAddrline1());
        address.setAddrline2(reuestDto.getPatientAddressRequestDto().getAddrline2());
        address.setPincode(reuestDto.getPatientAddressRequestDto().getPincode());
        entity.setAddress(address);

//        BeanUtils.copyProperties(reuestDto,entity);
       PatientEntity save = patientRepository.save(entity);
        if(save.getPatientId()!=null){
            return "data saved";
        }
        return "Data not saved";
    }

    @Override
    public PatientResponseDto getPatientById(Integer patientId) throws NotFoundException {
        PatientResponseDto responseDto=new PatientResponseDto();
        PatientAddress address=new PatientAddress();
        Optional<PatientEntity> Id = patientRepository.findById(patientId);
        if (Id.isPresent()) {
            responseDto.setFullName(Id.get().getFullName());
            responseDto.setDob(Id.get().getDob());

            address.setAddrline1(Id.get().getAddress().getAddrline1());
            address.setAddrline2(Id.get().getAddress().getAddrline2());
            address.setPincode(Id.get().getAddress().getPincode());
            responseDto.setAddress(address);
            return responseDto;
        }else
            throw new NotFoundException("Data not found for the given id");
    }



    @Override
    public PatientResponseDto getPatientDetailsByIdAndFullName(PatientIdAndFnmDto patientIdAndFnmDto) throws NotFoundException {
        PatientResponseDto responseDto=new PatientResponseDto();
        PatientAddress address=new PatientAddress();

        PatientEntity patientByIdAndFullName = patientRepository.getPatientByPatientIdAndFullName(patientIdAndFnmDto.getPatientId(), patientIdAndFnmDto.getFullName());
        if(patientByIdAndFullName!=null){
            BeanUtils.copyProperties(patientByIdAndFullName,responseDto);
            address.setPatientId(patientByIdAndFullName.getAddress().getPatientId());
            address.setAddrline1(patientByIdAndFullName.getAddress().getAddrline1());
            address.setAddrline2(patientByIdAndFullName.getAddress().getAddrline2());
            address.setPincode(patientByIdAndFullName.getAddress().getPincode());
            responseDto.setAddress(address);
            return responseDto;
        }else
            throw new NotFoundException("Data not found for the given id");
    }

    }

