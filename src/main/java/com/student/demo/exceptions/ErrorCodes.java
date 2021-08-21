package com.aai.firstproject.exceptions;

public enum ErrorCodes {

    NoRecordExist(1),
    RecordNotFound(2),

    RecordNotAdded(3),
    RecordNotUpdated(4),
    RecordNotDeleted(5),
    RecordAlreadyExist(6),

    InvalidRecordId(11),
    InvalidUuid(12),
    InvalidParameter(13),
    InsufficientData(14),
    InvalidCredentials(15),
    UnauthorisedAccess(16),


    OperationProhibited(51),
    DeprecatedAPI(71),

    ServiceDown(100),

    Error(1000)
    ;

    int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
