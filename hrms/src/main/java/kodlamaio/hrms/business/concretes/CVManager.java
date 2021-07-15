package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CVDao;
import kodlamaio.hrms.entities.concretes.CV;

@Service
public class CVManager implements CVService{

	private CVDao cvdao;
	
	@Autowired
	public CVManager(CVDao cvdao) {
		this.cvdao = cvdao;
	}

	@Override
	public Result add(CV cv) {
		this.cvdao.save(cv);
		return new SuccessResult("CV has been added.");
	}

	@Override
	public DataResult<List<CV>> getAll() {
		return new SuccessDataResult<List<CV>>(this.cvdao.findAll(), "All CVs are here.");
	}

	@Override
	public DataResult<CV> getByCandidate_Id(int id) {
		return new SuccessDataResult<CV>(this.cvdao.getByCandidate_Id(id), "CV is here get by candidate id.");
	}

}
