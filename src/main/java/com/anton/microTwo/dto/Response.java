package com.anton.microTwo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author by nadeeshan_fdz
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {

    private String msg;

    private int status;

    private Object data;

//    List<T> list;
}
