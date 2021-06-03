package io.aws.lambda.events.gateway;

import io.aws.lambda.events.BodyEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class APIGatewayV2WebSocketEvent extends BodyEvent implements Serializable {

    private String resource;
    private String path;
    private String httpMethod;
    private Map<String, String> headers;
    private Map<String, List<String>> multiValueHeaders;
    private Map<String, String> queryStringParameters;
    private Map<String, List<String>> multiValueQueryStringParameters;
    private Map<String, String> pathParameters;
    private Map<String, String> stageVariables;
    private RequestContext requestContext;
    private boolean isBase64Encoded = false;

    @Data
    @Accessors(chain = true)
    public static class RequestIdentity implements Serializable {

        private String cognitoIdentityPoolId;
        private String accountId;
        private String cognitoIdentityId;
        private String caller;
        private String apiKey;
        private String sourceIp;
        private String cognitoAuthenticationType;
        private String cognitoAuthenticationProvider;
        private String userArn;
        private String userAgent;
        private String user;
        private String accessKey;
    }

    @Data
    @Accessors(chain = true)
    public static class RequestContext implements Serializable {

        private String accountId;
        private String resourceId;
        private String stage;
        private String requestId;
        private RequestIdentity identity;
        private String ResourcePath;
        private Map<String, Object> authorizer;
        private String httpMethod;
        private String apiId;
        private long connectedAt;
        private String connectionId;
        private String domainName;
        private String error;
        private String eventType;
        private String extendedRequestId;
        private String integrationLatency;
        private String messageDirection;
        private String messageId;
        private String requestTime;
        private long requestTimeEpoch;
        private String routeKey;
        private String status;
    }
}
