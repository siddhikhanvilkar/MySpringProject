package com.model;
import java.time.LocalDate;
import javax.persistence.*;

import com.model.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
import lombok.Builder.Default;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestId;
    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee empId;
    private String status;
    private String requestType;
    private LocalDate date;  // Create a date object
    @OneToOne(mappedBy="request")
    @JsonIgnore
    private ServiceRating sr;
    public Request(int requestId, Employee empId, String requestType) {
        this.requestId = requestId;
        this.empId = empId;
        this.requestType = requestType;
    }
    
}
