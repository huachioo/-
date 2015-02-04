package model;

import java.io.File;

public class FileModel extends File
{
	/**
	 * 
	 */
	private String KeyPath; //key�ļ���ַ
	private static final long serialVersionUID = 1L;
	private int BitLength=16; //��ȡ�������볤��
	private String FileName;
	private String FileType;
	private long FileSpace;  //�ļ���С
	private int FileHead[]; //�ļ�ǰ16λ��ʮ����
	private int RandomPath[];//������ɵ��ļ�ǰ16λʮ����
	private int FileContent[];//��ȡ����16λ�ĵ�����
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
