package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * MyDecompressorInputStream class extends InputStream
 */
public class MyDecompressorInputStream extends InputStream{

	protected InputStream in;
	
	/**
	 * CTOR
	 * @param in FileInputStream
	 */
	public MyDecompressorInputStream(FileInputStream in) {
		this.in=in;
		
	}
	
	/**
	 * Overrides the read class and read bytes array from file
	 */
	@Override
	public int read() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * This function convert the byte array from 3,1,4,0 to 
	 * 1,1,1,0,0,0,0
	 * @param b- byte[] 
	 */
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
