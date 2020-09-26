//package end.test.service.impl;
//
//import static org.mockito.Mockito.when;
//
//import java.util.Optional;
//
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.TemporaryFolder;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import end.test.model.DBFile;
//import end.test.repository.DBFileRepository;
//import end.test.service.DBFileService;
//
//
//@RunWith(SpringRunner.class)
//@AutoConfigureMockMvc
//@SpringBootTest
//public class DBFileServiceTest {
//
//	@Mock
//	private DBFileService dbFileService;
//
//	@MockBean
//	private DBFileRepository dbFileRepository;
//
//
//	@Rule
//	public TemporaryFolder folder = new TemporaryFolder();
//	
//
//	@Test
//	public void storeFileTest() throws Exception {
//		MockMultipartFile file = new MockMultipartFile("file", "hello.txt", MediaType.TEXT_PLAIN_VALUE,
//				"Hello, World!".getBytes());
//		DBFile dbFile = new DBFile();
//		when(dbFileService.storeFile(file)).thenReturn(dbFile);
//	}
//
//}
