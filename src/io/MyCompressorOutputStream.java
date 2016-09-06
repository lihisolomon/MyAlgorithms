package io;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream{

	
	protected OutputStream out;
	
	public MyCompressorOutputStream() throws IOException {
		OutputStream out=new FileOutputStream("1.maz");
		
		
	}
	public MyCompressorOutputStream(OutputStream out)  throws IOException{
		this.out=out;
	}
	
	/**
	 * Overrides the write class and writes bytes array to file
	 * @param1 b 
	 * 
	 */
	@Override
	public void write(int b) throws IOException {
		out.write(String.valueOf(b).getBytes());
		
	}
	/**
	 * This function compress and writes the byte array 
	 * It inserts all the maze by sum's up all the sequential number for instance:
	 * 1,1,1 -> 3,1 && 0,0,1,1 -> 2,0,2,1
	 * @param1 - b byte array
	 */
	@Override
	public void write(byte[] b) throws IOException {
	
		 String deliminator=",";
		 int counter=0;
		 int lastNumber=b[0];
		 
		for(int i=0;i<b.length;i++)
		{
			if(b[i]!=lastNumber || counter==255 || i==b.length-1)
			{
				if( i==b.length-1)
					counter++;
				write(counter);
				out.write(String.valueOf(deliminator).getBytes());
				write(lastNumber);
				out.write(String.valueOf(deliminator).getBytes());
				counter=1;
				lastNumber=b[i];
				
			}
			else
				counter++;
				
		
		}
		System.out.println("sdf");
	}
	
}
