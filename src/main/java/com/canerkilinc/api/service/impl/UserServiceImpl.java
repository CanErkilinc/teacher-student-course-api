package com.canerkilinc.api.service.impl;

import com.canerkilinc.api.common.GeneralException;
import com.canerkilinc.api.entity.User;
import com.canerkilinc.api.entity.enums.Role;
import com.canerkilinc.api.repository.IUserRepository;
import com.canerkilinc.api.service.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        if (user.getId() == null ) {
            if (user.getIdentityNo() == null || user.getIdentityNo().length() != 11){
                throw  new GeneralException("Invalid identity no!");
            }
            if (userRepository.existsByIdentityNo(user.getIdentityNo())) {
                throw  new GeneralException("Identity no already exists!");
            }
        }

        return userRepository.save(user);
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow(()->new GeneralException("User not found!"));
        }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void delete(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new GeneralException("User not found!");
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getUsersByRole(Role role) {
        return userRepository.findAllByRole(role);
    }

    @Override
    public List<User> getPotentialUsers(List<Integer> ids) {
        if (ids.isEmpty()) {
            return  getUsersByRole(Role.STUDENT);
        }
        return userRepository.findAllByRoleAndIdIsNotIn(Role.STUDENT,ids);
    }
}

