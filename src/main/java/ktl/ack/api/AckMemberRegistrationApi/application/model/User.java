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
    @Table(name = "users")
    public class User {




        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
        @SequenceGenerator(name="id_generator", sequenceName = "usr", allocationSize=50)
        //@Column(updatable = false, nullable = false)
        private Long user_id;

        @Column(name = "email")
        private String email;
        @Column(name = "password")
        private String password;


        @CreationTimestamp
        @Column(updatable = false)
        Timestamp dateCreated;


    }
