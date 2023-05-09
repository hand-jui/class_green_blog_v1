package com.tenco.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;

@Entity // 설정해야 인식
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 100)
	private String title;

	@Lob // 대용량 데이터 설정
	private String content;
	
	@ColumnDefault("0")
	private int count;

//	Board 와 User 의 관계는 N : 1
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
//	리플에 대한 정보
//	Board 정보를 가지고 올 때 리플 정보도 가지고 와야한다면
//	Board 와 Reply 의 관계는 1: N 관계
	@OneToMany(mappedBy = "board", fetch = FetchType.LAZY)  // 기본값
	private List<Reply> reply;
//	주의 : Board 테이블에 reply_id 컬럼이 필요한가(X)
//	-> mappedBy 설정하면 board 테이블에 컬럼이 생성되지 않는다.
//	object 가 생성될 때 즉, 데이터를 가지고 올 때 알아서 join 처리해서 데이터만 가지고 와라 라는 의미

	private Timestamp createdDate;

}
