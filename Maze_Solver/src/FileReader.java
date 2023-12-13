import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
	
	public int[][] read(File file) throws FileNotFoundException
	{
	    Scanner fscan1 = new Scanner(file);
	    int size=0;
		int size2=0;
		String str = "";
	    	    while(fscan1.hasNext())
	    {
	        size++;      
			str = fscan1.next();
			
	    }
		size2 = str.toCharArray().length;
	    int maze[][] = new int[size][size2];
	    fscan1.close();
	    int count=0;
	    Scanner fscan = new Scanner(file);
	    while(fscan.hasNext())
	    {
	       
	        String a = fscan.next();
	        char first[]= a.toCharArray();
	        for(int i=count;i<count+1;i++)
	        {
	            for(int j=0;j<size2;j++)
	            {
	             maze[i][j] = first[j]-'0';
	            }
	        }
	        count++;
	    }
		fscan.close();
	    return maze;
	}
}