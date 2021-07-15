package kodlamaio.hrms.adapters.cloudinaryAdapter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
public class CloudinaryAdapter {
	static Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
			"cloud_name", "dcs6exrcs",
			"api_key", "451188669356926",
			"api_secret", "6Jpe0gSoXlw9dcBrc6ThYOxyp38",
			"secure", true));
	
	public static DataResult<Object> uploadImage(MultipartFile multipartFile) throws IOException{
		File file = convert(multipartFile);
		Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		//System.out.println(uploadResult.get("url"));
		return new SuccessDataResult<Object>(uploadResult.get("url"));
	}
	
	public static Result delete(String id) throws IOException {
		Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
		return new SuccessResult(result.toString());
	}
	
	public static File convert(MultipartFile multipartFile) throws IOException {
		File file = new File(multipartFile.getOriginalFilename());
		FileOutputStream fo = new FileOutputStream(file);
		fo.write(multipartFile.getBytes());
		fo.close();
		return file;
	}
}
