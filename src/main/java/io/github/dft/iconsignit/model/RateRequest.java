package io.github.dft.iconsignit.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class RateRequest {
    public String apiUrl;
    public String apiToken;
    public String locationTown;
    public String deliveryTown;
    public Integer isTailgate;
    public Integer isResidential;
    public String locationPostcode;
    public String deliveryPostcode;
    public Integer isDangerousGoods;
    public Integer isSenderResidential;
    public List<Item> items;
}