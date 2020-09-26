package end.test.dto.mapper;

import end.test.dto.ManagementFileDTO;
import end.test.model.ManagementFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-26T17:33:09+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
@Component
public class ManagementFileMapperImpl implements ManagementFileMapper {

    @Override
    public ManagementFile toEntity(ManagementFileDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ManagementFile managementFile = new ManagementFile();

        managementFile.setId( dto.getId() );
        managementFile.setUserName( dto.getUserName() );
        managementFile.setFileId( dto.getFileId() );
        byte[] data = dto.getData();
        if ( data != null ) {
            managementFile.setData( Arrays.copyOf( data, data.length ) );
        }
        managementFile.setFileName( dto.getFileName() );
        managementFile.setFileType( dto.getFileType() );
        managementFile.setUriDownload( dto.getUriDownload() );
        managementFile.setRead( dto.getRead() );
        managementFile.setShare( dto.getShare() );
        managementFile.setOwner( dto.getOwner() );

        return managementFile;
    }

    @Override
    public ManagementFileDTO toDto(ManagementFile entity) {
        if ( entity == null ) {
            return null;
        }

        ManagementFileDTO managementFileDTO = new ManagementFileDTO();

        managementFileDTO.setId( entity.getId() );
        managementFileDTO.setUserName( entity.getUserName() );
        managementFileDTO.setFileId( entity.getFileId() );
        byte[] data = entity.getData();
        if ( data != null ) {
            managementFileDTO.setData( Arrays.copyOf( data, data.length ) );
        }
        managementFileDTO.setFileName( entity.getFileName() );
        managementFileDTO.setFileType( entity.getFileType() );
        managementFileDTO.setUriDownload( entity.getUriDownload() );
        managementFileDTO.setRead( entity.getRead() );
        managementFileDTO.setShare( entity.getShare() );
        managementFileDTO.setOwner( entity.getOwner() );

        return managementFileDTO;
    }

    @Override
    public List<ManagementFile> toEntity(List<ManagementFileDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ManagementFile> list = new ArrayList<ManagementFile>( dtoList.size() );
        for ( ManagementFileDTO managementFileDTO : dtoList ) {
            list.add( toEntity( managementFileDTO ) );
        }

        return list;
    }

    @Override
    public List<ManagementFileDTO> toDto(List<ManagementFile> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ManagementFileDTO> list = new ArrayList<ManagementFileDTO>( entityList.size() );
        for ( ManagementFile managementFile : entityList ) {
            list.add( toDto( managementFile ) );
        }

        return list;
    }
}
