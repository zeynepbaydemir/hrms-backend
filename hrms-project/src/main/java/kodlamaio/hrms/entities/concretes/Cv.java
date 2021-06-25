package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cvs")
public class Cv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="github_link")
	private String githubLink;
	
	@Column(name="linked_link")
	private String linkedLink;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="description")
	private String description;
	
	@Column(name="created_date")
	private LocalDate createdDate;
	
	@Column(name="active")
	private boolean active=true;
	
	@Column(name="updated_date")
	private LocalDate updatedDate;
	
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	@OneToMany(mappedBy = "cv", cascade = CascadeType.ALL ) 
	 private List<Language> languages;
	  
	 @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL ) 
	 private List<Technology> technologies;
	  
	 @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL ) 
	 private List<Education> education;
	 
	 @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL ) 
	 private List<JobExperience> jobExperiences;
	
	
	

}
