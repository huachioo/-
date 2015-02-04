package model;

import java.io.File;

public class FileModel extends File
{
	/**
	 * 
	 */
	private String KeyPath; //key文件地址
	private static final long serialVersionUID = 1L;
	private int BitLength=16; //截取二进制码长度
	private String FileName;
	private String FileType;
	private long FileSpace;  //文件大小
	private int FileHead[]; //文件前16位的十进制
	private int RandomPath[];//随机生成的文件前16位十进制
	private int FileContent[];//读取出的16位文档内容
	public String getKeyPath() {
		return KeyPath;
	}
	public void setKeyPath(String keyPath) {
		KeyPath = keyPath;
	}
	public int getBitLength() {
		return BitLength;
	}
	public void setBitLength(int BitLength) {
		this.BitLength = BitLength;
	}
	public FileModel(String pathname) {
		super(pathname);
		// TODO Auto-generated constructor stub
	}
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
	public int[] getFileHead() {
		return FileHead;
	}
	public void setFileHead(int[] fileHead) {
		FileHead = fileHead;
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
