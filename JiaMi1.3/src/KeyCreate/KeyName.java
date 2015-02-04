package KeyCreate;

import model.FileModel;

public class KeyName 
{
	public static void Keyname(FileModel File)
	{
		char Path[]=File.getPath().toCharArray();
		String KeyName ="";
		for(char Temp:Path)
		{
			if(Temp=='.')
			{
				break;
			}
			KeyName=KeyName+Temp;
		}
		KeyName=KeyName+".key";
		File.setKeyPath(KeyName);
	}
}
