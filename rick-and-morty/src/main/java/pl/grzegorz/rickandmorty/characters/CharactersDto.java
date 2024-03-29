package pl.grzegorz.rickandmorty.characters;

import lombok.Getter;
import pl.grzegorz.rickandmorty.dto.PageInfo;

import java.util.List;

@Getter
class CharactersDto {

    private PageInfo info;
    private List<FigureDto> results;
}