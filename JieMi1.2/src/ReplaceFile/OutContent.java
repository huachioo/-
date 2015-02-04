package ReplaceFile;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import model.FileModel;

public class OutContent 
{
	public static void outContent(FileChannel ReadChannel,ByteBuffer ReadBuffer,FileModel file,long Position) throws IOException  //截取文件指定文职
	{
		int Path[]=new int[file.getLocation()];
		byte BytePath[]=new byte[file.getLocation()];
		ReadBuffer.clear();
		ReadChannel.read(ReadBuffer, Position*1024);
		ReadBuffer.flip();
		ReadBuffer.get(BytePath);
        for(int i=0;i<file.getLocation();i++)
        {
        	Path[i]=BytePath[i];
        }
        file.setFileContent(Path);
	}
}
