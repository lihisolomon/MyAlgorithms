package io;

import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends java.io.OutputStream{

	OutputStream out;
	
	public MyCompressorOutputStream(OutputStream out) {
		this.out=out;
	}
	@Override
	public void write(int b) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
