package io.github.dft.iconsignit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Result {
    private String carrierNm;
    private String serviceNm;
    private String totWeight;
    private String senderZone;

    @JsonProperty("QuoteRateID")
    private String quoteRateID;
    private String receiverZone;
    private String senderSuburb;
    private String senderPostcode;
    private String receiverSuburb;
    private String receiverPostcode;
    private String totVolume;

    @JsonProperty("ETA_DAY")
    private Integer etaDay;
    private Integer totQty;
    private String fees;
    private String frightCharge;

    @JsonProperty("Net_charge")
    private String netCharge;
    private String gst;
    private String totalCharge;
    private String category;
}