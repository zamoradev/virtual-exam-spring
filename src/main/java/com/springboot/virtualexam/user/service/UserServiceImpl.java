package com.springboot.virtualexam.user.service;

import com.springboot.virtualexam.rol.data.IRolRepository;
import com.springboot.virtualexam.rol.data.RolEntity;
import com.springboot.virtualexam.rol.service.IRolService;
import com.springboot.virtualexam.user.data.IUserRepository;
import com.springboot.virtualexam.user.data.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;
    private final IRolService rolService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void save(String username, String rol) {
        RolEntity rolEntity = rolService.getByRolName(rol);
        String encryptedPassword = passwordEncoder.encode(username);

        UserEntity user = new UserEntity(username, encryptedPassword, rolEntity);

        userRepository.save(user);
    }

}
