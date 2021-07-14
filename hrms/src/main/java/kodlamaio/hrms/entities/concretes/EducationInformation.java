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

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="education_informations")
@AllArgsConstructor
@NoArgsConstructor
public class EducationInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="start_date")
	private LocalDate startDate;
	
	@Nullable
	@Column(name="graduate_date")
	private LocalDate graduateDate;
	
	@ManyToOne
	@JoinColumn(name="university_id")
	private University university;
	
	@ManyToOne
	@JoinColumn(name="cv_id")
	private CV cv;
}
