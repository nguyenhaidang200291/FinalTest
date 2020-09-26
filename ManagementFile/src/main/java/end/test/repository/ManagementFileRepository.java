package end.test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import end.test.model.ManagementFile;


@Repository
public interface ManagementFileRepository extends JpaRepository<ManagementFile, String> {
	Page<ManagementFile> listFileOfUser(String userName, Pageable pageable);
}
