package kodlamaio.hrms.api.conrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.JobExperienceDto;

@RestController
@RequestMapping("api/jobExperience")
public class JobExperienceController {

private JobExperienceService jobExperienceService;
	
	@Autowired
	public JobExperienceController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}


	@GetMapping("/getall")
	public DataResult<List<JobExperienceDto>> getAll(){
		return this.jobExperienceService.getAll();
	}
	
	@GetMapping("/getOrderByDate")
	public DataResult<List<JobExperienceDto>> findAllByCvIdOrderByEndedDateDesc(int id){
		return this.jobExperienceService.findAllByCvIdOrderByEndedDateDesc(id);
	}
		
	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobExperienceDto jobExperienceDto) {
		return this.jobExperienceService.add(jobExperienceDto);
	  }
}
