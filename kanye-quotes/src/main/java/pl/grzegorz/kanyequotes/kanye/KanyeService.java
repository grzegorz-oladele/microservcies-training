package pl.grzegorz.kanyequotes.kanye;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class KanyeService {

    private final RestTemplateHelper restTemplateHelper;

    String getRandomQuoteOfKanye() {
        return restTemplateHelper.getRandomKanyesQuote().getQuote();
    }
}