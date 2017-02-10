package com.bizarrerus.service.jpa;

import org.springframework.test.context.ActiveProfiles;
import com.bizarrerus.service.AbstractJpaUserServiceTest;

import static com.bizarrerus.Profiles.JPA;

@ActiveProfiles(JPA)
public class JpaUserServiceTest extends AbstractJpaUserServiceTest {
}