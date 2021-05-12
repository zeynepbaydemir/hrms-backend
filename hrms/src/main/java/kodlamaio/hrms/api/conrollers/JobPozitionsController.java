package kodlamaio.hrms.api.conrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpozitions")
public class JobPozitionsController {
	private JobPositionService jobPozitionService;

	@Autowired
	public JobPozitionsController(JobPositionService jobPozitionService) {
		super();
		this.jobPozitionService = jobPozitionService;
	}
	@GetMapping("/getall")
	public List<JobPosition> getAll(){
		return jobPozitionService.getAll();
	}
}
