package com.flare.response;

import com.flare.bean.Result;
import com.flare.bean.ResultCode;

/**
 * @author wangkui
 */
public class ResponseResult {

    private static final String DEFAULT_SUCCESS_MESSAGE = "操作成功！";
    private static final String DEFAULT_SUCCESS_DELETE_MESSAGE = "删除成功";
    private static final String DEFAULT_SUCCESS_UPDATE_MESSAGE = "修改成功";
    private static final String DEFAULT_FAIL_DELETE_MESSAGE = "删除失败";
    private static final String DEFAULT_FAIL_UPDATE_MESSAGE = "修改失败";

    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }
    public static Result genSuccessResult(String message) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(message);
    }

    public static Result genSuccessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }

    public static Result genFailResult(String message, ResultCode resultCode) {
        return new Result()
                .setCode(resultCode)
                .setMessage(message);
    }

    public static Result genNotLogin() {
        return new Result()
                .setCode(ResultCode.UNAUTHORIZED)
                .setMessage("用户未登录！");
    }

    public static Result genPermissions() {
        return new Result()
                .setCode(ResultCode.PERMISSIONS)
                .setMessage("用户权限不足！");
    }

    public static Result genFailDeleteResult() {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(DEFAULT_FAIL_DELETE_MESSAGE);
    }

    public static Result genFailUpdateResult() {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(DEFAULT_FAIL_UPDATE_MESSAGE);
    }

    public static Result genSuccessDeleteResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_DELETE_MESSAGE);
    }

    public static Result genSuccessUpdateResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_UPDATE_MESSAGE);
    }

    public static Result genSuccessResult(Object data, String message) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(message)
                .setData(data);
    }
}
