package com.socnet.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@ConfigurationProperties(prefix = "socnet")
@Getter
@Setter
public class AppConfiguration {
    private String dbUrl;
    private String dbName;
    private String dbPass;
}
