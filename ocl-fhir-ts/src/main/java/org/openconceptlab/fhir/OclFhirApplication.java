package org.openconceptlab.fhir;

import org.openconceptlab.fhir.config.Config;
import org.openconceptlab.fhir.controller.OclFhirController;
import org.openconceptlab.fhir.interceptor.OclFhirLoggingInterceptor;
import org.openconceptlab.fhir.model.BaseOclEntity;
import org.openconceptlab.fhir.provider.CodeSystemResourceProvider;
import org.openconceptlab.fhir.repository.BaseOclRepository;
import org.openconceptlab.fhir.repository.ConceptRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ServletComponentScan
@SpringBootApplication
@ComponentScan(basePackageClasses = {
        Config.class,
        OclFhirController.class,
        OclFhirLoggingInterceptor.class,
        BaseOclEntity.class,
        BaseOclRepository.class,
        CodeSystemResourceProvider.class,
        OclFhirRestfulServer.class
})
@EnableJpaRepositories(basePackageClasses = {ConceptRepository.class})
@EntityScan(basePackageClasses = {BaseOclEntity.class})
public class OclFhirApplication {
    public static void main(String[] args) {
        SpringApplication.run(OclFhirApplication.class,args);
    }
}