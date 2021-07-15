package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SkillForCVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SkillForCVDao;
import kodlamaio.hrms.entities.concretes.SkillForCV;

@Service
public class SkillForCVManager implements SkillForCVService {

	private SkillForCVDao skillForCVDao;
	
	@Autowired
	public SkillForCVManager(SkillForCVDao skillForCVDao) {
		super();
		this.skillForCVDao = skillForCVDao;
	}

	@Override
	public DataResult<List<SkillForCV>> getAll() {
		return new SuccessDataResult<List<SkillForCV>>(this.skillForCVDao.findAll(),"All skills for CV are listed.");
	}

	@Override
	public Result add(SkillForCV skillForCV) {
		this.skillForCVDao.save(skillForCV);
		return new SuccessResult("Skill For CV is added.");
	}

}
