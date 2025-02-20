package zw.org.mohcc.cdss.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import zw.org.mohcc.cdss.model.dto.ClinicalDecision;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DroolsConfig {

    private static final Logger logger = LoggerFactory.getLogger(DroolsConfig.class);

    @Value("${drools.rules.path}")
    private String rulesPath;

    @Bean
    public KieContainer kieContainer() throws Exception {
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();

        // Add kmodule.xml
        kieFileSystem.write("src/main/resources/META-INF/kmodule.xml",
                kieServices.getResources().newClassPathResource("META-INF/kmodule.xml"));

        // Load rules
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:" + rulesPath + "/**/*.drl");

        logger.info("Found {} rule files in {}", resources.length, rulesPath);

        for (Resource resource : resources) {
            String path = "src/main/resources/" + rulesPath + "/" + resource.getFilename();
            logger.info("Loading rule file: {} as {}", resource.getFilename(), path);

            // Read and log the content
            String content = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            logger.debug("Rule content:\n{}", content);

            kieFileSystem.write(path, content);
        }

        // Build the KieModule
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll();
        Results results = kieBuilder.getResults();

        if (results.hasMessages(Message.Level.ERROR)) {
            logger.error("Drools compilation errors: {}", results.getMessages());
            throw new RuntimeException("Drools compilation errors: " + results.getMessages());
        }

        KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());

        // Test creating a session
        try (KieSession testSession = kieContainer.newKieSession()) {
            // Try to set the global to verify it's recognized
            try {
                List<ClinicalDecision> testDecisions = new ArrayList<>();
                testSession.setGlobal("decisions", testDecisions);
                logger.info("Successfully set global 'decisions' in test session");
            } catch (RuntimeException e) {
                logger.error("Failed to set global 'decisions': {}", e.getMessage());
                throw e;
            }
        }

        return kieContainer;
    }
}