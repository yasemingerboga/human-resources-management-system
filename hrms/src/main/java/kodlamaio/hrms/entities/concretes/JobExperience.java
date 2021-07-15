package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="job_experiences")
@AllArgsConstructor
@NoArgsConstructor
public class JobExperience {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="workplace_name")
	private String workPlaceName;
	
	@Column(name="job_position")
	private String jobPosition;
	
	@Column(name="start_date")
	private LocalDate startDate;
	
	@Column(name="quit_date")
	private LocalDate quitDate;
	
	@ManyToOne
	@JoinColumn(name="cv_id")
	@JsonIgnore
	private CV cv;
}
