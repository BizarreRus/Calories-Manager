package com.bizarrerus.service.jpa;

import org.springframework.test.context.ActiveProfiles;
import com.bizarrerus.service.AbstractMealServiceTest;

import static com.bizarrerus.Profiles.JPA;

@ActiveProfiles(JPA)
public class JpaMealServiceTest extends AbstractMealServiceTest {
}