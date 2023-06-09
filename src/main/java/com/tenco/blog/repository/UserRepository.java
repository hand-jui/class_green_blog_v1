package com.tenco.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tenco.blog.model.User;

//@NoRepositoryBean  // 여기서는 생략 가능한 이유 - JPARepository 를 상속 받기 때문에
public interface UserRepository extends JpaRepository<User, Integer> {
//	select, selectAll, insertm updatem delete 등

//	Spring JPA 네이밍 전략
//	메서드 이름으로 JPA가 쿼리를 만들어 준다 -> 규칙을 지켜서 작성한다면
//	SELECT * FROM user WHERE username = ? AND password = ?
	User findByUsernameAndPassword(String username, String password);

//	두번째 방법
	@Query(value = " SELECT * FROM user WHERE username = ?1 AND password = ?2 ", nativeQuery = true)
	User login(String username, String password);
	
//	SELECT * FROM user WHERE username = ?
	Optional<User> findByUsername(String username);

}
