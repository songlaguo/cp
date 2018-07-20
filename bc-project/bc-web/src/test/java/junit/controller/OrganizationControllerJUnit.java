package junit.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author : R&M www.rmworking.com/blog
 *         2018/5/8 15:07
 *         saas-base-organization
 *         junit.controller
 */
public class OrganizationControllerJUnit extends ControllerBaseJUnit{


    @Test
    public void test() throws Exception {
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.get("/organization/test"))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

}
