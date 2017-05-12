package com.alfago.weixin.common.message.activemq;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("C:\\Users\\Administrator\\workspace\\alfago\\src\\main\\resources\\spring\\applicationContext.xml", "rw");
        FileChannel inChannel = aFile.getChannel();
        //涉及到的buffer的方法稍后解释
        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            
            //make buffer ready for read
            buf.flip();

            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());// read 1 byte at a time
            }

            buf.clear();//buf.compact();也可以
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}