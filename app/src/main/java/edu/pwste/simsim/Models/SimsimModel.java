package edu.pwste.simsim.Models;

/**
 * Created by Admin on 06.01.2018.
 */

public class SimsimModel {
    private String response;
    private String id;
    private int result;
    private String message;

    public SimsimModel(String response, String id, int result, String message) {
        this.response = response;
        this.id = id;
        this.result = result;
        this.message = message;
    }

    public SimsimModel() {
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
