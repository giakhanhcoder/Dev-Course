package com.develop.devcourse.domain.security.servicesImpl;

import com.develop.devcourse.common.exeption.DomainException;
import com.develop.devcourse.domain.security.model.Role;
import com.develop.devcourse.domain.security.model.RoleName;
import com.develop.devcourse.domain.security.repository.RoleRepository;
import com.develop.devcourse.domain.security.service.RoleServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleServices {

    private final RoleRepository roleRepository;

    @Override
    public Role findRoleByRoleName(RoleName roleName) {
        return roleRepository.findByRoleName(roleName)
                .orElseThrow(() -> DomainException.notFound(roleName.name()));
    }
}
