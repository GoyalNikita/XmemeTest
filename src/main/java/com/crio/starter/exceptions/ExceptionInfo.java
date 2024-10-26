package com.crio.starter.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ExceptionInfo {
    private String messageString = "Something went wrong. Please try again";

    public ExceptionInfo(String messageString) {
        this.messageString = messageString;
    }
}
