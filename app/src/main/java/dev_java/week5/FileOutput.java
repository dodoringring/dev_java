package dev_java.week5;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class FileOutput {
	public static void main(String[] args) {
		OutputStreamWriter out = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("E:\\vscode_java\\dev_java\\app\\src\\main\\java\\dev_java\\week5\\test.txt",true);//true를 해줘야 덮어쓰기가 아닌 이어쓰기가 가능하다.
			out = new OutputStreamWriter(fos, "UTF-8");
			out.write("hello");
			out.write(" java");
			out.close();//클로즈 호출하기
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}