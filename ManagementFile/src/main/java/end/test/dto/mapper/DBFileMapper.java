package end.test.dto.mapper;

import org.mapstruct.*;

import end.test.dto.DBFileDTO;
import end.test.model.DBFile;

/**
 * Mapper for the entity DBFile and its DTO DBFileDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DBFileMapper extends EntityMapper<DBFileDTO, DBFile> {

    default DBFile fromId(String id) {
        if (id == null) {
            return null;
        }
        DBFile dbFile = new DBFile();
        dbFile.setId(id);
        return dbFile;
    }
}