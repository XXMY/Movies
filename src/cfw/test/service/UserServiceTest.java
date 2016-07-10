package cfw.test.service;

import cfw.movies.model.Users;
import cfw.movies.service.UserService;
import cfw.test.AbstractTest;
import cfw.test.utils.SpringUtil;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Cfw on 2016/7/10.
 */
public class UserServiceTest extends AbstractTest{

    private static UserService userServiceImpl;

    @BeforeClass
    public static void beforeClass(){
        userServiceImpl = (UserService) SpringUtil.getBean("registerServiceImpl");
    }

    @Test
    public void testUserExists(){

        Users user = new Users();
        user.setUsername("abc");
        user.setPassword("123");

        userServiceImpl.userExists(user);
    }

}
