package be.intecbrussel.eindwerkmolowayibackend.daos;

import be.intecbrussel.eindwerkmolowayibackend.datLayer.MessageRepository;
import be.intecbrussel.eindwerkmolowayibackend.model.Message;
import be.intecbrussel.eindwerkmolowayibackend.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageDAO {

    @Autowired
    MessageRepository messageRepository;


    public synchronized Message save(Message message) {
        return messageRepository.save(message);
    }

    public synchronized List<Message> findAll() {
        return messageRepository.findAll();
    }

    public synchronized List<Object> getAllMessagesByTheMeanOfQuery() {
        return messageRepository.getAllMessagesByTheMeanOfQuery();
    }

    public synchronized Object getAllMessagesByTheMeanOfQueryGivenId(long id) {
        return messageRepository.getAllMessagesByTheMeanOfQueryGivenId(id);
    }

    public synchronized List<Object> getAllMessagesBySenderId(long id) {
        return messageRepository.getAllMessagesBySenderId(id);
    }

    public synchronized List<Object> getAllMessagesByReceiverId(long id) {
        return messageRepository.getAllMessagesByReceiverId(id);
    }

    public synchronized Message findOne(Long id) {
        return messageRepository.getOne(id);
    }

    public synchronized void delete(Message message) {
        messageRepository.delete(message);
    }

    public synchronized List<Message> findMessagesBySender(Person sender) {
        return messageRepository.findMessagesByReceiverEquals(sender);
    }

    public synchronized List<Message> findMessagesByReceiver(Person receiver) {
        return messageRepository.findMessagesByReceiverEquals(receiver);
    }

    public synchronized List<Message> findMessagesBySenderNames(String firstName, String lastName) {
        return messageRepository.getAllMessagesBySenderNames(firstName, lastName);
    }

    public synchronized List<Message> findMessagesBySenderName(String name) {
        return messageRepository.getAllMessagesBySenderName(name);
    }

    public synchronized List<Message> findMessagesByReceiverNames(String firstName, String lastName) {
        return messageRepository.getAllMessagesByReceiverNames(firstName, lastName);
    }

    public synchronized List<Message> findMessagesByReceiverName(String name) {
        return messageRepository.getAllMessagesByReceiverName(name);
    }
}
