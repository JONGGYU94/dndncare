package com.kh.dndncare.member.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Matching {
	private int matNo;//MAT_NO
	private Date beginDt;//BEGIN_DT
	private Date endDt;//END_DT
	private int money;//MONEY
	private String matConfirm;//MAT_CONFIRM
	private int matType;//MAT_TYPE
	private int hosptalNo;//HOSPTAL_NO
	private Date start; // 캘린더 API 이벤트를 지정하기 위한 필드
	private Date end; // 캘린더 API 이벤트를 지정하기 위한 필드
	
}
