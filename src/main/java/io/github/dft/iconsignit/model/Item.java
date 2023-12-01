package io.github.dft.iconsignit.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Item {
    private String itemCode;
    private String itemDesc;
    private Integer itemQty;
    private Double itemLength;
    private Double itemWidth;
    private Double itemHeight;
    private Double itemWeight;
    private Integer itemPalletised;
}