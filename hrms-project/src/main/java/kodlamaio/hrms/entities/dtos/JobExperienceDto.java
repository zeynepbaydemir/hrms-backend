package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceDto {

	@JsonIgnore
	private int id;
	private int cvId;
	private String companyName;
	private Date startedDate;
	private Date endedDate;
	private int jobTitleId;
}
