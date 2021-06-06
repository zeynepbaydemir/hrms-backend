package kodlamaio.hrms.api.conrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.EducationDto;

@RestController
@RequestMapping("api/education")
public class EducationController {

private EducationService educationService;
	

	@Autowired
	public EducationController(EducationService educationService) {
		super();
		this.educationService = educationService;
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<EducationDto>> getAll(){
		return this.educationService.getAll();
	}
	
	@GetMapping("/getOrderByDate")
	public DataResult<List<EducationDto>> findAllByCvIdOrderByEndedDateDesc(int id){
		return this.educationService.findAllByCvIdOrderByEndedDateDesc(id);
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody EducationDto educationDto) {
		return this.educationService.add(educationDto);
	  }
}
