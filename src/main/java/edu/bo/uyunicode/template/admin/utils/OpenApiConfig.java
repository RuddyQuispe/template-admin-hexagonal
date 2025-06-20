package edu.bo.uyunicode.template.admin.utils;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Administration Template API",
                version = "1.0",
                description = "WebServices available Template Administration"))
public class OpenApiConfig {
}
