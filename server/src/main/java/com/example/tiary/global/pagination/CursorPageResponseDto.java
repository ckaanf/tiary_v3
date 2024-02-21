package com.example.tiary.global.pagination;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Getter;

@Getter
public class CursorPageResponseDto<T> {
	private List<T> data;
	private Long cursor;
	private int size;

	public CursorPageResponseDto(List<T> data, int size,Long cursor) {
		this.data = data;
		this.size = size;
		this.cursor = cursor;
	}
}
