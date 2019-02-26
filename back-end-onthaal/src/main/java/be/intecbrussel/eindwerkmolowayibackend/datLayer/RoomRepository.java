package be.intecbrussel.eindwerkmolowayibackend.datLayer;

import be.intecbrussel.eindwerkmolowayibackend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoomRepository extends JpaRepository<Room, Long> {
  @Query(value = "SELECT  * FROM room JOIN  student s ON room.id = s.room WHERE  s.id=?1", nativeQuery = true)
  Room findRoomOfStudentGivenById(long id);
}
