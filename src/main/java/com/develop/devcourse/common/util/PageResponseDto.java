package com.develop.devcourse.common.util;

import lombok.*;

import java.util.List;

@Getter
@Setter
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
