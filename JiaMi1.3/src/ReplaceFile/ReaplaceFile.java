package ReplaceFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import function.Division;
import model.FileModel;

public class ReaplaceFile
{
	public static void reaplaceFile(FileModel File) throws IOException
	{
        long time= Division.division(File);
		FileInputStream in= new FileInputStream(File.getPath());
		FileChannel ReadChannel=in.getChannel();
		FileOutputStream out= new FileOutputStream(File.getPath(),true);
		FileChannel WriteChannel=out.getChannel();
		ByteBuffer ReadBuffer=ByteBuffer.allocate(File.getBitLength());
		//System.out.print(a);
        for(long i=1;i<time-1;i++)
        {
        	OutContent.outContent(ReadChannel,ReadBuffer,File, i);
        	InContent.inContent(WriteChannel,ReadBuffer,File, i);;
        }
        ReadChannel.close();
        in.close();
        WriteChannel.close();
        out.close();
	}
	

}
