package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;

public interface JobPostingService {

	DataResult<List<JobPosting>> getAll();
	DataResult<List<JobPosting>> getAllSortedByDate();
	DataResult<List<JobPosting>> getAllSortedByActive();
	
	Result add(JobPosting jobPosting);
}
