package top.lj.test;

import top.lj.rpc.annotation.ServiceScan;
import top.lj.rpc.serializer.CommonSerializer;
import top.lj.rpc.transport.RpcServer;
import top.lj.rpc.transport.socket.server.SocketServer;

/**
 * 测试用服务提供方（服务端）
 *
 * @author lj
 */
@ServiceScan
public class SocketTestServer {

    public static void main(String[] args) {
        RpcServer server = new SocketServer("127.0.0.1", 9998);
        server.start();
    }

}
