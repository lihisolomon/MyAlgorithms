package io;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream{

	InputStream in;
	ByteArrayOutputStream buffer;

	public MyDecompressorInputStream(FileInputStream in) {
		this.in=in;
		buffer = new ByteArrayOutputStream();
	}
	
	@Override
	public int read() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int read(byte[] b) throws IOException
	{
		int length;
		byte[] temp = new byte[16384];

		while ((length = in.read(temp, 0, temp.length)) != -1) {
		  buffer.write(temp, 0, length);
		}

		buffer.flush();
		temp=buffer.toByteArray();
		//
		//byte[] temp=new byte[1024];
		int counter=0,j=9;
		byte wallOrPath=0;
		
		//in.read(temp);
		
		for(int i=0;i<9;i++)
			b[i]=temp[i];
		
		for(int i=9;temp[i]!=-1;i++)
		{
				counter=(int)temp[i];
				wallOrPath=temp[i+1];
				i+=2;
			while (counter!=0)
			{
				b[j]=wallOrPath;
				counter--;
				j++;
			}
			
		}
		//
		return 0;
	}
}
