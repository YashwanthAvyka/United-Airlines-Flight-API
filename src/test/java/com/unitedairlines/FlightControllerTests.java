package com.unitedairlines;

import com.unitedairlines.model.Flight;
import com.unitedairlines.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FlightControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void testCreateAndGetFlight() throws Exception {
        String flightJson = "{" +
                "\"flightNumber\":\"UA123\"," +
                "\"origin\":\"SFO\"," +
                "\"destination\":\"LAX\"," +
                "\"departureTime\":\"10:00 AM\"," +
                "\"arrivalTime\":\"11:30 AM\"}";

        mockMvc.perform(post("/api/flights")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(flightJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.flightNumber").value("UA123"));

        mockMvc.perform(get("/api/flights"))
                .andExpect(status().isOk());
    }
}