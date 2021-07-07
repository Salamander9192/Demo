package org.example.fmut.guard.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * @classname: HttpUrlConnHelper
 * @description:
 * @author: jiadongrui
 * @create: 2021-07-07 15:54
 **/
final public class HttpUrlConnHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUrlConnHelper.class);

    private static final Charset CHARSET = Charset.defaultCharset();

    private static final String HTTPS_PREFIX = "htts://";

    public static String httpGet(String urlStr){
        LOGGER.info("access url [{}] to fetch json" , urlStr);
        try {
            URL url = new URL(urlStr);
            if(urlStr.toLowerCase().startsWith(HTTPS_PREFIX)){
                throw new RuntimeException("not support https");
            }
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            String data = readFromConn(conn);
            LOGGER.info("req recv :[{}]",data);
            return data;
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String readFromConn(HttpURLConnection conn){
        try {
            InputStream is = conn.getInputStream();
            InputStreamReader ir = new InputStreamReader(is, CHARSET);
            BufferedReader bufferedReader = new BufferedReader(ir);
            StringBuilder builder = new StringBuilder();
            String line;
            while(true){
                line = bufferedReader.readLine();
                if(line == null){
                    break;
                }
                builder.append(line);
            }
            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
