package pl.grzegorz.rickandmorty.characters;

import lombok.Getter;

@Getter
class CharacterDto {

    private String name;
    private String status;
    private String species;
    private String gender;
    private String image;
}