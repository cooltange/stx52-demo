package com.stx.s2.p51;

import java.io.FileReader;
import java.io.IOException;

/**
 * 字符文件输入流 示例
 * 
 * @author getan
 * 
 */
public class P52FileReader {
	public static void main(String[] args) throws IOException {
		FileReader fr = null;
		try {
			// 创建字符输入流
			fr = new FileReader("d:\\1.txt");

			// 用于保存实际读取的一个字符
			int c = 0;
			// 使用循环来重复读取字符流
			while ((c = fr.read()) != -1) {
				// 取出字符流中一个字符，将该字符输出
				System.out.print((char)c);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			// 使用finally块来关闭文件输入流
			if (fr != null) {
				fr.close();
			}
		}
	}
}
