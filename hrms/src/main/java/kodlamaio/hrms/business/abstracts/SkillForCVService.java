package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SkillForCV;

public interface SkillForCVService {
	DataResult<List<SkillForCV>> getAll();

	Result add(SkillForCV skillForCV);
}
