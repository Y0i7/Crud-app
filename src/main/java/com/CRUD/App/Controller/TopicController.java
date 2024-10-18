package com.CRUD.App.Controller;

import com.CRUD.App.Model.Topic;
import com.CRUD.App.Model.dto.TopicDTO;
import com.CRUD.App.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publicaciones")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping
    public ResponseEntity<Topic> createUser(@RequestBody TopicDTO topic) {
        Topic savedTopic = topicService.crearPublicacion(topic);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTopic);
    }

    @GetMapping
    public List<Topic> getAllUsers() {
        return topicService.listarPublicaciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getUserById(@PathVariable Long id) {
        return topicService.getPublicacionPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateUser(@PathVariable Long id, @RequestBody TopicDTO topicDetails) {
        Topic updatedTopic = topicService.actualizarPublicacion(id, topicDetails);
        return ResponseEntity.ok(updatedTopic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        if (topicService.borrarPublicacion(id)){
            return ResponseEntity.ok("Topic deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }

}
