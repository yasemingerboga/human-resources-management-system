package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.UniversityDepartment;

public interface UniversityDepartmentService {
	DataResult<List<UniversityDepartment>> getAll();

	Result add(UniversityDepartment UniversityDeparment);
}
