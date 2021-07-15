package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CV;

@RestController
@RequestMapping("/api/cvs")
public class CVController {
	private CVService cvService;
	
	@Autowired
	public CVController(CVService cvService) {
		this.cvService = cvService;
	}
	
	@PostMapping("/add")
	Result add (@RequestBody CV cv) {
		return cvService.add(cv);
	}
	
	@GetMapping("/getAll")
	DataResult<List<CV>> getAll(){
		return cvService.getAll();
	}
	
	@GetMapping("/getByCandidateId")
	DataResult<CV> getByCandidate_Id(@RequestParam int id){
		return cvService.getByCandidate_Id(id);
	}
	
}
