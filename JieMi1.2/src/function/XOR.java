package function;

import model.FileModel;

public class XOR 
{
	public static int[] xor(FileModel File,int[] FirstPath,int[] content)
	{
		int[] XORpath=new int[16];
		for(int i=0;i<File.getLocation();i++)
		{
			XORpath[i]=FirstPath[i]^content[i];
		}
		return XORpath;
	}
}
