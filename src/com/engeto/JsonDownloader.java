package com.engeto;

import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

public class JsonDownloader {

    public GetRequest getRequestFrom(String adress) {
        GetRequest request = Unirest.get(adress);
        return request;
    }

    public JSONObject getAsJson(GetRequest request) {
        HttpResponse<JsonNode> jsonResponse = request.asJson();
        JsonNode json = jsonResponse.getBody();
        return json.getObject();
    }
}
