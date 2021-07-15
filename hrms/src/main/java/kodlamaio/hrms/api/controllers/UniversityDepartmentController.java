package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.UniversityDepartmentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.UniversityDepartment;

@RestController
@RequestMapping("/api/universitydepartments")
public class UniversityDepartmentController {

	UniversityDepartmentService universityDepartmentService;

	@Autowired
	public UniversityDepartmentController(UniversityDepartmentService universityDepartmentService) {
		super();
		this.universityDepartmentService = universityDepartmentService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody UniversityDepartment universityDepartment) {
		return this.universityDepartmentService.add(universityDepartment);

	}
	
	@GetMapping("/getAll")
	public DataResult<List<UniversityDepartment>> getAll (){
		return this.universityDepartmentService.getAll();
	}
}
