package pl.grzegorz.rickandmorty.locations;

import lombok.Getter;
import pl.grzegorz.rickandmorty.dto.PageInfo;

import java.util.List;

@Getter
class LocationsDto {

    private PageInfo info;
    private List<SiteDto> results;
}