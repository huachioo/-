package function;

import java.io.FileInputStream;
import java.io.IOException;

import model.FileModel;

public class Outfile  //��ȡ�ļ�ǰ128λ
{
	public static void OutPath(FileModel file) throws IOException  //��ȡ�ļ�ǰ128λ
	{
		int temp[]=new int[file.getBitLength()];
		@SuppressWarnings("resource")
		FileInputStream in= new FileInputStream(file.getPath());
		long space=in.available();
		int data=0,i=0;		   
		file.setFileSpace(space);
		for(;i<file.getBitLength();i++)
		{
			data=in.read();
			temp[i]=data;
		}
		file.setFileHead(temp);	
	}

}