package patient.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import patient.in.entity.PatientEntity;

import java.util.List;

@Repository
public interface PatientRepository  extends JpaRepository<PatientEntity,Integer> {
    public PatientEntity getPatientByPatientIdAndFullName(Integer patientId,String fullName);

    @Query("Select p from PatientEntity p Order by p.fullName")
    public List<PatientEntity> findAllPatientOrderByName();
}
