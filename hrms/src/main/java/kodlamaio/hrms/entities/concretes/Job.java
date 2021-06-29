package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_positions")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdvertisements" })
public class Job {
	@Id
	@GeneratedValue
	@Column(name="id")
	//@ApiModelProperty(hidden = true)
	private int id;
	
	@Column(name="job_title")
	private String jobTitle;
	
	@JsonIgnore
	@OneToMany(mappedBy="jobPosition")
	private List<JobAdvertisement> jobAdvertisements;
}
