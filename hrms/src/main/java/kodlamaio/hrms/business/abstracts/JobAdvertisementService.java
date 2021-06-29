package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<List<JobAdvertisement>> getAllActive();
	
	DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByPublishDate();

	DataResult<List<JobAdvertisement>> findByIsActiveTrueAndEmployer_Id(int employerId);

	DataResult<JobAdvertisement> ClosureJobAdveritsement(int jobadvertisementId, int employerId);
	
	Result add(JobAdvertisement jobAdvertisement);

}
