package com.bizarrerus.web.user;

import com.bizarrerus.Profiles;
import com.bizarrerus.model.BaseEntity;
import com.bizarrerus.to.UserTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.bizarrerus.model.User;
import com.bizarrerus.service.UserService;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;

import javax.validation.ValidationException;
import java.util.Arrays;
import java.util.List;

import static com.bizarrerus.util.ValidationUtil.checkNew;
import static com.bizarrerus.util.ValidationUtil.checkIdConsistent;

public abstract class AbstractUserController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserService service;

    private boolean systemUserForbiddenModification;

    @Autowired
    public void setEnvironment(Environment environment) {
        systemUserForbiddenModification = Arrays.asList(environment.getActiveProfiles()).contains(Profiles.HEROKU);
    }

    public void checkModificationAllowed(Integer id) {
        if (systemUserForbiddenModification && id < BaseEntity.START_SEQ + 2) {
            throw new ValidationException(messageSource.getMessage("user.modificationRestriction", null, LocaleContextHolder.getLocale()));
        }
    }

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
        checkModificationAllowed(id);
        service.delete(id);
    }

    public void update(User user, int id) {
        log.info("update " + user);
        checkIdConsistent(user, id);
        checkModificationAllowed(id);
        service.update(user);
    }

    public void update(UserTo userTo, int id) {
        log.info("update " + userTo);
        checkIdConsistent(userTo, id);
        checkModificationAllowed(userTo.getId());
        service.update(userTo);
    }

    public User getByMail(String email) {
        log.info("getByEmail " + email);
        return service.getByEmail(email);
    }

    public void enable(int id, boolean enabled) {
        checkModificationAllowed(id);
        log.info((enabled ? "enable " : "disable ") + id);
        service.enable(id, enabled);
    }
}
