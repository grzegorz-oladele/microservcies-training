package pl.grzegorz.proxy.kanye;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
class KanyeService {

    private final String host;
    private final String url;
    private final RestTemplate restTemplate;

    KanyeService(@Value("${rest-template.kanye.host}") String host, RestTemplate restTemplate) {
        this.host = host;
        this.restTemplate = restTemplate;
        this.url = "http://" + host + ":9000/kanye";
    }

    String getRandomQuote() {
        return restTemplate.getForObject(url, String.class);
    }
}