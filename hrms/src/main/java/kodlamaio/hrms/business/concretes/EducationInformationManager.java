package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationInformationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationInformationDao;
import kodlamaio.hrms.entities.concretes.EducationInformation;

@Service
public class EducationInformationManager implements EducationInformationService {
	private EducationInformationDao educationInformationDao;

	@Autowired
	public EducationInformationManager(EducationInformationDao educationInformationDao) {
		super();
		this.educationInformationDao = educationInformationDao;
	}

	@Override
	public Result add(EducationInformation educationInformation) {
		this.educationInformationDao.save(educationInformation);
		return new SuccessResult("Eğitim bilgileri Eklendi");
	}

	@Override
	public DataResult<List<EducationInformation>> getAll() {
		return new SuccessDataResult<List<EducationInformation>>(educationInformationDao.findAll(),"All eduction informations are listed.");
	}

	

}
