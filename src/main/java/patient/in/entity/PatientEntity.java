package patient.in.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name="Patient")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="patId")
    private Integer patientId;
    @Column(name="fnm")
    private String fullName;
    private  String status;
    private LocalDate dob;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patId")
    private PatientAddress address;
}
