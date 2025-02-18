package zw.org.mohcc.cdss.model.dto;

import zw.org.mohcc.cdss.model.enums.AlertSeverity;

public class TreatmentAlert {
    String alertCode;
    String message;
    AlertSeverity severity;
    String patientId;

    // Constructor

    public TreatmentAlert() {
    }

    public TreatmentAlert(String alertCode, String message,
                          AlertSeverity severity, String patientId) {
        this.alertCode = alertCode;
        this.message = message;
        this.severity = severity;
        this.patientId = patientId;
    }

    public String getAlertCode() {
        return alertCode;
    }

    public void setAlertCode(String alertCode) {
        this.alertCode = alertCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AlertSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(AlertSeverity severity) {
        this.severity = severity;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
