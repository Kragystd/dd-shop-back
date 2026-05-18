package com.kragy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDto<T> {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
    @JsonProperty("condition")
    private T params;
}

