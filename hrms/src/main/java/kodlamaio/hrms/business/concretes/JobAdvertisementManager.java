package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao=jobAdvertisementDao;
	}
	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"Job advertisements are listed.");
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getAllActive() {
			return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrue(),"Open job advertisements are listed.");
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByPublishDate() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrueOrderByPublishDate());	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueAndEmployer_Id(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrueAndEmployer_Id(employerId),"Job advertisements are listed by employerId");
	}

	@Override
	public DataResult<JobAdvertisement> ClosureJobAdveritsement (int jobadvertisementId, int employerId) {
		JobAdvertisement jobAdvertisementToUpdate=this.jobAdvertisementDao.findByIdAndEmployer_Id(jobadvertisementId, employerId);
		if(jobAdvertisementToUpdate == null) {
			return new ErrorDataResult<JobAdvertisement>("Job advertisements were not found to match the criteria. No such job posting for this job posting does not belong to this company.");
		}
		jobAdvertisementToUpdate.setActive(!jobAdvertisementToUpdate.isActive());
		jobAdvertisementDao.save(jobAdvertisementToUpdate);
		return new SuccessDataResult<JobAdvertisement>("The specified job advertisement has been"+(jobAdvertisementToUpdate.isActive()? "active" : "pasive"));
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("The job advertisement has been added.");
	}

}
