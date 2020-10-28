package com.example.test.MaerskTest;

import com.example.test.MaerskTest.controller.MaerskController;
import com.example.test.MaerskTest.model.MaerskResponseBody;
import com.example.test.MaerskTest.service.MaerskService;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MaerskController.class)
@WebAppConfiguration
public class MaerskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MaerskService maerskService;

    MaerskResponseBody responseBody = new MaerskResponseBody(true);

    @Test
    public void checkAvailable() throws Exception {

        Mockito.when(
                maerskService.checkAvailable(Mockito.any())).thenReturn(responseBody);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/bookings/checkAvailable").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "true";

        JSONAssert.assertEquals(expected,result.getResponse().toString(),false);
    }


}
