package com.springboot.virtualexam.user.service;

import com.springboot.virtualexam.security.data.PrimaryUser;
import com.springboot.virtualexam.security.jwt.IUserDetailsService;
import com.springboot.virtualexam.user.data.IUserRepository;
import com.springboot.virtualexam.user.data.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAuthServiceImpl implements IUserDetailsService {
    private final IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User not found in the database.");
        }

        return PrimaryUser.build(user.getUsername(), user.getPassword(), user.getRol().getName());
    }
}
