package m;

import java.io.IOException;

import KeyOut.KeyOut;
import ReplaceFile.ReaplaceFile;
import function.Infile;
import model.FileModel;

public class JieMi
{
	public static void main(String args[]) throws IOException
	{
		int pre=(int) System.currentTimeMillis();
	
		FileModel File=new FileModel("D:/1234.pdf");
		KeyOut.keyOut(File);
		Infile.InputPath(File);
		ReaplaceFile.reaplaceFile(File);       
        int post=(int) System.currentTimeMillis();
        int time=post-pre;
        System.out.println(time);
	}
}
