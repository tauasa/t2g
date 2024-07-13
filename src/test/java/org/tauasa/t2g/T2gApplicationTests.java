package org.tauasa.t2g;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class T2gApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void contextLoads() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		mvc.perform(MockMvcRequestBuilders.get("/courses").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		mvc.perform(MockMvcRequestBuilders.get("/golfers").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		mvc.perform(MockMvcRequestBuilders.get("/scores").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		mvc.perform(MockMvcRequestBuilders.get("/scorecards").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

}
