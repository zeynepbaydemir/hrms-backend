package kodlamaio.hrms.core.utilities.adapters;


public interface ValidationService {

	boolean validateByMernis(long nationalIdentity, String firstName, String lastName, int dateOfBirth);
}
