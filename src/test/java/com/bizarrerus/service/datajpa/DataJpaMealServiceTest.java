package com.bizarrerus.service.datajpa;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import com.bizarrerus.UserTestData;
import com.bizarrerus.model.Meal;
import com.bizarrerus.service.AbstractMealServiceTest;
import com.bizarrerus.util.exception.NotFoundException;

import static com.bizarrerus.MealTestData.*;
import static com.bizarrerus.Profiles.DATAJPA;
import static com.bizarrerus.UserTestData.ADMIN_ID;

@ActiveProfiles(DATAJPA)
public class DataJpaMealServiceTest extends AbstractMealServiceTest {
    @Test
    public void testGetWithUser() throws Exception {
        Meal adminMeal = service.getWithUser(ADMIN_MEAL_ID, ADMIN_ID);
        MATCHER.assertEquals(ADMIN_MEAL1, adminMeal);
        UserTestData.MATCHER.assertEquals(UserTestData.ADMIN, adminMeal.getUser());
    }

    @Test(expected = NotFoundException.class)
    public void testGetWithUserNotFound() throws Exception {
        service.getWithUser(MEAL1_ID, ADMIN_ID);
    }
}
