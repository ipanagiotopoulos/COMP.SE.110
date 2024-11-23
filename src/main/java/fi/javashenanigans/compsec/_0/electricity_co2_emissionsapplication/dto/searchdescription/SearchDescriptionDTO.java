package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.searchdescription;


import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.searchdescription.subcomponents.CountryDTO;
import lombok.*;

import java.util.List;

@Getter @Setter @Data @AllArgsConstructor @NoArgsConstructor
public class SearchDescriptionDTO {
    private List <CountryDTO> countries;
    private int dateBegin;
    private int dateEnd;
}
