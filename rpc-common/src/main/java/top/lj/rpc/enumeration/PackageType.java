package top.lj.rpc.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author lj
 */
@AllArgsConstructor
@Getter
public enum PackageType {

    REQUEST_PACK(0),
    RESPONSE_PACK(1);

    private final int code;

}
