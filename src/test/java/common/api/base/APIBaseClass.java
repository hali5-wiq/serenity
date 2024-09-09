package common.api.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.helpers.*;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class APIBaseClass {

    public FileReader fileReader = new FileReader();
    //We have this properties file which is set at runtime as designated by the class - usually refers to the API's
    //properties files location.
    public KeyValReader apiProperties = null;
    public ObjectMapper oM = new ObjectMapper();
    protected EnvironmentSelector environmentSelector = new EnvironmentSelector();
    protected DateMaker dateMaker = new DateMaker();

    protected GraphQLShell graphQLShell = new GraphQLShell();

    //Add array of headers
    private String protocol;
    private String port;
    private String domain;
    private String endpoint;
    private String query = "";
    private String version;
    private Response response;
    private JsonNode node;
    private String user;
    private String pass;
    private Headers headers;
    private List<Header> headerList = new ArrayList<Header>();
    private String body = "";
    private String bodyLocation = "";
    private File file;

    public String getBodyLocation() {
        return bodyLocation;
    }

    public void setBodyLocation(String bodyLocation) {
        this.bodyLocation = bodyLocation;
    }

    public void modifyFirstFoundPayloadKeyValue(String key, String value) {
        setBody(getBody().replaceFirst(key, value));
    }

    public void addBody() {
        if (!getBodyLocation().equals(""))
            setBody(fileReader.readFile(getBodyLocation()));
    }

    public void addBody(String body) {
        setBody(body);
    }

    public void replaceAllKeyValueInPayload(String key, String value) {
        setBody(getBody().replaceAll(key, value));
    }

    public String getSystemPropThenTryEnv(KeyValReader apiProperties, String value) {
        if ((System.getProperty(value) != null))
            return System.getProperty(value);
        return apiProperties.getProperty(value);
    }

    protected void constructAPI() {
        setProtocol(getApiProperties().getProperty("protocol"));
        setPort(getApiProperties().getProperty("port"));
        setDomain(getApiProperties().getProperty("domain"));
        setEndpoint(getApiProperties().getProperty("endpoint"));
        setQuery(getApiProperties().getProperty("query"));
        setVersion(getApiProperties().getProperty("version"));
        setHeaders(getHeaderList());
        addBody();
    }

    protected void constructAPIwithBody(String body) {
        setProtocol(getApiProperties().getProperty("protocol"));
        setPort(getApiProperties().getProperty("port"));
        setDomain(getApiProperties().getProperty("domain"));
        setEndpoint(getApiProperties().getProperty("endpoint"));
        setQuery(getApiProperties().getProperty("query"));
        setVersion(getApiProperties().getProperty("version"));
        setHeaders(getHeaderList());
        addBody(body);
    }

    protected void constructAPIwithBodyQuery(String body, String query) {
        setProtocol(getApiProperties().getProperty("protocol"));
        setPort(getApiProperties().getProperty("port"));
        setDomain(getApiProperties().getProperty("domain"));
        setEndpoint(getApiProperties().getProperty("endpoint"));
        setQuery(query);
        setVersion(getApiProperties().getProperty("version"));
        setHeaders(getHeaderList());
        addBody(body);
    }

    protected void constructAPI(String query) {
        setProtocol(getApiProperties().getProperty("protocol"));
        setPort(getApiProperties().getProperty("port"));
        setDomain(getApiProperties().getProperty("domain"));
        setEndpoint(getApiProperties().getProperty("endpoint"));
        setQuery(query);
        setVersion(getApiProperties().getProperty("version"));
        setHeaders(getHeaderList());
        addBody();
    }

    public ObjectMapper getoM() {
        return oM;
    }

    public void setoM(ObjectMapper oM) {
        this.oM = oM;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    protected void callPostApi() {
        RestAssured.useRelaxedHTTPSValidation();
        setResponse(SerenityRest.given().
                headers(getHeaders()).
                when().
                body(getBody()).
                post(getConstructedAPICall()));
    }

    protected void callPostApiEncoderType(String encType) {
        RestAssured.useRelaxedHTTPSValidation();
        setResponse(SerenityRest.given().
                config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().encodeContentTypeAs(encType, ContentType.TEXT))).
                headers(getHeaders()).
                when().
                body(getBody()).
                post(getConstructedAPICall()));
    }

    protected void callGetApi() {
        RestAssured.useRelaxedHTTPSValidation();
        setResponse(SerenityRest.given().
                headers(getHeaders()).
                when().
                body(getBody()).
                get(getConstructedAPICall()));
    }

    protected void callPatchApi() {
        RestAssured.useRelaxedHTTPSValidation();
        setResponse(SerenityRest.given().
                headers(getHeaders()).
                when().
                body(getBody()).
                patch(getConstructedAPICall()));
    }


    protected void callGetApiNOHEADERS() {
        RestAssured.useRelaxedHTTPSValidation();
        setResponse(SerenityRest.given().
                when().
                body(getBody()).
                get(getConstructedAPICall()));
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public List<Header> getHeaderList() {
        return headerList;
    }

    public void setHeaderList(List<Header> headerList) {
        this.headerList = headerList;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header> hL) {
        this.headers = new Headers(hL);
    }

    public void addToHeadersList(String key, String value) {
        headerList.add(new Header(key, value));
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public JsonNode getNode() {
        return node;
    }

    public void setNode(JsonNode node) {
        this.node = node;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void statusCodeReturned(int code, Response response) {
        response.then().statusCode(code);
    }

    public void statusMessageReturned(String message, Response response) {
        response.then().statusLine(message);
    }

    public KeyValReader getApiProperties() {
        return apiProperties;
    }

    public void setApiProperties(KeyValReader apiProperties) {
        this.apiProperties = apiProperties;
    }

    public Object returnValueByPath(String path, Response response) {
        return response.then().extract().path(path);
    }

    public void transformJsonPayLoadToTreeNode(JsonNode node, Response response) {
        try {
            node = oM.readValue(response.asString(), JsonNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void transformJsonPayLoadToTreeNode(JsonNode node, String payloadAsString) {
        try {
            node = oM.readValue(payloadAsString, JsonNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String convertPOJOtoJson(Object payload){
        try {
            return oM.writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getConstructedAPICall() {
        return getProtocol().concat(getDomain().concat(getPort().concat(getVersion().concat(getEndpoint().concat(getQuery())))));
    }
}