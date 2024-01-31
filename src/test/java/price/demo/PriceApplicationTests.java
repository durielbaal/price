package price.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PriceApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	@Test
	public void test_1_testCrearAlarma() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/tipoalarmas")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{ \"tipo\": \"HUM\", \"id\": 14, \"alarm\": \"" + LocalDateTime.now() + "\", \"severidad\": 5 }"))
				.andExpect(status().isOk());
	}
	@Test
	public void test_2_testConsultarAlarmasPorRangoDeFecha() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/tipoalarmas")
						.param("fechaInicio", "2024-01-02T22:21:00")
						.param("fechaFin", "2024-01-02T23:22:00"))
				.andExpect(status().isOk());
	}
	@Test
	public void test_3_testConsultarAlarmasPorSeveridadYRangoFecha() throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String fechaInicio = "2024-04-10 21:20:59";
		String fechaFin = "2024-04-10 21:50:59";

		mockMvc.perform(MockMvcRequestBuilders.get("/tipoalarmas")
						.param("severidad", "5")
						.param("fechaInicio", fechaInicio)
						.param("fechaFin", fechaFin))
				.andExpect(status().isOk());
	}
	@Test
	public void test_4_testConsultarAlarmasPorRangoFechaYSeveridad() throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// Rango de fecha en el formato deseado
		String fechaInicio = "2024-01-02 22:21:00";
		String fechaFin = "2024-01-02 23:22:00";

		mockMvc.perform(MockMvcRequestBuilders.get("/tipoalarmas")
						.param("severidad", "3")
						.param("fechaInicio", fechaInicio)
						.param("fechaFin", fechaFin))
				.andExpect(status().isOk());
	}
	@Test
	public void test_5_ConsultarAlarmasPorRangoFechaSeveridadYTunel() throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// Rango de fecha en el formato deseado
		String fechaInicio = "2024-01-02 22:21:00";
		String fechaFin = "2024-01-02 23:22:00";

		mockMvc.perform(MockMvcRequestBuilders.get("/tipoalarmas")
						.param("severidad", "3")
						.param("fechaInicio", fechaInicio)
						.param("fechaFin", fechaFin)
						.param("tunelId", "102"))
				.andExpect(status().isOk());
	}

	@Test
	public void test_6_ConsultarAlarmasPorRangoFechaSeveridadTipo() throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// Rango de fecha en el formato deseado
		String fechaInicio = "2024-01-02 22:21:00";
		String fechaFin = "2024-01-02 23:22:00";

		mockMvc.perform(MockMvcRequestBuilders.get("/tipoalarmas")
						.param("severidad", "3")
						.param("fechaInicio", fechaInicio)
						.param("fechaFin", fechaFin)
						.param("tipo", "HUM"))
				.andExpect(status().isOk());
	}
	@Test
	public void test_7_ConsultarAlarmasPorRangoFechaYTipo() throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// Rango de fecha en el formato deseado
		String fechaInicio = "2024-01-02 22:21:00";
		String fechaFin = "2024-01-02 23:22:00";

		mockMvc.perform(MockMvcRequestBuilders.get("/tipoalarmas")
						.param("fechaInicio", fechaInicio)
						.param("fechaFin", fechaFin)
						.param("tipo", "HUM"))
				.andExpect(status().isOk());
	}
	@Test
	public void test_8_ConsultarAlarmasPorRangoFechaSeveridadTunelYTipo() throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// Rango de fecha en el formato deseado
		String fechaInicio = "2024-01-02 22:21:00";
		String fechaFin = "2024-01-02 23:22:00";

		mockMvc.perform(MockMvcRequestBuilders.get("/tipoalarmas")
						.param("severidad", "1")
						.param("fechaInicio", fechaInicio)
						.param("fechaFin", fechaFin)
						.param("tunelId", "101")
						.param("tipo", "HUM"))
				.andExpect(status().isOk());
	}
}
