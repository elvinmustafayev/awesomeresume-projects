package com.company;

import com.company.dao.impl.UserRepositoryCustom;
import com.company.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@DataJpaTest
public class UserDaoImpl2IT {


    @Autowired
    @Qualifier("userDao1")
    UserRepositoryCustom userDao;

    @Before
    public void before(){

    }

    @Test
    public void testGetAll(){

        List<User> list = userDao.getAll(null,null,null);
        Assert.assertEquals("user size must be 5",5 ,list.size());
        System.out.println("list2="+list);
    }

}
