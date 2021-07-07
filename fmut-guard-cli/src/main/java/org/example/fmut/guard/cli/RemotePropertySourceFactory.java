package org.example.fmut.guard.cli;

import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;

/**
 * @classname: RemotePropertySourceFactory
 * @description:
 * @author: jiadongrui
 * @create: 2021-07-07 16:55
 **/
public class RemotePropertySourceFactory implements PropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String s, EncodedResource encodedResource) throws IOException {
        return new RemoteResourcePropertySource(encodedResource);
    }
}
