package kodlamaio.hrms.api.conrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.TechnologyDto;

@RestController
@RequestMapping("api/technology")
public class TechnologyController {

	private TechnologyService technologyService;

	public TechnologyController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}

	@GetMapping("/getall")
	public DataResult<List<TechnologyDto>> getAll(){
		return this.technologyService.getAll();
	}
	
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody TechnologyDto technologyDto) {
		return this.technologyService.add(technologyDto);
	  }
	
}
