package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.handlers;

import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data.DataDTO;

import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data.subcomponents.Ember.EmberDataDTO;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.dto.data.subcomponents.EmissionDTO;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.helpers.EmberSeries;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.models.EnergyResponse;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.models.EmissionData;
import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.wrapper.models.EmissionResponse;


public class DataDTOBuilder {

    public DataDTO BuildData( EmissionResponse emissionResponse, EnergyResponse energyResponse ) {
        DataDTO dataDTO = new DataDTO();
        EmissionDTO emssionDTO = emissionDataHandler(emissionResponse);
        return dataDTO;
    }

    public EmissionDTO emissionDataHandler( EmissionResponse emissionResponse){
        for (EmissionData emissionData: emissionResponse.getData()){

        }

    }

    public EmberDataDTO emberDataHandler(EnergyResponse energyResponse){

    }


    public

}
