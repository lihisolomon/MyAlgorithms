package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


public class MyDecompressorInputStream extends InputStream{

	InputStream in;


	public MyDecompressorInputStream(FileInputStream in) {
		this.in=in;
		
	}
	
	@Override
	public int read() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int read(byte[] b) throws IOException
	{
		Scanner Scanner = new Scanner(new File("1.maz"));
		Scanner input=Scanner.useDelimiter(",");
		

		int counter=0,j=9;
		byte wallOrPath=0;
		
		for(int i=0;i<9;i++)
			b[i]=Byte.valueOf(input.next());
		
		
		while(input.hasNext())
		{
				counter=Integer.valueOf(input.next());
				wallOrPath=Byte.valueOf(input.next());
				while (counter!=0)
				{
					b[j]=wallOrPath;
					counter--;
					j++;
				}
		}
		
		 return 0;
	}
}
