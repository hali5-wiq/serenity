package common.helpers;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "query",
        "variables"
})
@Generated("GraphQLQuery")
public class GraphQLShell {

    @JsonProperty("query")
    private String query;
    @JsonProperty("variables")
    private Object variables;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public GraphQLShell() {
    }

    /**
     *
     * @param variables
     * @param query
     */
    public GraphQLShell(String query, Object variables) {
        super();
        this.query = query;
        this.variables = variables;
    }

    @JsonProperty("query")
    public String getQuery() {
        return query;
    }

    @JsonProperty("query")
    public void setQuery(String query) {
        this.query = query;
    }

    public GraphQLShell withQuery(String query) {
        this.query = query;
        return this;
    }

    @JsonProperty("variables")
    public Object getVariables() {
        return variables;
    }

    @JsonProperty("variables")
    public void setVariables(Object variables) {
        this.variables = variables;
    }

    public GraphQLShell withVariables(Object variables) {
        this.variables = variables;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public GraphQLShell withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("query");
        sb.append('=');
        sb.append(((this.query == null)?"<null>":this.query));
        sb.append(',');
        sb.append("variables");
        sb.append('=');
        sb.append(((this.variables == null)?"<null>":this.variables));
        return sb.toString();
    }

}