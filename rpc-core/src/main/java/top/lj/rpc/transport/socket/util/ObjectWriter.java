package top.lj.rpc.transport.socket.util;

import top.lj.rpc.entity.RpcRequest;
import top.lj.rpc.enumeration.PackageType;
import top.lj.rpc.serializer.CommonSerializer;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Array;
import java.util.Arrays;

/**
 *
 * @author lj
 */
public class ObjectWriter {

    private static final int MAGIC_NUMBER = 0xCAFEBABE;

    /**
     * Write object to outputstream, where using custom protocol to avoid sticking packet.
     * @author lj
     */
    public static void writeObject(OutputStream outputStream, Object object, CommonSerializer serializer) throws IOException {
        outputStream.write(intToBytes(MAGIC_NUMBER)); // Magic Number
        if (object instanceof RpcRequest) {
            outputStream.write(intToBytes(PackageType.REQUEST_PACK.getCode()));
        } else {
            outputStream.write(intToBytes(PackageType.RESPONSE_PACK.getCode()));
        } // Package Type
        outputStream.write(intToBytes(serializer.getCode())); // Serializer Type
        byte[] bytes = serializer.serialize(object);
        outputStream.write(intToBytes(bytes.length)); // Data Length, which can avoid the occurrence of magic number in data bytes
        outputStream.write(bytes); // data bytes
        outputStream.flush();

    }

    private static byte[] intToBytes(int value) {
        byte[] src = new byte[4];
        for (int i = 0; i < 4; ++i) {
            src[3 - i] = (byte) (value & 0xFF);
            value = value >> 8;
        }
        return src;
    }
}
