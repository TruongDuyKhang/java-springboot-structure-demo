package com.khang.demo.exception;

public enum ErrorCode {
    USER_EXISTED(1002,"User existed"),
    UNCATEGORIZED_EXCEPTION(9999,"Uncategorized error"),
    USERNAME_INVALID(1003,"Username must be at least 3 characters"),
    INVALID_PASSWORD (1004, "Password must be at least 3 characters"),
    INVALID_KEY(1001,"Invalid message key"),
    USER_NOT_EXISTED(1005, "User not existed"),
    UNAUTHENTICATED(1006, "Unauthenticated")
    ;

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
