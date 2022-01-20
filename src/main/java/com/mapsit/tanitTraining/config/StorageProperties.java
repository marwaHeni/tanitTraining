package com.mapsit.tanitTraining.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "upload")
public class StorageProperties {

    private String path;
    private String url;
    private String urlSchema;
    private String urlSchemaDatabase;



    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlSchema() {
        return urlSchema;
    }

    public void setUrlSchema(String urlSchema) {
        this.urlSchema = urlSchema;
    }

    public String getUrlSchemaDatabase() {
        return urlSchemaDatabase;
    }

    public void setUrlSchemaDatabase(String urlSchemaDatabase) {
        this.urlSchemaDatabase = urlSchemaDatabase;
    }
}
