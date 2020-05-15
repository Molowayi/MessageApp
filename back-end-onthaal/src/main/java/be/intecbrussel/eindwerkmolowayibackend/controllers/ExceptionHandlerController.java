package be.intecbrussel.eindwerkmolowayibackend.controllers;


//import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

@ControllerAdvice
public class ExceptionHandlerController {

  private static final Logger logger = Logger.getLogger("Onthaal back-end application");

  @ExceptionHandler
  public ResponseEntity<String> handleException(Exception ex) {

    System.out.println("Toto est dans le gestionnaire général d'exceptions.");
    try {
//            Path path = Paths.get("log.log");
//            if (Files.notExists(path)) {
//                try {
//                    Files.createFile(path);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            } else {
////                Files.write(path, lines, Charset.defaultCharset(), StandardOpenOption.APPEND);
//            }

      File file = new File("src/log.log");
      FileOutputStream fos = new FileOutputStream(file);

      StreamHandler handler = new StreamHandler(fos, new Formatter() {
        public String format(LogRecord record) {
          return record.getLevel() + " : "
            + record.getSourceClassName() + " -:- "
            + record.getSourceMethodName() + " -:- "
            + record.getMessage() + "\n";
        }
      });

      logger.addHandler(handler);
      logger.info(ex.getMessage());

      // Alternative file writing
      PrintWriter writeToFile = new PrintWriter(new FileWriter("file.txt", true));
      writeToFile.println(ex.getMessage());

    } catch (FileNotFoundException fnfe) {
      String exceptionMessageAndStackTrace = ex.getMessage() + "\n" + ex.getStackTrace();
      return new ResponseEntity<String>(exceptionMessageAndStackTrace, HttpStatus.INTERNAL_SERVER_ERROR);
    } catch (IOException ioe
         ) {
      System.out.println("Exception Molo dans quoi?");
      System.out.println(ioe.getMessage());
    }
    System.out.println("Exception Molo dans quoi là?");
    String exceptionMessageAndStackTrace = ex.getMessage() + "\n" + ex.getStackTrace();
    return new ResponseEntity<String>(exceptionMessageAndStackTrace, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
