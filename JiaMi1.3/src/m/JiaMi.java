package m;

import java.io.FileInputStream;

import com.x.ut.util.MD.MD5Pstream;

import KeyCreate.KeyCreate;
import ReplaceFile.ReaplaceFile;
import model.FileModel;
import function.Infile;
import function.Outfile;
import function.random;
public class JiaMi
{
    public static void main(String[] args) throws Exception
    {                
    	int pre=(int) System.currentTimeMillis();
    	
    	FileModel file=new FileModel("D:/1234.pdf");   	
    	
        Outfile.OutPath(file);       
        //KeyCreate.keyCreate(file);
        ReaplaceFile.reaplaceFile(file);
        random.randomfunc(file);
        Infile.InputRandomPath(file);          
        int post=(int) System.currentTimeMillis();
        int time=post-pre;
        System.out.println(time);
    }
}
