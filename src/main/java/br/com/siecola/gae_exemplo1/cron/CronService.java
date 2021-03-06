package br.com.siecola.gae_exemplo1.cron;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/api/cron")
public class CronService {
    private static final Logger log = Logger.getLogger("CronService");

    @GetMapping(path = "/testcron")
    public ResponseEntity<?> testCron(@RequestHeader("X-Appengine-Cron") boolean fromAppEngine) {
        log.info("Cron	message	---	" + Calendar.getInstance().getTime());

        if (fromAppEngine) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
