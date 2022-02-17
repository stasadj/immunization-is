package com.immunization.common.config;

import net.sf.saxon.TransformerFactoryImpl;
import org.apache.fop.apps.FopFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.xml.sax.SAXException;

import javax.xml.transform.TransformerFactory;
import java.io.IOException;

@Configuration
public class TransformerConfig {
    @Bean
    public TransformerFactory transformerFactory() {
        return new TransformerFactoryImpl();
    }

    @Bean
    public FopFactory fopFactory() throws IOException, SAXException {
        return FopFactory.newInstance(new ClassPathResource("to-pdf/fop.xconf").getFile());
    }
}
