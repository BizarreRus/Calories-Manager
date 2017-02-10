package com.bizarrerus.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.bizarrerus.model.User;
import com.bizarrerus.service.UserService;

import java.util.List;

import static com.bizarrerus.util.ValidationUtil.checkNew;
import static com.bizarrerus.util.ValidationUtil.checkIdConsistent;

public abstract class AbstractUserController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService service;

    public List<User> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public User get(int id) {
        log.info("get " + id);
        return service.get(id);
    }

    public User create(User user) {
        checkNew(user);
        log.info("create " + user);
        return service.save(user);
    }

    public void delete(int id) {
        log.info("delete " + id);
        service.delete(id);
    }

    public void update(User user, int id) {
        checkIdConsistent(user, id);
        log.info("update " + user);
        service.update(user);
    }

    public User getByMail(String email) {
        log.info("getByEmail " + email);
        return service.getByEmail(email);
    }
}
