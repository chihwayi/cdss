package zw.org.mohcc.cdss.model.dto;

import java.time.LocalDate;

public class Investigation {
    private String type;
    private String result;
    private LocalDate date;

    public Investigation() {
    }

    public Investigation(String type, String result, LocalDate date) {
        this.type = type;
        this.result = result;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
