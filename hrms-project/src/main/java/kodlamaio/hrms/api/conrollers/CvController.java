package kodlamaio.hrms.api.conrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CvAddDto;
import kodlamaio.hrms.entities.dtos.CvGetDto;

@RestController
@RequestMapping(value= "api/cvs")
public class CvController {
	

	private CvService cvService;

	@Autowired
	public CvController(CvService cvService) {
		super();
		this.cvService = cvService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CvGetDto>> getAll(){
		return this.cvService.getAll();
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<List<CvGetDto>> findAllByCandidateId(int id){
		return this.cvService.findAllByCandidateId(id);
	}
	
		
	@PostMapping(value="/add")
	public Result add(@Valid @RequestBody CvAddDto cvDto) {
		return this.cvService.add(cvDto);
				
	  }
	
	
	@PutMapping("/uploadImage")
	public Result saveImage(@RequestBody MultipartFile file,@RequestParam int cvId) {
		return this.cvService.saveImage(file, cvId);
		
	}

}
