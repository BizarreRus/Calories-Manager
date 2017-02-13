package com.bizarrerus.service;

import com.bizarrerus.model.User;
import com.bizarrerus.to.UserTo;
import com.bizarrerus.util.exception.NotFoundException;

import java.util.List;

public interface UserService {

    User save(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    void update(UserTo user);

    List<User> getAll();

    void update(User user);

    void evictCache();

    void enable(int id, boolean enable);

    User getWithMeals(int id);
}
