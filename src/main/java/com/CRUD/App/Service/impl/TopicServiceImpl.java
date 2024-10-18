package com.CRUD.App.Service.impl;

import com.CRUD.App.Model.Topic;
import com.CRUD.App.Model.Usuario;
import com.CRUD.App.Model.dto.TopicDTO;
import com.CRUD.App.Repository.UsuarioRepository;
import com.CRUD.App.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.CRUD.App.Repository.TopicRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public Topic crearPublicacion(TopicDTO topic){

        Long userId = UsuarioServiceImpl.getCurrentUserId();

        Usuario usuario = usuarioRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("Usuario not Found by id: " + userId));

        if (topic == null){
            throw new RuntimeException("Topic is null");
        }

        Topic newTopic = new Topic();
        newTopic.setTitle(topic.getTitle());
        newTopic.setMessage(topic.getMessage());
        newTopic.setStatus(Boolean.TRUE);
        newTopic.setCreatedAt(LocalDateTime.now().withNano(0));
        newTopic.setUsuario(usuario);
        return topicRepository.save(newTopic);

    }

    @Override
    public List<Topic> listarPublicaciones(){
        return topicRepository.findByUsuarioId(UsuarioServiceImpl.getCurrentUserId());
    }

    @Override
    public Optional<Topic> getPublicacionPorId(Long id){
        return topicRepository.findById(id);
    }

    @Override
    public Topic actualizarPublicacion(Long id, TopicDTO topicDetails){
        Topic topic = topicRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Topic not Found by id: "+id));

        topic.setMessage(topicDetails.getMessage());
        topic.setTitle(topicDetails.getTitle());
        return topicRepository.save(topic);
    }

    @Override
    public Boolean borrarPublicacion(Long id){
        Topic topic = topicRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Topic not Found by id: " + id));

        topicRepository.delete(topic);
        return true;
    }
}
