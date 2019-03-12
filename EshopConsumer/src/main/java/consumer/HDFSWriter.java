package consumer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 *hdfs写入器
 */
public class HDFSWriter {

    /**
     * 写入log到hdfs文件
     * hdfs://mycluster/eshop/2017/02/28/s201.log | s202.log | s203.log
     */
    public void writeLog2HDFS(String path, byte[] log) {
        try {
            Configuration conf = new Configuration();
            FileSystem fs = FileSystem.get(conf);
            Path p = new Path(path);
            FSDataOutputStream out = fs.append(p);
            out.write(log);
            out.write("\r\n".getBytes());
            out.hsync();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
