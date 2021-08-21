package com.aai.firstproject.exceptions;

public class CodeException extends Exception {

    private final ErrorCodes code;

    public CodeException(ErrorCodes code) {
        super();
        this.code = code;
    }

    public CodeException(String message, Throwable cause, ErrorCodes code) {
        super(message, cause);
        this.code = code;
    }

    public CodeException(String message, ErrorCodes code) {
        super(message);
        this.code = code;
    }

    public CodeException(Throwable cause, ErrorCodes code) {
        super(cause);
        this.code = code;
    }

    public ErrorCodes getCode() {
        return this.code;
    }
}