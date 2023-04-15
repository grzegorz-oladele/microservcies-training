package pl.grzegorz.proxy.rickandmorty;

import lombok.Getter;
import pl.grzegorz.proxy.rickandmorty.dto.PageInfo;

import java.util.List;

@Getter
class CharactersDto {

    private PageInfo info;
    private List<FigureDto> results;
}