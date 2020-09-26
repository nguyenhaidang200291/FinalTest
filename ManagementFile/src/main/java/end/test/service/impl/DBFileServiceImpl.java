package end.test.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import end.test.config.SecurityUtils;
import end.test.exception.FileStorageException;
import end.test.exception.MyFileNotFoundException;
import end.test.model.DBFile;
import end.test.model.ManagementFile;
import end.test.repository.DBFileRepository;
import end.test.repository.ManagementFileRepository;
import end.test.service.DBFileService;


@Service
@Transactional
public class DBFileServiceImpl implements DBFileService {
	
	@Autowired
	DBFileRepository dbFileRepository;
	
	@Autowired
	ManagementFileRepository managementFileServiceRepository;
	
	@Override
	public DBFile storeFile(MultipartFile file) {
	       // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            
			//Get username loggin
			String userName = SecurityUtils.getCurrentUserIDLogin().get().toString();

            DBFile dbFile = new DBFile();
            dbFile.setUserName(userName);
            dbFile.setFileName(fileName);
            dbFile.setFileType(file.getContentType());
            dbFile.setData(file.getBytes());
            dbFile.setSize(file.getSize());
            dbFile.setShareFile(0);
            Date date = new Date();
            dbFile.setCreateDate(date);
            dbFile.setUpdateDate(date);
            dbFile.setCreateUser(userName);
            dbFile.setUpdateUser(userName);
            DBFile objectDBFile = dbFileRepository.save(dbFile);
            //update  uri_download
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/downloadFile/")
                    .path(objectDBFile.getId())
                    .toUriString();
            objectDBFile.setUriDownload(fileDownloadUri);
            
            //Save data to table management
			ManagementFile managementFile = new ManagementFile();
			managementFile.setFileId(objectDBFile.getId());
			managementFile.setUserName(userName);
			managementFile.setFileName(fileName);
			managementFile.setFileType(file.getContentType());
			managementFile.setData(file.getBytes());
			managementFile.setUriDownload(objectDBFile.getUriDownload());
			managementFile.setRead(1);
			managementFile.setShare(1);
			managementFile.setOwner(1);
			managementFileServiceRepository.save(managementFile);
			
            return dbFileRepository.save(objectDBFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
	}

	@Override
	public DBFile updateStoreFile(MultipartFile file, DBFile dbFileData) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

			String userName = SecurityUtils.getCurrentUserIDLogin().get().toString();
			dbFileData.setFileName(fileName);
			dbFileData.setFileType(file.getContentType());
			dbFileData.setData(file.getBytes());
			dbFileData.setSize(file.getSize());
            Date date = new Date();
            dbFileData.setUpdateDate(date);
            dbFileData.setUpdateUser(userName);
            DBFile objectDBFile = dbFileRepository.save(dbFileData);
            return dbFileRepository.save(objectDBFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
	}

	
	@Override
	public DBFile getFile(String fileId) {
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
	}
	
	@Override
	public Optional<DBFile> getFileById(String id) {
		return dbFileRepository.findById(id);
	}

	@Override
	public void deleteFile(String id) {
		dbFileRepository.deleteById(id);
	}

	@Override
	public DBFile saveDBFile(DBFile dbFile) {
		return dbFileRepository.save(dbFile);
	}
}

