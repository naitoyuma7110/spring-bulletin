package checkboard.me.checkboard.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// @Component:DIコンテナによって依存性の管理を行われるコンポーネントである
@Component
public class BatchProcessing {
    private static final Logger logger = LoggerFactory.getLogger(BatchProcessing.class);

//  @Autowired:DIからCountインスタンスを呼び出しcount変数に注入
    @Autowired
    Count count;

    public BatchProcessing(){

        logger.info(String.valueOf(count.getCount()));
//        logger.info("HELLO");

    }

}
