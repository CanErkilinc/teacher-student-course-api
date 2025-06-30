package com.canerkilinc.api.service;

import com.canerkilinc.api.entity.User;
import com.canerkilinc.api.entity.enums.Role;

import java.util.List;

public interface IUserService extends IService<User> {
    List<User>getUsersByRole(Role role);
    List<User>getPotentialUsers(List<Integer> ids);
}
