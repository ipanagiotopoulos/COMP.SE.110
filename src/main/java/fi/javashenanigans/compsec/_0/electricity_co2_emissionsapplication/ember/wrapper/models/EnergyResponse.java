package fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.ember.wrapper.models;

import  fi.javashenanigans.compsec._0.electricity_co2_emissionsapplication.wrapper.ember.models.Stats;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EnergyResponse {
    private Stats stats;
    private List <DataRecord> data;
}
