package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.cloudinary.CloudinaryService;
import kodlamaio.hrms.core.utilities.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.dtos.CvAddDto;
import kodlamaio.hrms.entities.dtos.CvGetDto;
@Service
public class CvManager implements CvService{

	private CvDao cvDao;
	private CloudinaryService cloudinaryService;
	private DtoConverterService dtoConverterService;
	 
	
	@Autowired
	public CvManager(CvDao cvDao, CloudinaryService cloudinaryService, DtoConverterService dtoConverterService) {
		super();
		this.cvDao = cvDao;
		this.cloudinaryService = cloudinaryService;
		this.dtoConverterService = dtoConverterService;
		
	}
		@Override
		public Result add(CvAddDto cvDto) {
			cvDao.save((Cv) dtoConverterService.dtoClassConverter(cvDto, Cv.class));
			return new SuccessResult("Kayıt Başarılı");
			
		}


		@Override
		public DataResult<List<CvGetDto>> getAll() {
			return new SuccessDataResult<List<CvGetDto>>
			(dtoConverterService.dtoConverter
					(cvDao.findAll(), CvGetDto.class)
					,"Data Listelendi");
			
		}

		@Override
		public Result saveImage(MultipartFile file, int cvId) {
			
			
			@SuppressWarnings("unchecked")
			Map<?, String> uploader = (Map<?, String>) 
					cloudinaryService.save(file).getData(); 
			String imageUrl= uploader.get("url");
			Cv Cv = cvDao.getOne(cvId);
			Cv.setPhoto(imageUrl);
			cvDao.save(Cv);
			return new SuccessResult("Kayıt Başarılı");
			
		}


		@Override
		public DataResult<List<CvGetDto>> findAllByCandidateId(int id) {
			return new SuccessDataResult<List<CvGetDto>>
			(dtoConverterService.dtoConverter
					(cvDao.findAllByCandidateId(id), CvGetDto.class)
					,"Data Listelendi");
		}
				

}
