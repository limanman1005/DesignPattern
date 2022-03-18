package auth;

/**
 * ClassName: ApiRequest
 * Description:
 * date: 18/3/2022 下午10:01
 *
 * @author liyh
 */
public class ApiRequest {

    private String baseUrl;

    private String token;

    private String appId;

    private long timestamp;

    public ApiRequest(String baseUrl, String token, String appId, long timestamp) {
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
    }


    public static ApiRequest createFromFullUrl(String url){
        //generate ApiRequest form url, ignore the details.
        return null;
    }



    public String getBaseUrl() {
        return baseUrl;
    }

    public String getToken() {
        return token;
    }

    public String getAppId() {
        return appId;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
