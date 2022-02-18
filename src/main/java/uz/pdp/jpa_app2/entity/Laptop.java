package uz.pdp.jpa_app2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String brandName;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String ram;
    @Column(nullable = false)
    private int strong;
    @Column(nullable = false,unique = true)
    private String macaddress;
}
