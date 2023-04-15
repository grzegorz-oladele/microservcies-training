package pl.grzegorz.rickandmorty.characters;

import lombok.Getter;

import java.util.List;

@Getter
class ResponseDto {

    private InfoOfPage info;
    private List<CharacterDto> results;
}