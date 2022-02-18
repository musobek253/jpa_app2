package uz.pdp.jpa_app2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surName;
    @Column(nullable = false)
    private Date birthDay;
    @Column(nullable = false)
    private Date issuedDate;
    @Column(nullable = false,unique = true)
    private String passportId;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String region;


}
