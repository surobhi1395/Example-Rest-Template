package com.rest.template.springbootresttemplateex.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "job"
})
public class PostUser {

    @JsonProperty("name")
    public String name;
    @JsonProperty("job")
    public String job;

}
