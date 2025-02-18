package zw.org.mohcc.cdss.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Configuration
public class DroolsConfig {

    @Value("${drools.rules.path}")
    private String rulesPath;

    @Bean
    public KieContainer kieContainer() throws Exception {
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();

        // Load rules from classpath
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:" + rulesPath + "/**/*.drl");

        for (Resource resource : resources) {
            String path = resource.getFilename(); // Just use filename, not full path
            kieFileSystem.write(path, kieServices.getResources().newReaderResource(
                    new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)));
        }

        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();

        // Check for errors
        if (kieBuilder.getResults().hasMessages(Message.Level.ERROR)) {
            throw new RuntimeException("Drools compilation errors: " + kieBuilder.getResults().toString());
        }

        return kieServices.newKieContainer(kieBuilder.getKieModule().getReleaseId());
    }
}