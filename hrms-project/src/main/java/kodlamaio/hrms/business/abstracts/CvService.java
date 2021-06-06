package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CvAddDto;
import kodlamaio.hrms.entities.dtos.CvGetDto;

public interface CvService {

	Result add(CvAddDto resumeDto);
	
	DataResult<List<CvGetDto>> getAll();
	
	DataResult<List<CvGetDto>> findAllByCandidateId(int id);
	
	Result saveImage(MultipartFile file, int resumeId);
}
