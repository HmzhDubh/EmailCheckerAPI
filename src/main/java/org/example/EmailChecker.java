package org.example;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class EmailChecker {
    private String status;
    private String email;
    private String domain;
    private boolean MX;
    private boolean disposable ;
    private boolean alias;
    private String did_you_mean;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public boolean getMX() {
        return MX;
    }

    public void setMX(boolean MX) {
        this.MX = MX;
    }
    public boolean getDisposable() {
        return disposable;
    }

    public void setDisposable(boolean disposable) {
        this.disposable = disposable;
    }
    public boolean getAlias() {
        return alias;
    }

    public void setAlias(boolean alias) {
        this.alias = alias;
    }
    public String getDid_you_mean() {
        return did_you_mean;
    }

    public void setDid_you_mean(String did_you_mean) {
        this.did_you_mean = did_you_mean;
    }


    @SuppressWarnings("unchecked")
    @JsonProperty("main")
    private void unpackNested(Map<String,Object> main) {

        this.status = (String)main.get("status");
        this.email = (String)main.get("email");
        this.domain = (String) main.get("domain");
        this.MX = (boolean)main.get("MX");
        this.disposable = (boolean) main.get("disposable");
        this.alias = (boolean) main.get("alias");
        this.did_you_mean = (String)main.get("did_you_mean");

    }

    @Override
    public String toString() {
        return "Email status{" +
                " Status: " + status +
                "\n Email: " + email +
                "\n Domain: " + domain +
                "\n MX: " + MX +
                "\n disposable: " + disposable +
                "\n alias: " + alias +
                "\n did_you_mean: " + did_you_mean +
                "}";

    }
}