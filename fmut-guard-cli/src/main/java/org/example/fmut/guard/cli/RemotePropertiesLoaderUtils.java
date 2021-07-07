package org.example.fmut.guard.cli;

import com.alibaba.fastjson.JSON;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * @classname: RemotePropertiesLoaderUtils
 * @description:
 * @author: jiadongrui
 * @create: 2021-07-07 16:33
 **/
public class RemotePropertiesLoaderUtils {

    public static Properties loadProperties(EncodedResource resource) throws IOException {
        Properties props = new Properties();
        PropertiesLoaderUtils.fillProperties(props,resource);
        return loadRemoteProperties(props);
    }

    private static Properties loadRemoteProperties(Properties props){
        String remotePropUrl = props.getProperty("remotePropUrl");
        String nodeId = props.getProperty("nodeId");
        String propertyFilesNames = props.getProperty("propertyFilesNames");
        String url = remotePropUrl + "?nodeId=" + nodeId
                + "&propFiles=" + propertyFilesNames;
        String jsonString = HttpUrlConnHelper.httpGet(url);
        Properties remoteProperties = JSON.parseObject(jsonString, Properties.class);
        return remoteProperties;
    }
}
