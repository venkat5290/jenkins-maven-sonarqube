package in.devops.jenkins.maven.sonarqube.controller;

import in.devops.jenkins.maven.sonarqube.service.HelloService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloService helloService;

    private String helloMsg;

    private String healthMsg;

    @BeforeEach
    void setUp() {

        helloMsg = "Hello,Tester";
        healthMsg = "TestInstance is ok";
    }

    @Test
    void hello() throws Exception {
        Mockito.when(helloService.getHello("Tester")).
                thenReturn(helloMsg);
        System.out.println("Testing Hello get call using mockito");

        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void health() throws Exception {
        Mockito.when(helloService.getHealth("TestInstance")).
                thenReturn(healthMsg);
        System.out.println("Testing Hello get call using mockito");

        mockMvc.perform(MockMvcRequestBuilders.get("/health"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}