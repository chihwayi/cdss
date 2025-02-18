package zw.org.mohcc.cdss.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.org.mohcc.cdss.model.dto.ApiResponse;
import zw.org.mohcc.cdss.model.dto.PatientAssessment;
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

    @GetMapping("/patient/{personId}/assessment")
    public ResponseEntity<?> getPatientAssessment(@PathVariable String personId) {
        try {
            logger.info("Retrieving patient assessment for personId: {}", personId);

            PatientAssessment assessment = clinicalDecisionService.evaluatePatient(personId);

            if (assessment == null) {
                logger.warn("No assessment found for personId: {}", personId);
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse(false, "Patient assessment not found"));
            }

            return ResponseEntity.ok(new ApiResponse(true, "Patient assessment retrieved successfully", assessment));

        } catch (Exception e) {
            logger.error("Error retrieving patient assessment for personId: {}", personId, e);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error retrieving patient assessment: " + e.getMessage()));
        }
    }

   @GetMapping("/patient/{personId}/art-data")
    public ResponseEntity<List<Map<String, Object>>> processPatientData(@PathVariable String personId) {
       List<Map<String, Object>> processData = clinicalDecisionService.processArtData(personId);
       return ResponseEntity.ok(processData);
   }

}