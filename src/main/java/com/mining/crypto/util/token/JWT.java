package com.mining.crypto.util.token;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import java.text.ParseException;

public class JWT {

    private static final JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.HS256).type(JOSEObjectType.JWT).build();

    public static String generateTokenByHMAC(String payloadStr, String secret) {
        String tokenString = null;
        Payload payload = new Payload(payloadStr);
        JWSObject jwsObject = new JWSObject(header, payload);
        try {
            jwsObject.sign(new MACSigner(secret));
            tokenString = jwsObject.serialize();
        } catch (JOSEException e) {
            System.err.println("JWT签名失败:" + e.getMessage());
            e.printStackTrace();
        }
        return tokenString;
    }

    public static String verifyTokenByHMAC(String token, String secret) {
        String payload = null;
        try {
            JWSObject jwsObject = JWSObject.parse(token);
            JWSVerifier jwsVerifier = new MACVerifier(secret);
            if (jwsObject.verify(jwsVerifier)) {
                payload = jwsObject.getPayload().toString();
                System.out.println(payload);
            }
        } catch (ParseException | JOSEException e) {
            e.printStackTrace();
        }
        return payload;
    }
}