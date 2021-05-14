package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService {

	private JobDao jodDao;
	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jodDao = jobDao;
	}

	@Override
	public List<Job> getAll() {
		return this.jodDao.findAll();
	}

}
