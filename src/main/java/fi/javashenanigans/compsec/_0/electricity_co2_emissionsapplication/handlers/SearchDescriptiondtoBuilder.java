package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.handlers;

import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.searchdescription.subcomponents.CountryDTO;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.searchdescription.SearchDescriptionDTO;

import java.util.ArrayList;
import java.util.List;


public class SearchDescriptionBuilder {

    public SearchDescriptionDTO BuildSearchDescription( List <String> countries, List<Integer> dates ){
        List<CountryDTO> countriesDTO = new ArrayList <CountryDTO>();
        for (String country : countries){
            countriesDTO.add(new CountryDTO(country, null));
        }
        return new SearchDescriptionDTO(countriesDTO, dates.get(0),dates.get(1));
    }
}
