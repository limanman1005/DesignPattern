package auth;

import java.util.Map;

/**
 * ClassName: AuthToken
 * Description:
 * date: 18/3/2022 下午9:52
 *
 * @author liyh
 */
public class AuthToken {
    private String token;

    private long createTime;

    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1 * 60 * 1000;

    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, long expiredTimeInterval) {
        this.token = token;
        this.createTime = createTime;
        this.expiredTimeInterval = expiredTimeInterval;
    }


    public static AuthToken create(String baseUrl, long createTime, Map<String, String> params){
        //generate an AuthToken by params, for learning OOD left out these details
        //todo this static method might be changed in the future in using other OOD pattern.
        return null;
    }


    public String getToken(){
        return token;
    }

    public boolean isExpired(){
        return false;
    }

    public boolean match(AuthToken authToken){
        String token = authToken.getToken();
        String ourToken = this.getToken();
        boolean result = ourToken.equals(token);
        return result;
    }

}
