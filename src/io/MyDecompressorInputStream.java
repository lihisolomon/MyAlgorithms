package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
		
		return in.read();
	}
	
	public int read(byte[] b) throws IOException
	{
			int i=0;
			byte counter,valueInArray;
			
			while(i<b.length)
			{
					counter=(byte)in.read();
					valueInArray=(byte)in.read();
					while (counter!=0)
					{
						b[i]=valueInArray;
						counter--;
						i++;
					}
			}
		
		 return b.length;
	}
}
