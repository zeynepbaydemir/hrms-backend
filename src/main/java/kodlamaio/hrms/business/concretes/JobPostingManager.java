package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService{
	
	private JobPostingDao jobPostingDao;

	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(),"İş ilanları başarıyla listelendi.");
	}
	@Override
	public DataResult<List<JobPosting>> getAllSortedByDate() {
		Sort sort = Sort.by(Sort.Direction.ASC,"publishDate");//yayınlanma tarihine göre sıralar
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(sort));
	}

	@Override
	public DataResult<List<JobPosting>> getAllSortedByActive() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByActive());
	}

	@Override
	public Result add(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("İş ilanı eklendi.");
	}

	

}
