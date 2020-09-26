package end.test.model;
import javax.persistence.*;
@Entity
@Table(name = "management")
public class ManagementFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)   
    @Column(name = "id")
    private Long id;
    
    @Column(name = "user_name")
    private String userName;
    
    @Column(name = "file_id")
    private String fileId;
    
    @Lob
    @Column(name = "data")
    private byte[] data;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "uri_download")
    private String uriDownload;
        
    @Column(name = "read_file")
    private long read;
    
    @Column(name = "share_file")
    private long share;
    
    @Column(name = "owner_file")
    private long owner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getUriDownload() {
		return uriDownload;
	}

	public void setUriDownload(String uriDownload) {
		this.uriDownload = uriDownload;
	}

	public long getRead() {
		return read;
	}

	public void setRead(long read) {
		this.read = read;
	}

	public long getShare() {
		return share;
	}

	public void setShare(long share) {
		this.share = share;
	}

	public long getOwner() {
		return owner;
	}

	public void setOwner(long owner) {
		this.owner = owner;
	}



}
