package com.bizarrerus.service.jdbc;

import org.springframework.test.context.ActiveProfiles;
import com.bizarrerus.service.AbstractMealServiceTest;

import static com.bizarrerus.Profiles.JDBC;

@ActiveProfiles(JDBC)
public class JdbcMealServiceTest extends AbstractMealServiceTest {
}