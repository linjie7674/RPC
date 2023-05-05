package top.lj.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.lj.rpc.annotation.Service;
import top.lj.rpc.api.ByeService;

/**
 * @author lj
 */
@Service
public class ByeServiceImpl implements ByeService {

    private static final Logger logger = LoggerFactory.getLogger(ByeServiceImpl.class);

    @Override
    public String bye(String name) {
        logger.info("bye, " + name);
        return "bye, " + name;
    }
}
