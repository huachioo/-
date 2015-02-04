package function;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import model.FileModel;

public class Infile  //将字符串写入文件
{
	public static void InputPath(FileModel file) throws IOException  //将文件前16位数重新写入文件
	{
		FileOutputStream out= new FileOutputStream(file.getPath(),true);
		FileChannel WriteChannel=out.getChannel();
		ByteBuffer WriteBuffer=ByteBuffer.allocate(file.getLocation());	
	    int Path[]=file.getFilePath();
	    byte BytePath[]=new byte[file.getLocation()];
        for(int i=0;i<file.getLocation();i++)
        {
        	BytePath[i]=(byte) Path[i];
        }
        WriteBuffer.clear();
        WriteBuffer.put(BytePath);
        WriteBuffer.flip();
		WriteChannel.write(WriteBuffer, 0);
		out.close();	
	}
}
