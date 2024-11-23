package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.handlers;

import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data.subcomponents.EmissionDTO;

import java.util.List;

public class EmissionsDTOBuilder {

    public EmissionDTO BuildEmissionData( List <String> countries, List<Integer> dates, String description ) {
        EmissionDTO emissionDTO = new EmissionDTO();
        return emissionDTO;
    }
}
