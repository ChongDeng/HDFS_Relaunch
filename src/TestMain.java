import java.io.*;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class TestMain {

	public static void main(String[] args){
		try {
			Download();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Upload() throws Exception {
		// 例1： 使用HDFS的API创建目录
		//设置NameNode地址
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.1.85:9000");

		//得到HDFS的文件系统
		FileSystem fs = FileSystem.get(conf);

		//构造一个输入流： C:\\Users\\fqyya\\Desktop\\qq.jpg
		InputStream in = new FileInputStream("C:\\Users\\fqyya\\Desktop\\qq.jpg");

		//构造输出流: /dc/qq.jpg
		OutputStream out = fs.create(new Path("/dc/qq2.jpg"));

		org.apache.hadoop.io.IOUtils.copyBytes(in, out, conf);
	}

	public static void Download() throws Exception {

		// 例1： 使用HDFS的API创建目录
		//设置NameNode地址
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.1.85:9000");

		//得到HDFS的文件系统
		FileSystem fs = FileSystem.get(conf);

		//构造一个输入流： HDFS
		InputStream in = fs.open(new Path("/dc/qq2.jpg"));

		//构造输出流: C:\\Users\\fqyya\\Desktop\\qq3.jpg"
		OutputStream out = new FileOutputStream("C:\\Users\\fqyya\\Desktop\\qq3.jpg");

		org.apache.hadoop.io.IOUtils.copyBytes(in, out, conf);
	}

}
