package end.test.service;

import java.util.Optional;
import org.springframework.web.multipart.MultipartFile;

import end.test.model.DBFile;

public interface DBFileService {	
	Optional<DBFile> getFileById(String id);
	DBFile saveDBFile(DBFile dbFile);
	void deleteFile (String id);
	DBFile storeFile(MultipartFile file);
	DBFile updateStoreFile(MultipartFile file, DBFile dbFile);
	DBFile getFile(String fileId);
}
