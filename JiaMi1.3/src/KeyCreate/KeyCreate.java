package KeyCreate;

import java.io.FileInputStream;

import com.x.ut.util.MD.MD5Pstream;

import model.FileModel;

public class KeyCreate 
{
	public static void keyCreate(FileModel File) throws Exception
	{
		KeyName.Keyname(File);
		KeyInFile.keyInFile(File);
    	FileInputStream in= new FileInputStream(File.getPath());
    	MD5Pstream md5=new MD5Pstream(in);
		byte[] MD5byte=new byte[1000];
		MD5byte=md5.process();
	    KeyInFile.MD5InFile(File, MD5byte);		
	}
}
