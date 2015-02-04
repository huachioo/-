package KeyOut;

import java.io.IOException;

import model.FileModel;

public class KeyOut
{
	public static void keyOut(FileModel File) throws IOException
	{
		KeyName.Keyname(File);
		KeyOutFile.keyOutFile(File);
	}
}
