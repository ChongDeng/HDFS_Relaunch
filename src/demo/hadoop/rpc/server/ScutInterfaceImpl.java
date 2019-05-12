package demo.hadoop.rpc.server;

import org.apache.hadoop.ipc.ProtocolSignature;

import java.io.IOException;

public class ScutInterfaceImpl implements ScutInterface{

    @Override
    public String sayHelloworld(String name){
        return "=====  hello " + name;
    }

    @Override
    public long getProtocolVersion(String s, long l) throws IOException {
        return ScutInterface.versionID;
    }

    @Override
    public ProtocolSignature getProtocolSignature(String s, long l, int i) throws IOException {
        return new ProtocolSignature(ScutInterface.versionID, null);
    }
}
