package function;

import java.util.Random;

import model.FileModel;

public class random {
	
    public  static void  randomfunc(FileModel file)  //生成8个大小为0-16的随机数
    {
        int max=255;
        int min=0;    
        int temp[]=new int[file.getBitLength()];//存储随机数
        Random random = new Random();
        for(int i=0;i<file.getBitLength();i++)
        {
        	 int s = random.nextInt(max)%(max-min+1) + min;
             temp[i]=s;
        }
        file.setRandomPath(temp);
    }
}
