package br.com.ismael.app.movaction.services.infrastructure;

public class ResponseError {

    private int mErrorMessageResId;

    private Integer mErrorCode;

    private String mErrorMessage;

    private Exception mException;


    public ResponseError(String errorMessage) {
        mErrorMessage = errorMessage;
    }

    public ResponseError(int errorMessageResId) {
        mErrorMessageResId = errorMessageResId;
    }

    public Integer getErrorCode() {
        return mErrorCode;
    }

    public void setErrorCode(Integer errorCode) {
        mErrorCode = errorCode;
    }

    public String getErrorMessage() {
        return mErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        mErrorMessage = errorMessage;
    }

    public Exception getException() {
        return mException;
    }

    public void setException(Exception exception) {
        mException = exception;
    }

    public int getErrorMessageResId() {
        return mErrorMessageResId;
    }
}

