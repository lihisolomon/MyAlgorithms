package io;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream{

	
	protected OutputStream out;
	final private int WALL=1;
	final private int PATH=0;
	
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
		// TODO Auto-generated method stub
		
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
		 boolean islastOne=true;
			
		 for(int i=0;i<9;i++)
		 {
			 out.write(String.valueOf(b[i]).getBytes());
			 out.write(String.valueOf(deliminator).getBytes());
		 }
		 
		for(int i=9;i<b.length;i++)
		{
			if(b[i]==WALL)
			{
				
				if(!islastOne)
				{
					out.write(String.valueOf(counter).getBytes());
					out.write(String.valueOf(deliminator).getBytes());
					out.write(String.valueOf(PATH).getBytes());
					out.write(String.valueOf(deliminator).getBytes());
					counter=0;
				}
				islastOne=true;
				counter++;
				
				if(counter==255 )
				{
					out.write(String.valueOf(counter).getBytes());
					out.write(String.valueOf(deliminator).getBytes());
					out.write(String.valueOf(WALL).getBytes());
					out.write(String.valueOf(deliminator).getBytes());
					counter=0;
				}
			}
			else
			{
				
				if(islastOne)
				{
					out.write(String.valueOf(counter).getBytes());
					out.write(String.valueOf(deliminator).getBytes());
					out.write(String.valueOf(WALL).getBytes());
					out.write(String.valueOf(deliminator).getBytes());
					counter=0;
				}
				
				islastOne=false;
				counter++;
				
				if(counter==255)
				{
					out.write(String.valueOf(counter).getBytes());
					out.write(String.valueOf(deliminator).getBytes());
					out.write(String.valueOf(PATH).getBytes());
					out.write(String.valueOf(deliminator).getBytes());
					counter=0;
				}
			}
		}
	}
}
