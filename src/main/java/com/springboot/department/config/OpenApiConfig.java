package com.springboot.department.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//OPENAPI
@Configuration
public class OpenApiConfig {

    @Value("${openapi.banner.title}")
    private String title;

    @Value("${openapi.banner.description}")
    private String description;

    @Value("${openapi.banner.version}")
    private String version;

    @Value("${openapi.server.url}")
    private String url;

    @Bean
    public OpenAPI customOpenAPI(){
//        List<String> servers = Arrays.asList(StringUtils.split(url,"|"));
//        List<Server> serverList =servers.stream().map(server->new Server().url(server)).collect(Collectors.toList());
        return new OpenAPI()
                .components(new Components())
                .addServersItem(new Server().url(url))
//                .servers(serverList)
                .info( new Info()
                        .title(title)
                        .description(description)
                        .version(version));
    }


}
