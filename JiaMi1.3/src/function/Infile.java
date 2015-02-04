package function;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import model.FileModel;

public class Infile  //将字符串写入文件
{
	public static void InputRandomPath(FileModel file) throws IOException  //将随机生成数写入文件
	{
		FileOutputStream out= new FileOutputStream(file.getPath(),true);
		FileChannel WriteChannel=out.getChannel();
		ByteBuffer WriteBuffer=ByteBuffer.allocate(file.getBitLength());
		
	    int Path[]=new int[file.getBitLength()];
	    byte BytePath[]=new byte[file.getBitLength()];
        Path=file.getRandomPath();
        
        for(int i=0;i<file.getBitLength();i++)
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
