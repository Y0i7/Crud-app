package com.CRUD.App.Service;

import com.CRUD.App.Model.Topic;
import com.CRUD.App.Model.dto.TopicDTO;

import java.util.List;
import java.util.Optional;

public interface TopicService {
    Topic crearPublicacion(TopicDTO topic);
    List<Topic> listarPublicaciones();
    Optional<Topic> getPublicacionPorId(Long id);
    Topic actualizarPublicacion(Long id, TopicDTO topicDetails);
    Boolean borrarPublicacion(Long id);
}
