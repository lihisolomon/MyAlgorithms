package io;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream{

	
	protected OutputStream out;
	
	public MyCompressorOutputStream()  {
		try {
			OutputStream out=new FileOutputStream("1.maz");
		} catch (FileNotFoundException ex) {
		    System.out.println("File not found" );
		    ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (out != null)
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
				}
		    
		}
		
		
	}
	public MyCompressorOutputStream(OutputStream out)  {
		this.out=out;
	}
	
	/**
	 * Overrides the write class and writes bytes array to file
	 * @param b- int to write
	 */
	@Override
	public void write(int b){
		try {
			out.write(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * This function compress and writes the byte array 
	 * It inserts all the maze by sum's up all the sequential number for instance:
	 * 1,1,1 to 3,1 AND 0,0,1,1 to 2,0,2,1
	 * @param  b- byte array
	 */
	@Override
	public void write(byte[] b) {
		byte lastNumber = b[0];
		int counter = 0;
		
		for (byte myByte : b)
		{
			if ((myByte == lastNumber) && (counter < 255))
				counter++;
			else
			{
				write((byte)counter);
				write(lastNumber);
				counter = 1;
				lastNumber = myByte;
			}
		}
		write((byte)counter);
		write(lastNumber);
	}
}
