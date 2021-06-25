package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao=candidateDao;
	}
	@Override
	public Result add(Candidate candidate) {
		if(this.getByEmail(candidate.getUser().getEmail()).getData()!=null || this.getByIdentityNumber(candidate.getIdentityNumber()).getData()!=null) 
		{
			return new ErrorResult("User already exist!");
		}

		this.candidateDao.save(candidate);
		return new SuccessResult("Saved!");
	}
	@Override
	public DataResult<Candidate> getByEmail(String email) {
		if(this.candidateDao.getByUser_Email(email)==null) 
		{
			return new ErrorDataResult<Candidate>("Cannot bring data by email");
		}
		return new SuccessDataResult<Candidate>(this.candidateDao.getByUser_Email(email),"Bring data by email");
	}
	@Override
	public DataResult<Candidate> getByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getByIdentityNumber(identityNumber),"Bring data by identity number");
	}
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Bring all data");
	}

}
