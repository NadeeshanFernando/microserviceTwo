package com.anton.microTwo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

/**
 * @author by nadeeshan_fdz
 */

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
@Entity
@ToString
@Table (name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @JsonIgnore
    public  long deptId;

    @Column(name = "deptName")
    public String deptName;

}
