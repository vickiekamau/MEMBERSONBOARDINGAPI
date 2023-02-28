package ktl.ack.api.AckMemberRegistrationApi.application.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "member")
public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long regNo;

    @Column(name = "first_name")
    private String fname;
    @Column(name = "surname")
    private String surname;
    @Column(name = "other_names")
    private String otherNames;
    @Column(name = "gender")
    private String gender;
    @Column(name = "marital_status")
    private String maritalStatus;
    @Column(name = "children")
    private int children;
    @Column(name= "date_of_birth")
    private String dob;
    @Column(name = "confirmed")
    private String confirmed;
    @Column(name = "cell_group")
    private String cellGroup;
    @Column(name = "service_attended")
    private String service;
    @Column(name = "profession")
    private String profession;
    @Column(name = "occupation")
    private String occupation;
    @Column(name = "phone_no")
    private String phoneNo;

    @CreationTimestamp
    @Column(updatable = false)
    Timestamp dateCreated;


}