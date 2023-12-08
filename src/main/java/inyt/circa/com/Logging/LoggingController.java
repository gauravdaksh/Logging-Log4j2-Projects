package inyt.circa.com.Logging;


import inyt.circa.com.Logging.service.CircaLogger;
import inyt.circa.com.Logging.service.impl.CircaLogManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class LoggingController {

    /*@Autowired
    private CircaLogger circaAppLoggingService;*/

    CircaLogger circaLogger = CircaLogManager.getLogger(LoggingController.class);

    @RequestMapping(value = "/logs", method = RequestMethod.GET)
    public ResponseEntity<String> getLogs(){

        circaLogger.info("Logs generating...!!");
        circaLogger.logWithCorrelationId("1234","Testing Logging module");

        return ResponseEntity.ok("Logs are working..");
    }

}
