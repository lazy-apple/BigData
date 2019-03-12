package consumer;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.google.common.annotations.VisibleForTesting;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

/**
 * 原生数据消费者
 */
public class HDFSRawConsumer {
    private final ConsumerConnector consumerConn;
    private final String topic = "eshop";

    private static HDFSWriter writer = new HDFSWriter();

    public HDFSRawConsumer() {
        Properties props = new Properties();
        props.put("zookeeper.connect", "s202:2181");
        props.put("group.id", "es1");
        props.put("auto.offset.reset", "smallest");
        props.put("zookeeper.session.timeout.ms", "500");
        props.put("zookeeper.sync.time.ms", "250");
        props.put("auto.commit.interval.ms", "1000");
        // 创建消费者连接器
        consumerConn = Consumer.createJavaConsumerConnector(new ConsumerConfig(props));
    }

    /**
     * 处理log
     */
    public void processLog() {
        // 指定消费的主题
        Map<String, Integer> topicCount = new HashMap<String, Integer>();
        topicCount.put(topic, new Integer(1));

        // 消费的消息流
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerStreams = consumerConn.createMessageStreams(topicCount);

        // 的到指定主题的消息列表
        List<KafkaStream<byte[], byte[]>> streams = consumerStreams.get(topic);

        for (final KafkaStream stream : streams) {
            //
            ConsumerIterator<byte[], byte[]> consumerIte = stream.iterator();
            //迭代日志消息
            while (consumerIte.hasNext()) {
                byte[] msg = consumerIte.next().message();
                System.out.println(new String(msg));
//                String log = new String(msg) ;
//                String[] arr = StringUtil.splitLog(log);
//                if(arr == null || arr.length < 10){
//                    continue ;
//                }
//                //主机名
//                String hostname = StringUtil.getHostname(arr);
//                //日期串
//                String dateStr = StringUtil.formatYyyyMmDdHhMi(arr);
//                //path
//                String rawPath = "/user/centos/eshop/raw/" + dateStr + "/" + hostname + ".log";
//                //写入数据到hdfs
//                System.out.println(log);
//                writer.writeLog2HDFS(rawPath, msg);
            }
        }
    }

    public static void main(String[] args) {
        HDFSRawConsumer consumer = new HDFSRawConsumer();
        consumer.processLog();
    }

}
