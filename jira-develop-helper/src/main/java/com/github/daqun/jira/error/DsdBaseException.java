package com.github.daqun.jira.error;

import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * @Description
 * @Date 2019/4/13 16:31
 * @Created by chenq
 */
public abstract class DsdBaseException extends Exception implements CommonError {

    protected CommonError commonError;

    public DsdBaseException() {
        super();
        this.commonError = getError();
    }

    public DsdBaseException(String message) {
        this();
        this.setErrMsg(message);
    }

    @Override
    public Response.Status getErrStatus() {
        return this.commonError.getErrStatus();
    }

    @Override
    public int getErrCode() {
        return this.commonError.getErrCode();
    }
    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
    }

    @Override
    public Map getErrorMap() {
        return commonError.getErrorMap();
    }
}
