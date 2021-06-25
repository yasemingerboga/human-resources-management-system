package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;
	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}
	
	@Override
	public DataResult<List<Job>> getAll() {
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(),"Bring data");
	}

	@Override
	public DataResult<Job> getByJobTitle(String jobTitle) {
		if(this.jobDao.getByJobTitle(jobTitle)==null) {
			return new ErrorDataResult<Job>("Cannot bring data");
		}
		return new SuccessDataResult<Job>(this.jobDao.getByJobTitle(jobTitle),"Bring data by title");
	}

	@Override
	public Result add(Job job) {
		if(this.getByJobTitle(job.getJobTitle()).getData()!=null) {
			return new ErrorResult("Job is already exist!");
		}
		this.jobDao.save(job);
		return new SuccessResult("Job is added.");
	}

}
