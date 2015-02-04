package ReplaceFile;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import function.XOR;
import model.FileModel;

public class InContent 
{
	public static void inContent(FileChannel WriteChannel,ByteBuffer WriteBuffer,FileModel file,long Postion) throws IOException
	{		
	    int Path[]=file.getFileContent(); 
	    int FirstPath[]=file.getFilePath();
	    Path=XOR.xor(file, Path, FirstPath);
	    byte BytePath[]=new byte[file.getLocation()];	        
        for(int i=0;i<file.getLocation();i++)
        {
        	BytePath[i]=(byte) Path[i];
        }
        WriteBuffer.clear();
        WriteBuffer.put(BytePath);
        WriteBuffer.flip();
		WriteChannel.write(WriteBuffer, Postion*1024);
	}
}
