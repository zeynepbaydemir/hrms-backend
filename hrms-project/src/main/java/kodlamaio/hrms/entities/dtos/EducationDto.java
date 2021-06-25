package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {

	@JsonIgnore
	private int id;
	private int cvId;
	private String schoolName;
	@JsonProperty(access = Access.WRITE_ONLY)
	private int graduateId;
	private String graduateDescription;
	private String schoolDepartment;
	private LocalDate startedDate;
	private LocalDate endedDate;
	private LocalDate createdDate;
}
