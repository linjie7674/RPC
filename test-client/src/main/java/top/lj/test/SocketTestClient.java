package top.lj.test;

import top.lj.rpc.api.ByeService;
import top.lj.rpc.api.HelloObject;
import top.lj.rpc.api.HelloService;
import top.lj.rpc.serializer.CommonSerializer;
import top.lj.rpc.transport.RpcClientProxy;
import top.lj.rpc.transport.socket.client.SocketClient;

/**
 * 测试用消费者（客户端）
 *
 * @author lj
 */
public class SocketTestClient {

    public static void main(String[] args) {
        SocketClient client = new SocketClient(CommonSerializer.DEFAULT_SERIALIZER);
        RpcClientProxy proxy = new RpcClientProxy(client);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message from Socket");
        String res = helloService.hello(object);
        System.out.println("从服务端返回的结果是：" + res);
        ByeService byeService = proxy.getProxy(ByeService.class);
        System.out.println("从服务端返回的结果是：" + byeService.bye("Socket Server"));
    }

}
