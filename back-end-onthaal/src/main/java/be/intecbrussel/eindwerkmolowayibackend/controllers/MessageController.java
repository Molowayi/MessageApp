package be.intecbrussel.eindwerkmolowayibackend.controllers;

import be.intecbrussel.eindwerkmolowayibackend.daos.MessageDAO;
import be.intecbrussel.eindwerkmolowayibackend.daos.PersonDAO;
import be.intecbrussel.eindwerkmolowayibackend.datLayer.PersonRepository;
import be.intecbrussel.eindwerkmolowayibackend.model.Message;
import be.intecbrussel.eindwerkmolowayibackend.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/ngo")
public class MessageController {

  @Autowired
  MessageDAO messageDAO;
  @Autowired
  PersonRepository personRepository;
  PersonDAO personDAO;

  @PostMapping(value = "/message", produces = "application/json")
  public Message createMessage(@RequestBody Message message) {
    System.out.println(message);
    Optional<Person> optionalSender = personRepository.findById(message.getSender().getId());
    if (optionalSender.isPresent()) message.setSender(optionalSender.get());
    Optional<Person> optionalReciever = personRepository.findById(message.getReceiver().getId());
    if (optionalReciever.isPresent()) message.setReceiver(optionalReciever.get());
    return messageDAO.save(message);
  }

  @GetMapping("/message")
  public ResponseEntity<List<Message>> getAllMessages() {
    List<Message> messages = messageDAO.findAll();
    return ResponseEntity.ok().body(messages);
  }

  @GetMapping("/message_and_persons")
  public ResponseEntity<List<Object>> getAllMessagesByTheMeanOfQuery() {
    List<Object> objects = messageDAO.getAllMessagesByTheMeanOfQuery();
    return ResponseEntity.ok().body(objects);
  }

  @GetMapping("/message_and_persons/{id}")
  public ResponseEntity<Object> getAllMessagesByTheMeanOfQueryGivenId(@PathVariable(value = "id") long id) {
    Object object = messageDAO.getAllMessagesByTheMeanOfQueryGivenId(id);
    return ResponseEntity.ok().body(object);
  }

  @GetMapping("/messages/sender/{id}")
  public ResponseEntity<List<Object>> getAllMessagesBySenderId(@PathVariable(value = "id") long id) {
    List<Object> objects = messageDAO.getAllMessagesBySenderId(id);
    return ResponseEntity.ok().body(objects);
  }

  @GetMapping("/messages/page/number/{p}/{n}")
  public ResponseEntity<List<Object>> getPagePOfNMessages(@PathVariable(value = "n") int n, @PathVariable(value = "p") int p) {
    List<Message> messages = messageDAO.findAll();
    int totalMessages = messages.size();
    int totalPages = (totalMessages % n == 0) ? totalMessages / n : 1 + totalMessages / n;
    int offset = n * (p - 1);
    List<Object> objects = (messageDAO.getAllMessagesByTheMeanOfQuery())
      .subList(offset, offset + n);

    objects.add(new Long(totalMessages));  // Helps keep the total number of messages

    return ResponseEntity.ok().body(objects);
  }

  @GetMapping("/messages/offset/number/{offset}/{n}")
  public ResponseEntity<List<Object>> getPagePOfNMessagesViqOffset(
    @PathVariable(value = "n") int n, @PathVariable(value = "offset") int offset) {
    List<Message> messages = messageDAO.findAll();
    int totalMessages = messages.size();
    int end = totalMessages +n;

    if ((offset > totalMessages)) {
      offset = totalMessages;
      end = totalMessages;
    }

    if ((offset + n > totalMessages) && (offset < totalMessages)) {
      end = totalMessages;
    }

    List<Object> objects = (messageDAO.getAllMessagesByTheMeanOfQuery())
      .subList(offset, end);

    objects.add(new Long(totalMessages));  // Helps keep the total number of messages

    return ResponseEntity.ok().body(objects);
  }

  @GetMapping("/messages/receiver/{id}")
  public ResponseEntity<List<Object>> getAllMessagesByReceiverId(@PathVariable(value = "id") long id) {
    List<Object> objects = messageDAO.getAllMessagesByReceiverId(id);
    return ResponseEntity.ok().body(objects);
  }

  @GetMapping("/message/sender/{firstName}/{lastName}")
  public ResponseEntity<List<Message>> findMessagesBySenderNames(@PathVariable(value = "firstName") String firstName, @PathVariable(value = "lastName") String lastName) {
    List<Message> messages = messageDAO.findMessagesBySenderNames(firstName, lastName);
    return new ResponseEntity<>(messages, HttpStatus.OK);
  }

  @GetMapping("/message/receiver/{firstName}/{lastName}")
  public ResponseEntity<List<Message>> findMessagesByReceiverNames(@PathVariable(value = "firstName") String firstName, @PathVariable(value = "lastName") String lastName) {
    List<Message> messages = messageDAO.findMessagesByReceiverNames(firstName, lastName);
    return new ResponseEntity<>(messages, HttpStatus.OK);
  }

  @GetMapping("/message/sender/{name}")
  public ResponseEntity<List<Message>> findMessagesBySenderName(@PathVariable(value = "name") String name) {
    List<Message> messages = messageDAO.findMessagesBySenderName(name);
    return new ResponseEntity<>(messages, HttpStatus.OK);
  }

  @GetMapping("/message/receiver/{name}")
  public ResponseEntity<List<Message>> findMessagesByReceiverName(@PathVariable(value = "name") String name) {
    List<Message> messages = messageDAO.findMessagesByReceiverName(name);
    return new ResponseEntity<>(messages, HttpStatus.OK);
  }

  @GetMapping(value = "/message/{id}", produces = "application/json")
  public ResponseEntity<Message> getMessageById(@PathVariable(value = "id") Long id) {
    Message message = messageDAO.findOne(id);
    if (message == null) {
      return ResponseEntity.notFound().build();
    }
    return new ResponseEntity<>(message, HttpStatus.OK);
  }

  @PutMapping(value = "/message/{id}", produces = "application/json")
  public ResponseEntity<Message> updateMessage(@PathVariable(value = "id") Long messageid, @RequestBody Message messageDetails) {

    Message message = messageDAO.findOne(messageid);
    if (message == null) {
      return ResponseEntity.notFound().build();
    }

    message.setId(messageDetails.getId());
    message.setTitle(messageDetails.getTitle());
    message.setContent(messageDetails.getContent());
    message.setSender(messageDetails.getSender());
    message.setReceiver(messageDetails.getReceiver());

    Message updateMessage = messageDAO.save(message);
    return ResponseEntity.ok().body(updateMessage);

  }

  @DeleteMapping("/message/{id}")
  public ResponseEntity<Message> deleteMessage(@PathVariable(value = "id") Long messageid) {

    Message message = messageDAO.findOne(messageid);
    if (message == null) {
      return ResponseEntity.notFound().build();
    }
    messageDAO.delete(message);

    return ResponseEntity.ok().build();
  }
}
