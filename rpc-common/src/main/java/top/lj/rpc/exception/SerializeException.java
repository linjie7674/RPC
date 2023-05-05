package top.lj.rpc.exception;

/**
 * 序列化异常
 *
 * @author lj
 */
public class SerializeException extends RuntimeException {
    public SerializeException(String msg) {
        super(msg);
    }
}
