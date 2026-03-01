package sn.isi.l3gl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Classe dans le package racine sn.isi.l3gl :
// Spring Boot scanne automatiquement TOUS les sous-packages :
//   - sn.isi.l3gl.core.task_core.entity      -> entite Task trouvee par JPA
//   - sn.isi.l3gl.core.task_core.repository  -> TaskRepository trouve par Spring Data
//   - sn.isi.l3gl.core.task_core.service     -> TaskService trouve par @Service
//   - sn.isi.l3gl.api.task_api.controller    -> TaskController trouve par @RestController
@SpringBootApplication
public class TaskApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApiApplication.class, args);
	}
}
