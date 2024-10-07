package com.example.dummyjson.config;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class MessagePropertiesConfig extends AcceptHeaderLocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        List<Locale> locs = Arrays.asList(new Locale("en", "US"), new Locale("pt", "BR"));
        String headersLang = request.getHeader("Accept-Language");
        
        return headersLang == null || headersLang.isEmpty() ? Locale.getDefault()
                : Locale.lookup(Locale.LanguageRange.parse(headersLang), locs);
    }

    @Bean
    ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("application-messages/message");
        source.setDefaultEncoding(StandardCharsets.UTF_8.name());
        source.setDefaultLocale(new Locale("en", "US"));
       
        return source;
    }
}