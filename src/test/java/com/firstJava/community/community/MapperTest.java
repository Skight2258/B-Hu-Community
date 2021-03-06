package com.firstJava.community.community;

import com.firstJava.community.community.dao.DiscussPostMapper;
import com.firstJava.community.community.dao.UserMapper;
import com.firstJava.community.community.entity.DiscussPost;
import com.firstJava.community.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)//测试代码以CommunityApplication为配置类
public class MapperTest {
    @Autowired
    private UserMapper usermapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser(){
        User user=usermapper.selectById(1);
        System.out.println(user);
        user=usermapper.selectByName("liubei");
        System.out.println(user);

    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int rows = usermapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser() {
        int rows = usermapper.updateStatus(150, 1);
        System.out.println(rows);

        rows = usermapper.updateHeader(150, "http://www.nowcoder.com/102.png");
        System.out.println(rows);

        rows = usermapper.updatePassword(150, "hello");
        System.out.println(rows);
    }

    @Test
    public void testSelectPosts() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(149, 0, 10);
        for(DiscussPost post : list) {
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }



}
