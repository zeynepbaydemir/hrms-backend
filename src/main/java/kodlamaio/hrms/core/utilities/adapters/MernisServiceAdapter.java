package kodlamaio.hrms.core.utilities.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.EmailService.FakeMernisService;

@Service
public class MernisServiceAdapter implements ValidationService{

	@Override
	public boolean validateByMernis(long nationalIdentity,String firstName, String lastName, int dateOfBirth) {

		FakeMernisService client = new FakeMernisService();
		
		boolean result = true;
		try {
			result = client.ValidateByPersonalInfo(nationalIdentity, firstName, lastName, dateOfBirth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

}
