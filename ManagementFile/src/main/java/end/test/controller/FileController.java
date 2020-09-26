package end.test.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import end.test.dto.DBFileDTO;
import end.test.dto.mapper.DBFileMapper;
import end.test.model.DBFile;
import end.test.service.DBFileService;

@RestController
public class FileController {
	
	@Autowired
	private DBFileService dbFileService;
	
	@Autowired
	private DBFileMapper dbFileMapper;
	
	// Upload file
	@PostMapping("/uploadFile")
	public DBFileDTO uploadFile(@RequestParam("file") MultipartFile file) {
		DBFile dbFile = dbFileService.storeFile(file);
		DBFileDTO result = dbFileMapper.toDto(dbFile);	
		return result;
	}
	
	// Upload Multiple Files
	@PostMapping("/uploadMultipleFiles")
	public List<DBFileDTO> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
		return Arrays.asList(files).stream().map(file -> uploadFile(file)).collect(Collectors.toList());
	}
	
	
}
