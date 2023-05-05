package top.lj.rpc.transport;

import top.lj.rpc.entity.RpcRequest;
import top.lj.rpc.serializer.CommonSerializer;

/**
 * 客户端类通用接口
 *
 * @author lj
 */
public interface RpcClient {

    int DEFAULT_SERIALIZER = CommonSerializer.KRYO_SERIALIZER;

    Object sendRequest(RpcRequest rpcRequest);

}
