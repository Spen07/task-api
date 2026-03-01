package sn.isi.l3gl.api.task_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.isi.l3gl.core.task_core.entity.Task;
import sn.isi.l3gl.core.task_core.enums.Status;
import sn.isi.l3gl.core.task_core.service.TaskService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // POST /api/tasks
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    // GET /api/tasks
    @GetMapping
    public ResponseEntity<List<Task>> listTasks() {
        return ResponseEntity.ok(taskService.listTasks());
    }

    // PUT /api/tasks/{id}/status
    @PutMapping("/{id}/status")
    public ResponseEntity<Task> updateStatus(
            @PathVariable Long id,
            @RequestBody Map<String, String> body) {
        Status status = Status.valueOf(body.get("status"));
        return ResponseEntity.ok(taskService.updateStatus(id, status));
    }

    // GET /api/tasks/done/count
    @GetMapping("/done/count")
    public ResponseEntity<Long> countCompletedTasks() {
        return ResponseEntity.ok(taskService.countCompletedTasks());
    }
}
