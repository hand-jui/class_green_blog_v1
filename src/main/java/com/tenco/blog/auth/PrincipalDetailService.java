package com.tenco.blog.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tenco.blog.model.User;
import com.tenco.blog.repository.UserRepository;

@Service
public class PrincipalDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
//		유저 이름, 비밀번호 같이 받게 설계
//		!! 시큐리티는 비밀번호 확인하지 않음 -> DB 사용자가 계정이 있는지만 먼저 검사한다.
		User principal = userRepository.findByUsername(username).orElseThrow(()->{
			return new UsernameNotFoundException("해당 유저를 찾을 수 없습니다.");
		});
		
//		시큐리티 세션 영역에 user 정보 저장
		return new PrincipalDetail(principal);
	}

}
