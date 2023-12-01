package io.github.dft.iconsignit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RateResponse {
    private String error;
    private Boolean status;
    private List<Result> result;
}