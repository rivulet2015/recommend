package com.alfago.weixin.common.file;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.RuntimeException;
import java.lang.Thread;

public class NioFileHanlder {
	
	private static Integer defaultBufferSize = 1024;
	
	private ByteBuffer buffer = ByteBuffer.allocate(defaultBufferSize); 
	
	public void copy(String srcFilePath,String disFilePath) throws IOException{
		
		FileInputStream  fileInput = new FileInputStream (new File(srcFilePath)); 
		FileOutputStream  fileOutput = new FileOutputStream (new File(disFilePath));
		if(fileInput != null && fileOutput != null){
			FileChannel fileInputChannel = fileInput.getChannel();
			FileChannel fileOutChannel = fileOutput.getChannel();
			long beginTime = System.currentTimeMillis();
	        while (fileInputChannel.read(buffer) != -1) { 
	        	buffer.flip(); 
	        	fileOutChannel.write(buffer); 
	        	buffer.clear(); 
	        } 	
	        long end = System.currentTimeMillis();
	        System.out.println(end - beginTime);
		}
	
	}
	
	
	public static void main(String[] arg) throws IOException{
		
		NioFileHanlder copyer = new NioFileHanlder();
		copyer.copy("src/main/java/1.rmvb", "src/main/java/2.rmvb");
	}
}