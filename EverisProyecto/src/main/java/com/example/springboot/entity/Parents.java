package com.example.springboot.entity;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


@Data
@Entity
@Table(name="parents")
public class Parents {
	
	
	@Id
	@Column(name="parents_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int parentsId;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "middle_name")
	private String MiddleName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "other_parent_details")
	private String otherParentDetails;
	

	
		
	//relationships
	
	@ManyToMany(cascade = CascadeType.ALL, fetch =  FetchType.EAGER)
	@JsonIgnoreProperties("parentsRefrences")		
	@JoinTable(name = "student_parents",
			joinColumns = @JoinColumn(name = "parents_id"  ),
			inverseJoinColumns = @JoinColumn(name = "students_id") )
			
	private List<Students>studentsReferences;
	
	
	//eager consulta toda la base de datos, desventaja hace mas lento
	@OneToOne(mappedBy = "familyMenberReferencesToParents",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnoreProperties("familyMenberReferencesToParents")
	private  FamilyMenbers parentsRefrencesToFamilyMenbers;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "family_id")
	@JsonIgnoreProperties("familyRefrencesToParents")
	private Families parentsRefrencesToFamily;
	

	



	

	

	
	
	
	
	
	

	
}
