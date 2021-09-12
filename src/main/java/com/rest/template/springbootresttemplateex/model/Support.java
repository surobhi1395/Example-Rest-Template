
package com.rest.template.springbootresttemplateex.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "text"
})
@Data
public class Support {

    @JsonProperty("url")
    public String url;
    @JsonProperty("text")
    public String text;

}
