package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="activation_codes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivationCode {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="id")
	 private int id;
	 
	 @Column(name="activation_code")
	    private String activationCode;
	 
	 @Column(name="is_confirmed")
	    private boolean isConfirmed;
	 
	 @Column(name="created_at", columnDefinition = "Date defult CURRENT_DATE")
		private LocalDate createAt = LocalDate.now();
}
