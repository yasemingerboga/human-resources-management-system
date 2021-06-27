package kodlamaio.hrms.core.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.MernisCheckService;
import kodlamaio.hrms.entities.concretes.Candidate;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class MernisCheckAdapter implements MernisCheckService {@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		return true;
	}


}
