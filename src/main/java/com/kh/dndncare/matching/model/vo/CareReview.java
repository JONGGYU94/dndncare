package com.kh.dndncare.matching.model.vo;

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
public class CareReview {
	private int reviewNo;
	private int ptNo;
	private int matNo;
	private String reviewContent;
	private int reviewScore;
	private Date reviewCreateDate;
	private Date reviewUpdateDate;
	private String reviewStatus;
	private String ptName;
	private String memberName;
	private String careIntro;
	
	// 통계용
	private String month;
	private int sumScore;
	private double avgScore;
	private int countReview;
	private int sumMoney; 
	
}
