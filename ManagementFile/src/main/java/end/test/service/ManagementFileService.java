package end.test.service;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import end.test.model.ManagementFile;

public interface ManagementFileService {	
	Page<ManagementFile> listFileOfUser(String userName, Pageable pageable);
	void deleteFile (String id);
	Optional<ManagementFile> getFileById(String id);	
}
