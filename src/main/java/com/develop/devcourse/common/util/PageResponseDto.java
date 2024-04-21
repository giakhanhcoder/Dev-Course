package com.develop.devcourse.common.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResponseDto <T>{
    private List<T> data;
    private Integer totalPage;
    private Integer pageNumber;
    private Integer size;
    private String sort;
}
