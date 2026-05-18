package com.kragy.vo.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private String code;
    private String message;
    private T data;

    public static <T> Result<T> success() {
        return new Result<>("200", "success", null);
    }

    public static <T> Result<T> success(String msg) {
        return new Result<>("200", msg, null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>("200", "success", data);
    }

    public static <T> Result<T> error() {
        return new Result<>("500", "error", null);
    }

    public static <T> Result<T> error(String msg) {
        return new Result<>("500", msg, null);
    }
}
