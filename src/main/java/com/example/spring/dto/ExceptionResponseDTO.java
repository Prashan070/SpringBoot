package com.example.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionResponseDTO {
    private String apiPath;
    private HttpStatus statuscode;
    private String errorMessage;
    private LocalDateTime localDateTime;

    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }

    public HttpStatus getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(HttpStatus statuscode) {
        this.statuscode = statuscode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public ExceptionResponseDTO(String apiPath, HttpStatus statuscode, String errorMessage, LocalDateTime localDateTime) {
        this.apiPath = apiPath;
        this.statuscode = statuscode;
        this.errorMessage = errorMessage;
        this.localDateTime = localDateTime;
    }
}
