package model;

import java.io.File;

public class FileModel extends File
{
	/**
	 * 
	 */
	private String KeyPath; //key文件地址
	public String getKeyPath() {
		return KeyPath;
	}
	public void setKeyPath(String keyPath) {
		KeyPath = keyPath;
	}
	private static final long serialVersionUID = 1L;
	private int location=16;
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public FileModel(String pathname) {
		super(pathname);
		// TODO Auto-generated constructor stub
	}
	private String FileName;
	//private String FileAddress;
	private String FileType;
	private long FileSpace;
	private int FilePath[]; //文件前64位的十进制
	private int RandomPath[];//随机生成的文件前64位十进制
	private int FileContent[];
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public String getFileType() {
		return FileType;
	}
	public void setFileType(String fileType) {
		FileType = fileType;
	}
	public int[] getFilePath() {
		return FilePath;
	}
	public void setFilePath(int[] filePath) {
		FilePath = filePath;
	}
	public int[] getRandomPath() {
		return RandomPath;
	}
	public void setRandomPath(int[] randomPath) {
		RandomPath = randomPath;
	}
	public long getFileSpace() {
		return FileSpace;
	}
	public void setFileSpace(long fileSpace) {
		FileSpace = fileSpace;
	}
	public int[] getFileContent() {
		return FileContent;
	}
	public void setFileContent(int[] fileContent) {
		FileContent = fileContent;
	}
}
