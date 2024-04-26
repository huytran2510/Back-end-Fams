package fams.dto.request.authen;

public class TokenModel {
    private String apiKey;

    public TokenModel(String apiKey) {
        super();
        this.apiKey = apiKey;
    }
    public TokenModel() {}

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
