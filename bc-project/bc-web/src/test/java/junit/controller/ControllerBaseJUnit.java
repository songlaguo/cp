package junit.controller;

import org.bc.saas.web.Application;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

 


/**
 * User: R&M www.rmworking.com/blog
 * Date: 2017/8/17
 * Time: 18:42
 * ikang-enterprise-platform
 * com.ikang.enterprise.test.controller
 */
// 这是JUnit的注解，通过这个注解让SpringJUnit4ClassRunner这个类提供Spring测试上下文。
@RunWith(SpringJUnit4ClassRunner.class)
// 这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ControllerBaseJUnit {

    @Autowired
    private WebApplicationContext context;
    MockMvc mockMvc;

    @Before
    public void setupMockMvc() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

}
