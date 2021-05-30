package kodlamaio.hrms.api.conrollers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobPosting;

@RestController
@RequestMapping("/api/jobpostings")
public class JobPostingsConroller {
	private JobPostingService jobPostingService;

	public JobPostingsConroller(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosting>> getAll(){
		return this.jobPostingService.getAll();
	}
	
	@GetMapping("/getallbydate")
	public DataResult<List<JobPosting>> getAllByDate(){
		return this.jobPostingService.getAllSortedByDate();
	}
	
	@GetMapping("/getallbyactive")
	public DataResult<List<JobPosting>> getAllByActive(){
		return this.jobPostingService.getAllSortedByActive();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody JobPosting jobAdvertisement){
		this.jobPostingService.add(jobAdvertisement);
	}
}
