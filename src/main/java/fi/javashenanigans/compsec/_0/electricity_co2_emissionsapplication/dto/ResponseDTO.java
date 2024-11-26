package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto;


import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data.DataDTO;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.searchdescription.SearchDescriptionDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter @Data @AllArgsConstructor @NoArgsConstructor
public class ResponseDTO {
    private SearchDescriptionDTO searchDescriptionDTO;
    private List <DataDTO> dataDTO;
}
