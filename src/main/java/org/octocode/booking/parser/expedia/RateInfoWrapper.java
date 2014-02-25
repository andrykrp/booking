package org.octocode.booking.parser.expedia;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.octocode.booking.parser.expedia.dto.common.RateInfo;

/**
 * @author Dmitriy Guskov
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RateInfoWrapper {
    @JsonProperty("ChargeableRateInfo")
    private RateInfo rateInfo;

    public RateInfo getRateInfo() {
        return rateInfo;
    }

    public void setRateInfo(RateInfo rateInfo) {
        this.rateInfo = rateInfo;
    }
}
