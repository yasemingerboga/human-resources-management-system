package kodlamaio.hrms.core.utilities.results;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Result {
	@NonNull
	private boolean success;
	private String message;
	
	public String getMessage() {
		return this.message;
	}
}
