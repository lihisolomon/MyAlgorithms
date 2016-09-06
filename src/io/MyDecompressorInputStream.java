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
		Scanner input = new Scanner(new File("1.maz")).useDelimiter(",");

		int counter,i=0;
		byte valueInArray;
		
		while(input.hasNext())
		{
				counter=Integer.valueOf(input.next());
				valueInArray=Byte.valueOf(input.next());
				while (counter!=0)
				{
					b[i]=valueInArray;
					counter--;
					i++;
				}
		}
		
		 return 0;
	}
}
