package end.test.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "files")
public class DBFile {
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public long getShareFile() {
		return shareFile;
	}

	public void setShareFile(long shareFile) {
		this.shareFile = shareFile;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;
    
    @Column(name = "user_name")
    private String userName;
    
    @Lob
    @Column(name = "data")
    private byte[] data;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "uri_download")
    private String uriDownload;
    
    @Column(name = "size")
    private long size;
    
    @Column(name = "share_file")
    private long shareFile;
    
    @Column(name = "create_date")
    private Date createDate;
    
    @Column(name = "update_date")
    private Date updateDate;
    
    @Column(name = "create_user")
    private String createUser;
    
    @Column(name = "update_user")
    private String updateUser;
    
}
