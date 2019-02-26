package be.intecbrussel.eindwerkmolowayibackend.controllers;


import be.intecbrussel.eindwerkmolowayibackend.daos.RoomDAO;
import be.intecbrussel.eindwerkmolowayibackend.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/ngo")
public class RoomController {

  @Autowired
  RoomDAO roomDAO;

  @GetMapping("/room/student/{id}")
  public Room getRoomByStudentId(@PathVariable(value = "id") long id) {
    return roomDAO.findRoomOfStudentGivenById(id);
  }
}
