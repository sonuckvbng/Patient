package patient.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patient.in.entity.PatientEntity;
@Repository
public interface PatientRepository  extends JpaRepository<PatientEntity,Integer> {
    public PatientEntity getPatientByPatientIdAndFullName(Integer patientId,String fullName);
}
