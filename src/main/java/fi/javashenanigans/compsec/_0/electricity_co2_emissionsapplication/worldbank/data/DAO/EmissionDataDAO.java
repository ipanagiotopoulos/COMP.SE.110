package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.data.DAO;

import fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.worldbank.data.models.EmissionData;

import java.util.List;


public interface EmissionDataDAO {
public List<EmissionData> getEmissionData();
public EmissionData getEmissionData(int id);
}
