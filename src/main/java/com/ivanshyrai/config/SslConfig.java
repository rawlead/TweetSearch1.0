package com.ivanshyrai.config;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

// connection through
//http(8080) and https(8443) protocols

//@Configuration
public class SslConfig {

//    @Bean
    public EmbeddedServletContainerFactory servletContainer() throws IOException {
        TomcatEmbeddedServletContainerFactory tomcat =
                new TomcatEmbeddedServletContainerFactory();
        tomcat.addAdditionalTomcatConnectors(createSslConnector());
        return tomcat;
    }

    private Connector createSslConnector() throws IOException {
        Connector connector = new Connector(Http11NioProtocol.class.getName());
        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
        connector.setPort(8443);
        connector.setSecure(true);
        connector.setScheme("https");
        protocol.setSSLEnabled(true);
        protocol.setKeyAlias("masterproject");
        protocol.setKeystorePass("1-7");
        protocol.setKeyPass("st-7");
        protocol.setKeystoreFile(
                new ClassPathResource("tomcat.keystore").getFile().getAbsolutePath());
        //keytool -genkey -alias masterspring -keyalg RSA -keystore src/main/resources/tomcat.keystore
        protocol.setSSLProtocol("TLSv1.2");
        return connector;
    }
}
