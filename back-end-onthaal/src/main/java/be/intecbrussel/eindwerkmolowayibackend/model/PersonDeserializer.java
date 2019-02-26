package be.intecbrussel.eindwerkmolowayibackend.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class PersonDeserializer extends JsonDeserializer<Person> {
  @Override
  public Person deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    ObjectMapper mapper = (ObjectMapper) jp.getCodec();
    ObjectNode root = (ObjectNode) mapper.readTree(jp);
    Class<? extends Person> instanceClass = null;
    if (checkConditionsForStudent(root)) {
      instanceClass = Student.class;
    } else {
      instanceClass = Staff.class;
    }
    if (instanceClass == null) {
      return null;
    }
    return mapper.convertValue(root, instanceClass);
  }

  private boolean checkConditionsForStudent(ObjectNode root) {
    JsonNode status = root.get("status");
    return status.asText().equalsIgnoreCase("STUDENT") ? true : false;
  }
}
