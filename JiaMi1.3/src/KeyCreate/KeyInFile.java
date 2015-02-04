package KeyCreate;

import java.io.FileOutputStream;
import java.io.IOException;

import model.FileModel;

public class KeyInFile
{
	public static void keyInFile(FileModel File) throws IOException
	{
		FileOutputStream out= new FileOutputStream(File.getKeyPath());
		int[] Path=File.getFileHead();
	    byte BytePath[]=new byte[File.getBitLength()];
        for(int i=0;i<File.getBitLength();i++)
        {
        	BytePath[i]=(byte) Path[i];
        }
		out.write(BytePath);
		out.close();
	}
	
	public static void MD5InFile(FileModel File,byte[] MD5) throws IOException
	{
		FileOutputStream out= new FileOutputStream(File.getKeyPath(),true);
		//int[] Path=File.getFilePath();
	  //  byte BytePath[]=new byte[File.getLocation()];
//        for(int i=0;i<File.getLocation();i++)
//        {
//        	BytePath[i]=(byte) Path[i];
//        }
		out.write(MD5);
		out.close();
	}
}
