package demo.hadoop.rpc.server;

import org.apache.hadoop.ipc.VersionedProtocol;

//包含了客户端需要调用的业务方法
public interface ScutInterface extends VersionedProtocol {
    //指明本接口的ID: 不同的接口ID表示不同的接口
    public static long versionID = 1;
    //具体的业务方法
    public String sayHelloworld(String name);
}
