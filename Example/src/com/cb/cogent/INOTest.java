package com.cb.cogent;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.RandomAccess;

public class INOTest {

	private static String home = System.getProperty("user.home");
	
	public static void existPath() throws IOException {
/*		Path path = Paths.get(home);
		System.out.println(Files.exists(path));
		System.out.println(Files.isRegularFile(path));
		System.out.println(Files.isExecutable(path));
		System.out.println(Files.isReadable(path));
		System.out.println(Files.isWritable(path));
		//System.out.println(Files.isSameFile(path, path2));
		
		String newFile = "New folder/cb.txt";
		String newDir = "New folder";
		Path p2 = Paths.get(home+"/"+newFile);
		//Files.createFile(p2);
		Path p3 = Paths.get(home+"/"+newDir);
		//Files.createDirectory(p3);
		Files.exists(p2);
		Files.exists(p3);
		System.out.println(Files.isRegularFile(p2));
		System.out.println(Files.isDirectory(p3));
		String nio2 = "temp";
		String txt = "txt";
		Path p4 = Paths.get(home+"/");
		Files.createTempFile(p4, nio2, txt);
		System.out.println(Files.exists(p4));
		System.out.println(Files.createTempFijle(p4, null, null));
	*/System.out.println("d");	
	}
	
	public static void main(String[] args) {
		
		try {
			RandomAccessFile raf = new RandomAccessFile("G:\\Newfolder\\NewTextDocument.txt", "rw");
			FileChannel channel = raf.getChannel();
			ByteBuffer buf = ByteBuffer.allocate(100);
			int bytesRead = 0; //= channel.read(buf);
			while(bytesRead!=-1) {
				bytesRead = channel.read(buf);
				System.out.println("Read "+bytesRead);
				buf.flip();
			}
			while(buf.hasRemaining()) {
				System.out.println((char)buf.get());
			}
			buf.clear();
			bytesRead = channel.read(buf);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}
