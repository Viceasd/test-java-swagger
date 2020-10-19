package io.swagger.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

class TareaApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addTarea() throws Exception {
        this.mockMvc.perform(post("/v2/tarea").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"identificador\": 123,\n" +
                        "  \"descripcion\": \"tarea1\",\n" +
                        "  \"fechaCreacion\": \"2020-10-18\",\n" +
                        "  \"vigente\": true\n" +
                        "}"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("{\n" +
                        "  \"descripcion\": \"tarea1\",\n" +
                        "  \"fechaCreacion\": \"18/10/2020\",\n" +
                        "  \"identificador\": 123,\n" +
                        "  \"vigente\": true\n" +
                        "}")));
    }

    @org.junit.jupiter.api.Test
    void getTareaById() throws Exception {
        this.mockMvc.perform(get("v2/tarea/123")
                )
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("{\n" +
                        "  \"identificador\": 0.8008281904610115,\n" +
                        "  \"descripcion\": \"descripcion\",\n" +
                        "  \"fechaCreacion\": \"fechaCreacion\",\n" +
                        "  \"vigente\": true\n" +
                        "}")));
    }

    @org.junit.jupiter.api.Test
    void updateTarea() throws Exception {
        this.mockMvc.perform(put("/v2/tarea").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"identificador\": 123\n" +
                        "  \"descripcion\": \"tareaModificada\",\n" +
                        "  \"fechaCreacion\": \"2020-10-18\",\n" +
                        "  \"vigente\": false\n" +
                        "}"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("{\n" +
                        "  \"descripcion\": \"tareaMOdificada\",\n" +
                        "  \"fechaCreacion\": \"18/10/2020\",\n" +
                        "  \"identificador\": 123,\n" +
                        "  \"vigente\": false\n" +
                        "}")));
    }

    @org.junit.jupiter.api.Test
    void deleteTarea() throws Exception {
        this.mockMvc.perform(delete("v2/tarea/123")
        )
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Tarea Eliminada")));
    }
}