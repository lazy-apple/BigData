package consumer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 字符串工具类
 */
public class StringUtil {

    /**
     * |是正则表示特殊字符
     */
    private static final String token = "\\|\\|\\|" ;

    /**
     * 切割单行日志
     */
    public static String[] splitLog(String log){
        String[] arr = log.split(token);
        return arr ;
    }

    /***
     * 主机名
     * @param arr
     * @return
     */
    public static String getHostname(String[] arr){
        return arr[0];
    }

    /**
     * 根据日志名获取日志，再转成自己想要的格式
     *返回 2017/02/28/12/12
     */
    public static String formatYyyyMmDdHhMi(String[] arr){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", Locale.US);
            Date d = sdf.parse(arr[3].split(" ")[0]);
            System.out.println(d);
            SimpleDateFormat localSDF = new SimpleDateFormat("yyyy/MM/dd/HH/mm", Locale.US);
            return localSDF.format(d);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null ;
    }
}
