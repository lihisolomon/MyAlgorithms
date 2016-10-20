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
		int index = 0;
		int counter;
		byte valueInArray;
		
		while (((counter = read()) != -1) && ((valueInArray = (byte)read()) != -1))
			if ((index >= b.length))
				return -1;
			else
				for (counter = counter & 0xFF;counter > 0; counter--)
					b[index++] = valueInArray;
		
		return index;
	}
}
