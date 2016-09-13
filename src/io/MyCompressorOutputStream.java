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
	 * @param1 b 
	 * 
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
	 * 1,1,1 -> 3,1 && 0,0,1,1 -> 2,0,2,1
	 * @param1 - b byte array
	 */
	@Override
	public void write(byte[] b) {
	
		 int counter=0;
		 byte lastNumber=b[0];
		 try { 
			 for(int i=0;i<b.length;i++)
			{
				if(lastNumber != b[i])
				{
					while(counter>=255)
					{
						out.write(255);
						out.write(lastNumber);
						counter-=255;
					}
			
					out.write(counter);
					out.write(lastNumber);
					lastNumber = b[i];
					counter = 1;
				}
				else
					counter++;
			}
			out.write(counter);
			out.write(lastNumber);
		 } catch (IOException e) {
				e.printStackTrace();
			}
	}
}
