package auth;

/**
 * ClassName: DefaultApiAuthencatorImpl
 * Description:
 * date: 18/3/2022 下午10:22
 *
 * @author liyh
 */
public class DefaultApiAuthencatorImpl implements ApiAuthencator {

    private CredentialStorage credentialStorage;


    public DefaultApiAuthencatorImpl(CredentialStorage credentialStorage) {
        this.credentialStorage = credentialStorage;
    }

    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.createFromFullUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId();
        String baseUrl = apiRequest.getBaseUrl();
        long clientTimestamp = apiRequest.getTimestamp();
        String token = apiRequest.getToken();
        AuthToken clientAuthToken = new AuthToken(token, clientTimestamp);

        if(clientAuthToken.isExpired()){
            throw new RuntimeException("Token is expired");
        }

        String passwordByAppId = credentialStorage.getPasswordByAppId(appId);
        // didn't fix create method, using null as a param
        AuthToken serverAuthToken = AuthToken.create(baseUrl, clientTimestamp, null);
        if(!serverAuthToken.match(clientAuthToken)){
            throw new RuntimeException("Token verficiction failed");
        }
        //
    }
}
