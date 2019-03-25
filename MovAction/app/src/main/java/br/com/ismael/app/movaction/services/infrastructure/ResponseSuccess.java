package br.com.ismael.app.movaction.services.infrastructure;

import java.util.List;

public class ResponseSuccess<T> {

    private T mDomain;

    private List<T> mDomainList;

    private String mSuccessMessage;

    public ResponseSuccess(T domain) {
        mDomain = domain;
    }

    public ResponseSuccess(List<T> domainList) {
        mDomainList = domainList;
    }

    public ResponseSuccess(String successMessage) {
        mSuccessMessage = successMessage;
    }

    public T getDomain() {
        return mDomain;
    }

    public void setDomain(T domain) {
        mDomain = domain;
    }

    public List<T> getDomainList() {
        return mDomainList;
    }

    public void setDomainList(List<T> domainList) {
        mDomainList = domainList;
    }

    public String getSuccessMessage() {
        return mSuccessMessage;
    }

    public void setSuccessMessage(String successMessage) {
        mSuccessMessage = successMessage;
    }
}
