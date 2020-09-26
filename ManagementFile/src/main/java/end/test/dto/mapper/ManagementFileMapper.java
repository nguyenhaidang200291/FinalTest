package end.test.dto.mapper;

import org.mapstruct.*;

import end.test.dto.ManagementFileDTO;
import end.test.model.ManagementFile;


/**
 * Mapper for the entity ManagementFile and its DTO ManagementFileDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ManagementFileMapper extends EntityMapper<ManagementFileDTO, ManagementFile> {

    default ManagementFile fromId(Long id) {
        if (id == null) {
            return null;
        }
        ManagementFile managementFile = new ManagementFile();
        managementFile.setId(id);
        return managementFile;
    }
}