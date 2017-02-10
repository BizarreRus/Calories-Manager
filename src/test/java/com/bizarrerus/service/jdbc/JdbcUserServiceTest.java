package com.bizarrerus.service.jdbc;

import org.springframework.test.context.ActiveProfiles;
import com.bizarrerus.service.AbstractUserServiceTest;

import static com.bizarrerus.Profiles.JDBC;

@ActiveProfiles(JDBC)
public class JdbcUserServiceTest extends AbstractUserServiceTest {
}