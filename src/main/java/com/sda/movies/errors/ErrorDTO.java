package com.sda.movies.errors;

import java.time.LocalDateTime;

public class ErrorDTO {

    private String reason;

    private LocalDateTime time = LocalDateTime.now();

    public ErrorDTO(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
