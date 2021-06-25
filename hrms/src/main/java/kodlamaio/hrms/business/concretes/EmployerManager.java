package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao=employerDao;
	}
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Listed employers");
	}
	@Override
	public Result add(Employer employer) {
		if(this.getByEmail(employer.getUser().getEmail()).getData()!=null) 
		{
			return new ErrorResult("User already exist!");
		}
		this.employerDao.save(employer);
		return new SuccessResult("Add employer");
	}
	@Override
	public DataResult<Employer> getByEmail(String email) {
		if(this.employerDao.getByUser_Email(email)==null) 
		{
			return new ErrorDataResult<Employer>("Cannot bring data by email");
		}
		return new SuccessDataResult<Employer>(this.employerDao.getByUser_Email(email),"Bring data by email");
	}
	


}
