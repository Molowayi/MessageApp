package be.intecbrussel.eindwerkmolowayibackend.datLayer;

import be.intecbrussel.eindwerkmolowayibackend.model.Message;
import be.intecbrussel.eindwerkmolowayibackend.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    public List<Message> findMessagesByTitleLike(String keyWord) ;
    public List<Message> findMessagesBySenderEquals(Person sender) ;
    public List<Message> findMessagesByReceiverEquals(Person sender) ;
    public List<Message> findMessagesByContentLike(String keyWord);

    @Query(value = "SELECT s.first_name AS S_FN, s.last_name AS S_LN, m.id AS ID, m.title AS TITLE, m.content AS CONTENT, m.post_time AS POST_TIME, r.first_name AS R_FN, r.last_name AS R_LN, s.id AS sender_id, r.id AS receiver_id, s.status AS sender_status, r.status AS receiver_status FROM person s JOIN message m ON m.sender = s.id JOIN person r ON m.receiver = r.id",
      nativeQuery = true)
    public List<Object> getAllMessagesByTheMeanOfQuery();

    @Query(value = "SELECT s.first_name AS S_FN, s.last_name AS S_LN, m.id, m.title AS TITLE, m.content AS CONTENT, m.post_time AS POST_TIME, r.first_name AS R_FN, r.last_name AS R_LN, s.id AS sender_id, r.id AS receiver_id, s.status AS sender_status, r.status AS receiver_status FROM person s JOIN message m ON m.sender = s.id JOIN person r ON m.receiver = r.id WHERE m.id = ?1",
      nativeQuery = true)
    public Object getAllMessagesByTheMeanOfQueryGivenId(long id);

    @Query(value = "SELECT m from Message m inner join m.sender s where s.firstName like ?1 and s.lastName like ?2")
    public List<Message> getAllMessagesBySenderNames(String firstName, String lastName);

    @Query(value = "SELECT m from Message m inner join m.sender s WHERE s.firstName LIKE ?1 OR s.lastName LIKE ?1")
    public List<Message> getAllMessagesBySenderName(String name);

    @Query(value = "SELECT m from Message m inner join m.receiver s where s.firstName like ?1 and s.lastName like ?2")
    public List<Message> getAllMessagesByReceiverNames(String firstName, String lastName);

    @Query(value = "SELECT m from Message m inner join m.receiver s WHERE s.firstName LIKE ?1 OR s.lastName LIKE ?1")
    public List<Message> getAllMessagesByReceiverName(String name);

     @Query(value = "SELECT s.id, m.id AS message_id, m.title, m.content, m.post_time, r.first_name AS receiver_first_name, r.last_name AS receiver_last_name, r.id AS receiver_id, r.status AS receiver_status FROM person s JOIN message m ON m.sender = s.id JOIN person r ON m.receiver = r.id WHERE s.id =?1",
      nativeQuery = true)
    public List<Object> getAllMessagesBySenderId(long id);

     @Query(value = "SELECT s.first_name AS sender_first_name, s.last_name AS sender_last_name, s.id AS sender_id, s.status AS sender_status, m.id AS ID, m.title, m.content, m.post_time, r.id AS receiver_id FROM person s JOIN message m ON m.sender = s.id JOIN person r ON m.receiver = r.id WHERE r.id =?1",
      nativeQuery = true)
    public List<Object> getAllMessagesByReceiverId(long id);


}
