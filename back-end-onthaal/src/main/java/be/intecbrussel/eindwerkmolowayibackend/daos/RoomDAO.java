package be.intecbrussel.eindwerkmolowayibackend.daos;

import be.intecbrussel.eindwerkmolowayibackend.datLayer.RoomRepository;
import be.intecbrussel.eindwerkmolowayibackend.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomDAO {
  @Autowired
  RoomRepository roomRepository;
  public Room findRoomOfStudentGivenById(long id){
    return roomRepository.findRoomOfStudentGivenById(id);
  }
}
