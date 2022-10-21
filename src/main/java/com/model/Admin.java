package com.model;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="it_staff")
public class Admin {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int adminId;
	 private String adminName;
	 private String contactNo;
	 private String designation;
	 private String password;
	 //@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="adminId")
	 //private List<Request> requestlist; 
	// private String requestlist;
	

}
