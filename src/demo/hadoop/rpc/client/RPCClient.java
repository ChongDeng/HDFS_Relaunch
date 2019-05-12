package demo.hadoop.rpc.client;

import demo.hadoop.rpc.server.ScutInterface;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

public class RPCClient {

    public static void main(String args[]) throws IOException {
        System.out.println("=======客户端的程序=======");

        //创建一个server的代理对象 --》调用ScutInterface中的业务方法
        ScutInterface proxy = RPC.getProxy(ScutInterface.class,
                                            ScutInterface.versionID,
                                            new InetSocketAddress("localhost", 1107),
                                            new Configuration());
        //通过代理对象调用server的业务程序
        String res = proxy.sayHelloworld("jacky chang");
        System.out.println(res);
    }
}
