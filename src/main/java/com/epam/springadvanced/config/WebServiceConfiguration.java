package com.epam.springadvanced.config;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;

import java.io.IOException;

@EnableWs
    @Configuration
    public class WebServiceConfiguration extends WsConfigurerAdapter {
        @Bean
        public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
            MessageDispatcherServlet servlet = new MessageDispatcherServlet();
            servlet.setApplicationContext(applicationContext);
            servlet.setTransformWsdlLocations(true);
            return new ServletRegistrationBean(servlet, "/ws/*");
        }

        @Bean(name = "spadvance")
        public DefaultWsdl11Definition defaultWsdl11Definition(CommonsXsdSchemaCollection spadvanceSchemas) {
            DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
            wsdl11Definition.setPortTypeName("SpAdvPort");
            wsdl11Definition.setLocationUri("/ws");
            wsdl11Definition.setTargetNamespace("http://epam.com/spadvance-web-service");
            wsdl11Definition.setSchemaCollection(spadvanceSchemas);
            return wsdl11Definition;
        }

        @Bean
        public CommonsXsdSchemaCollection spadvanceSchemas() throws IOException {
            CommonsXsdSchemaCollection schemaCollection = new CommonsXsdSchemaCollection();
            Resource eventResource = new ClassPathResource("\\schemas\\event.xsd");
            Resource userResource = new ClassPathResource("\\schemas\\user.xsd");
            schemaCollection.setXsds(new Resource[]{eventResource, userResource});
            return  schemaCollection;
        }

    }
