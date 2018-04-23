package app;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DialogService {

    public void sentMessage(String host, String port, String infoToSent) {
        RestTemplate rest = new RestTemplate();
        rest.exchange(
                String.format("http://%s:%s/putMessage?text=%s", host, port, infoToSent),
                HttpMethod.PUT,
                HttpEntity.EMPTY,
                String.class);
    }
}
