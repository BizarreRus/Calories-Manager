package com.bizarrerus.service.datajpa;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import com.bizarrerus.MealTestData;
import com.bizarrerus.model.User;
import com.bizarrerus.service.AbstractJpaUserServiceTest;
import com.bizarrerus.util.exception.NotFoundException;

import static com.bizarrerus.Profiles.DATAJPA;
import static com.bizarrerus.UserTestData.*;

@ActiveProfiles(DATAJPA)
public class DataJpaUserServiceTest extends AbstractJpaUserServiceTest {
    @Test
    public void testGetWithMeals() throws Exception {
        User user = service.getWithMeals(USER_ID);
        MATCHER.assertEquals(USER, user);
        MealTestData.MATCHER.assertCollectionEquals(MealTestData.MEALS, user.getMeals());
    }

    @Test(expected = NotFoundException.class)
    public void testGetWithMealsNotFound() throws Exception {
        service.getWithMeals(1);
    }
}