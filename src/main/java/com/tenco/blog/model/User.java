package com.tenco.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data // !! (object Mapper 가) 파싱처리 할때 setter 반드시 있어야 한다.
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length = 30)
	private String username;

	@NotBlank // null, "" - 빈문자열을 잡겠다
	@Column(nullable = false, length = 100)
	private String password;

	@NotBlank
	@Column(nullable = false, length = 50)
	private String email;

	@ColumnDefault("'user'") // 문자열 타입 명시는 큰따옴표 안에 작은따옴표해줘야함
	private String role; // user, admin, manager

	@CreationTimestamp // 자동 시간 입력 == now()
	private Timestamp createdDate;
}
