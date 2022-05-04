package com.prismaticsoftware.leavemanagementsystem.integration;

import com.prismaticsoftware.leavemanagementsystem.controller.LeaveController;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(LeaveController.class)
public class LeaveControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
}
