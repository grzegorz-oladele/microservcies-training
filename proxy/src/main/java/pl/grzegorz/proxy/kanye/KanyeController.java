package pl.grzegorz.proxy.kanye;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kanye")
@RequiredArgsConstructor
class KanyeController {

    private final KanyeService kanyeService;

    @GetMapping("/random-quote")
    String getRandomQuote() {
        return kanyeService.getRandomQuote();
    }
}