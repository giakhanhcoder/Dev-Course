package com.develop.devcourse.domain.security.service;

import com.develop.devcourse.domain.security.model.Role;
import com.develop.devcourse.domain.security.model.RoleName;
import org.springframework.stereotype.Service;

public interface RoleServices {

    Role findRoleByRoleName(RoleName roleName);
}
