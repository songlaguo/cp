package junit;


 
 
import org.bc.saas.web.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * User: R&M www.rmworking.com/blog
 * Date: 2017/8/7
 * Time: 11:03
 * ikang-enterprise-platform
 * com.ikang.enterprise.test.persistence
 */
// 这是JUnit的注解，通过这个注解让SpringJUnit4ClassRunner这个类提供Spring测试上下文。
@RunWith(SpringJUnit4ClassRunner.class)
// 这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class BaseJUnit {

    @Test
    public void testProject(){
    	
    	
    	
    }
}
