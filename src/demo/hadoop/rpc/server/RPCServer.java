package demo.hadoop.rpc.server;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;

public class RPCServer {
    //RPC的server
    private RPC.Server server = null;

    public RPCServer() throws IOException {
        //定义一个builder
        RPC.Builder builder  = new RPC.Builder(new Configuration());

        //定义server的参数
        builder.setBindAddress("localhost");
        builder.setPort(1107);

        //将接口注册到server上
        builder.setProtocol(ScutInterface.class);
        builder.setInstance(new ScutInterfaceImpl());

        //创建server
        server = builder.build();

        server.start();
    }

    public static void main(String args[]) throws IOException {
        new RPCServer();
    }
}
