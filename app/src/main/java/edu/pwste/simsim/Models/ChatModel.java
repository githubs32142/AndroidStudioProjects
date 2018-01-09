package edu.pwste.simsim.Models;

/**
 * Created by Admin on 06.01.2018.
 */

public class ChatModel {
    private String message;
    private boolean send;

    public ChatModel(String message, boolean send) {
        this.message = message;
        this.send = send;
    }

    public ChatModel() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSend() {
        return send;
    }

    public void setSend(boolean send) {
        this.send = send;
    }
}
