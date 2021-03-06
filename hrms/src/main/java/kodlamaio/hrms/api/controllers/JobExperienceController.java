package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;

@RestController
@RequestMapping("/api/jobexperiences")
public class JobExperienceController {

	JobExperienceService jobExprienceService;

	@Autowired
	public JobExperienceController(JobExperienceService jobExprienceService) {
		super();
		this.jobExprienceService = jobExprienceService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobExperience JobExperience) {
		return this.jobExprienceService.add(JobExperience);

	}


	@GetMapping("/getAll")
	public DataResult<List<JobExperience>> getAll (){
		return this.jobExprienceService.getAll();
	}
}
