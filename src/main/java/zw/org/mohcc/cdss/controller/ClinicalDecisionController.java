package zw.org.mohcc.cdss.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.org.mohcc.cdss.model.dto.ClinicalDecision;
import zw.org.mohcc.cdss.service.ClinicalDecisionService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/clinical-decisions")
@Tag(name = "Clinical Decision Support", description = "HIV Clinical Decision APIs")
public class ClinicalDecisionController {
    private final ClinicalDecisionService clinicalDecisionService;
    private static final Logger logger = LoggerFactory.getLogger(ClinicalDecisionController.class);

    public ClinicalDecisionController(ClinicalDecisionService clinicalDecisionService) {
        this.clinicalDecisionService = clinicalDecisionService;
    }

   @GetMapping("/patient/{personId}/art-data")
    public ResponseEntity<List<Map<String, Object>>> processPatientData(@PathVariable String personId) {
       List<Map<String, Object>> processData = clinicalDecisionService.processArtData(personId);
       return ResponseEntity.ok(processData);
   }

   @GetMapping("/patient/{personId}/assessment")
    public ResponseEntity<List<ClinicalDecision>> processAssessmentData(@PathVariable String personId) {
       logger.info("Evaluating clinical decisions for patient: {}", personId);

       List<ClinicalDecision> decisions = clinicalDecisionService.evaluatePatientRules(personId);

       // Log decisions for debugging/monitoring
       decisions.forEach(decision ->
               logger.info("Decision for patient {}: {} ({})",
                       personId,
                       decision.getRecommendation(),
                       decision.getUrgency())
       );

       if (decisions.isEmpty()) {
           logger.warn("No clinical decisions generated for patient: {}", personId);
           return ResponseEntity.noContent().build();
       }

       return ResponseEntity.ok(decisions);
   }
   }
