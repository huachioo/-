package KeyOut;

import java.io.FileInputStream;
import java.io.IOException;
import model.FileModel;

public class KeyOutFile 
{
	public static void keyOutFile(FileModel File) throws IOException
	{
			FileInputStream in= new FileInputStream(File.getKeyPath());
			int temp[]=new int[File.getLocation()];
			int data=0,i=0;		
			for(;i<File.getLocation();i++)
			{
				data=in.read();
				temp[i]=data;
			}
			File.setFilePath(temp);
			in.close();	
	}
}
