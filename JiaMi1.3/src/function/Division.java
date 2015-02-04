package function;

import model.FileModel;

public class Division 
{
	public static long division(FileModel file)
	{
		long length=file.length();
		length=length/1024;
		return length;
	}

}
