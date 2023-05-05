package top.lj.rpc.serializer;

/**
 * 通用的序列化反序列化接口
 *
 * @author lj
 */
public interface CommonSerializer {

    Integer KRYO_SERIALIZER = 0;
    Integer JSON_SERIALIZER = 1;

    Integer DEFAULT_SERIALIZER = KRYO_SERIALIZER;

    static CommonSerializer getInstanceByCode(int code) {
        switch (code) {
            case 0:
                return new KryoSerializer();
            case 1:
                return new JsonSerializer();
            default:
                return null;
        }
    }

    byte[] serialize(Object obj);

    Object deserialize(byte[] bytes, Class<?> clazz);

    int getCode();

}
