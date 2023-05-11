package com.tenco.blog.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<T> {

	private HttpStatus status;

//	고민!!  -> 같은 변수로 다른 자료형
	private T data;

}
