package org.example.fmut.guard.cli;

import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @classname: RemoteResourcePropertySource
 * @description:
 * @author: jiadongrui
 * @create: 2021-07-07 16:46
 **/
public class RemoteResourcePropertySource extends PropertiesPropertySource {

    public RemoteResourcePropertySource(EncodedResource resource) throws IOException {
        super(getNameForResource(resource.getResource()),RemotePropertiesLoaderUtils.loadProperties(resource));
    }

    private static String getNameForResource(Resource resource){
        String name = resource.getDescription();
        if(!StringUtils.hasText(name)){
            name = resource.getClass().getSimpleName() + "@" + System.identityHashCode(resource);
        }
        return name;
    }
}
