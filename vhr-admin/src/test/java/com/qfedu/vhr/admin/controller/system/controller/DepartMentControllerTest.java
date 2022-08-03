package com.qfedu.vhr.admin.controller.system.controller;

import com.qfedu.vhr.admin.controller.system.entity.vo.DepartmentChildrenVo;
import com.qfedu.vhr.admin.controller.system.service.IDepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


/**
 * @author weepppp 2022/8/3 13:32
 * 用MockMvc测试controller
 **/
@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = DepartMentController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DepartMentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllDepts() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/system/basic/department/")
              .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());
    }
}
