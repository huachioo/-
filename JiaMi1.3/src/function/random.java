package function;

import java.util.Random;

import model.FileModel;

public class random {
	
    public  static void  randomfunc(FileModel file)  //����8����СΪ0-16�������
    {
        int max=255;
        int min=0;    
        int temp[]=new int[file.getBitLength()];//�洢�����
        Random random = new Random();
        for(int i=0;i<file.getBitLength();i++)
        {
        	 int s = random.nextInt(max)%(max-min+1) + min;
             temp[i]=s;
        }
        file.setRandomPath(temp);
    }
}
