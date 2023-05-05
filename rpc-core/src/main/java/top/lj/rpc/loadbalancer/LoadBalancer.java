package top.lj.rpc.loadbalancer;

import com.alibaba.nacos.api.naming.pojo.Instance;

import java.util.List;

/**
 * @author lj
 */
public interface LoadBalancer {

    Instance select(List<Instance> instances);

}
