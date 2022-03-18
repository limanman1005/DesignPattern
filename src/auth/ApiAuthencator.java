package auth;


/**
 * why this class exists. provide a entrance to upper system or module call.
 * this interface reflects the principle of Interface-oriented programming.
 */
public interface ApiAuthencator {

    void auth(String url);

    void auth(ApiRequest apiRequest);
}
