package com.acmebank.accountmanager.service.impl;

import com.acmebank.accountmanager.mapper.AcmebUserMapper;
import com.acmebank.accountmanager.model.domain.AcmebUser;
import com.acmebank.accountmanager.model.dto.UserDetailsImpl;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AcmebUserMapper acmebUserMapper;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AcmebUser user = Optional.ofNullable(acmebUserMapper.findByUsername(username))
            .orElseThrow(
                () -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }
}
