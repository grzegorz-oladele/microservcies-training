package pl.grzegorz.kanyequotes.kanye;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
class RestTemplateHelper {

    private static final String URL = "https://api.kanye.rest";

    private final RestTemplate restTemplate;

    KanyeDto getRandomKanyesQuote() {
        return restTemplate.getForObject(URL, KanyeDto.class);
    }
}