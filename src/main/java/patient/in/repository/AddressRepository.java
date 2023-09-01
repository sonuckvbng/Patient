package patient.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import patient.in.entity.PatientAddress;
import patient.in.entity.PatientEntity;

public interface AddressRepository extends JpaRepository<PatientAddress,Integer> {

}
