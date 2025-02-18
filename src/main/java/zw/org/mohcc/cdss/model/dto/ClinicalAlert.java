package zw.org.mohcc.cdss.model.dto;

import lombok.Data;

@Data
public class ClinicalAlert {
    private String code;
    private String message;
    private String action;

    public ClinicalAlert() {
    }

    public ClinicalAlert(String code, String message, String action) {
        this.code = code;
        this.message = message;
        this.action = action;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
