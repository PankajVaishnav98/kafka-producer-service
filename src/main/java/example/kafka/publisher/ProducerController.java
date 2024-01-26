package example.kafka.publisher;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {


    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/send")
    public Response sendMessage(@RequestBody String message){
        kafkaProducer.sendMessage(message);
        Response response = new Response();
        response.setMessage("Message sent  :" + message);
        response.setStatus(200);
        return response;
    }

}
