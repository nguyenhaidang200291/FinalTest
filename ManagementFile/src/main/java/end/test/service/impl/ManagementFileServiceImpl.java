package end.test.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import end.test.model.ManagementFile;
import end.test.repository.ManagementFileRepository;
import end.test.service.ManagementFileService;


@Service
@Transactional
public class ManagementFileServiceImpl implements ManagementFileService {
	
	@Autowired
	ManagementFileRepository managementFileRepository;
	
	@Override
	public Page<ManagementFile> listFileOfUser(String userName, Pageable pageable) {
		return managementFileRepository.listFileOfUser(userName, pageable);
	}

	@Override
	public void deleteFile(String id) {
		managementFileRepository.deleteById(id);
	}

	@Override
	public Optional<ManagementFile> getFileById(String id) {
		return managementFileRepository.findById(id);
	}
	
}

