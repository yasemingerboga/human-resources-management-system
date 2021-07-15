package kodlamaio.hrms.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.Result;

public interface ImageService {
	Result add(MultipartFile file) throws IOException;
}
