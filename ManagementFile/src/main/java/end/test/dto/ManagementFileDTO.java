package end.test.dto;

public class ManagementFileDTO {

    private Long id;
    private String userName;
    private String fileId;
    private byte[] data;
    private String fileName;
    private String fileType;
    private String uriDownload;
    private long read;
    private long share;
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
