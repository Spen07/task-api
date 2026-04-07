package sn.isi.l3gl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import sn.isi.l3gl.api.task_api.controller.TaskController;
import sn.isi.l3gl.core.task_core.service.TaskService;

@WebMvcTest(TaskController.class)
class TaskApiApplicationTests {

	@MockBean
	private TaskService taskService;

	@Test
	void contextLoads() {
	}
}
