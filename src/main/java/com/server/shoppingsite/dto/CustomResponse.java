package com.server.shoppingsite.dto;

import com.server.shoppingsite.exception.CustomExceptionStatus;

public class CustomResponse {
    public static CommonResponse getSuccessResponse() {
        CommonResponse response = new CommonResponse();
        response.setIsSuccess(true);
        response.setCode(1000);
        response.setMessage("請求成功");
        return response;
    }

    public static <T> DataResponse<T> getDataResponse(T data) {
        DataResponse<T> response = new DataResponse<>();
        response.setIsSuccess(true);
        response.setCode(1000);
        response.setMessage("請求成功");
        response.setData(data);
        return response;
    }

    public static CommonResponse getExceptionResponse(CustomExceptionStatus status) {
        CommonResponse response = new CommonResponse();
        response.setIsSuccess(status.isSuccess());
        response.setCode(status.getCode());
        response.setMessage(status.getMessage());
        return response;
    }
}
