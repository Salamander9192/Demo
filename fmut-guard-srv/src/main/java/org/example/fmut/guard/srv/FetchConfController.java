package org.example.fmut.guard.srv;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @classname: FetchConfController
 * @description:
 * @author: jiadongrui
 * @create: 2021-07-07 11:02
 **/
@RestController
public class FetchConfController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FetchConfController.class);

    @Value("${BASE_PROP_DIR}")
    private String basePropDir;

    /**
     * 读取本机配置文件并返回json格式
     * @param nodeId
     * @param propFiles
     * @return
     */
//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping(value = "/fetchConf.action")
    public String fetchConf(@RequestParam("nodeId")String nodeId,
                            @RequestParam("propFiles")String propFiles){
        LOGGER.info("node[{}] fetch config : [{}]", nodeId, propFiles);
        return toJson(propFiles, nodeId);
    }

    private String composeDir(String nodeId){
        return basePropDir + File.separator + nodeId;
    }

    private String toJson(String propFiles, String nodeId){
        List<Properties> propertiesList = new ArrayList<>();
        String[] fileNames = propFiles.split(";");
        for(String fileName : fileNames){
            LOGGER.info("process file [{}]",fileName);
            searchFilesByPropertyFileName(composeDir(nodeId),fileName,propertiesList);
        }
        return String.valueOf(JSON.toJSON(mergeProperties(propertiesList)));
    }
    /**
    * @Description : 在路径下通过fileName查找，加载后构造成Properties对象
    * @Author : jiadongrui
    * @Date : 2021/7/7 15:34
    */
    private static void searchFilesByPropertyFileName(String localPropertyFilesPath, String fileName, List<Properties> propertiesList){
        File fileDir = new File(localPropertyFilesPath);
        File[] files = fileDir.listFiles();
        for(File file : files){
            if(file.isDirectory()){
                searchFilesByPropertyFileName(file.getPath(),fileName,propertiesList);
            }else{
                if(fileName.equals(file.getName())){
                    Properties properties = new Properties();
                    try {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file.getPath()));
                        properties.load(bufferedInputStream);
                    } catch (Exception e) {
                        LOGGER.error("config path error",e);
                    }
                    propertiesList.add(properties);
                }
            }
        }
    }

    /**
    * @Description : 合并多个Properties为一个，如果有重复的key会执行覆盖
    * @Author : jiadongrui
    * @Date : 2021/7/7 15:34
    */
    private static Properties mergeProperties(List<Properties> propertiesList){
        Properties properties = new Properties();
        for(Properties singleProp : propertiesList){
            CollectionUtils.mergePropertiesIntoMap(singleProp,properties);
        }
        return properties;
    }

}
