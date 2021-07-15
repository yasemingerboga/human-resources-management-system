package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="cvs")
@AllArgsConstructor
@NoArgsConstructor
public class CV {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	//education information +
	//job experience +
	//foreign language +
	//photo
	//websites +
	//technologies +
	//önyazı +
	@OneToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	@OneToMany(mappedBy="cv")
	private List<EducationInformation> educationInformation;
	
	@OneToMany(mappedBy="cv")
	private List<JobExperience> jobExperiences;
	
	@OneToMany(mappedBy = "cv")
	private List<ForeignLanguage> foreignLanguages;
	
	@OneToMany(mappedBy = "cv")
	private List<Link> links;
	
	@OneToMany(mappedBy="cv")
	private List<SkillForCV> skills;
	
	@OneToMany(mappedBy = "cv")
	private List<CoverLetter> coverLetters;
	
	@OneToMany(mappedBy="cv")
	private List<Image> images;
	
}
