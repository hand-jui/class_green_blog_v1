package com.tenco.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tenco.blog.model.User;

//@NoRepositoryBean  // 여기서는 생략 가능한 이유 - JPARepository 를 상속 받기 때문에
public interface UserRepository extends JpaRepository<User, Integer> {
//	select, selectAll, insertm updatem delete 등

}
