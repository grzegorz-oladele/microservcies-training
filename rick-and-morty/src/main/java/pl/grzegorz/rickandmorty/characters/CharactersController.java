package pl.grzegorz.rickandmorty.characters;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
@RequiredArgsConstructor
class CharactersController {

    private final CharactersService charactersService;

    @GetMapping
    ResponseDto getResponse(@RequestParam(name = "pageNumber") int pageNumber) {
        return charactersService.getResponse(pageNumber);
    }
}