package com.zhouyu;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class JWT {

    private static Logger log = LoggerFactory.getLogger(JWT.class);

    private static String KEY = "salt@lsm20210901salt@lsm20210901";

    //该方法使用HS256算法和Secret:bankgl生成signKey
    private static Key getKeyInstance( ) {
        //We will sign our JavaWebToken with our ApiKey secret
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName( ));
        return signingKey;
    }

    //使用HS256签名算法和生成的signingKey最终的Token,claims 中是有效载荷
    public static String createJavaWebToken(Map< String, Object > claims, Date endtime) {
        return Jwts.builder( ).setClaims(claims).setExpiration(endtime).signWith(SignatureAlgorithm.HS256, getKeyInstance( )).compact( );
    }

    //解析Token，同时也能验证Token，当验证失败返回null
    public static Map< String, Object > parserJavaWebToken(String token) {
        try {
            Map< String, Object > jwtClaims =
                    Jwts.parser( ).setSigningKey(getKeyInstance( )).parseClaimsJws(token).getBody( );
            return jwtClaims;
        } catch (Exception e) {
            //时间到了就直接报错了
            log.error("json web token verify failed");
            return null;
        }
    }

    public static Claims parserJavaWebTokenc(String jwt) {
        try {
            Claims jwtClaims =
                    Jwts.parser( ).setSigningKey(getKeyInstance( )).parseClaimsJws(jwt).getBody( );
            return jwtClaims;
        } catch (Exception e) {
            log.error("json web token verify failed");
            return null;
        }
    }

    public static long getUidByToken(String token) {
        try {
            Map< String, Object > map = parserJavaWebToken(token);
            if (map != null) {
                return Long.valueOf(String.valueOf(map.get("uid")));
            } else {
                return -1;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace( );
        }
        return -1;
    }

    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id","3");
        map.put("user","张三");

        //String javaWebToken = createJavaWebToken(map, DateUtils.addMinutes(new Date(), 1));
        String javaWebToken = "eyJjdHkiOiJKV1QiLCJlbmMiOiJBMjU2R0NNIiwiYWxnIjoiZGlyIn0..IvoTxSIOWwQXj6i2.KOrM-Czk1Mn993fQSuObQFeV9grL-BRlBGN4v7Q3ua4Tqgcxxrw8RVPXcEgCKjepT1TvntqIQBwe3a8wcf51zNCc922MmEGnLKHzm1q1-hR1ylqjki0IOhxCXsf608m127-PQHWyQvqOamL39BUhIngBoQ7SpujzGfDm0olfuEDGGSoeJtehAgs_862Lt8an937NNOXlCNezBwv_QDAJKQpAuhhfFIcuXvW5DGkldfhWMGqvSa1ZZL7tN-pGkrkEpOXm037N04yuyHn-7kN705tIIiXAt7RuNJBH2TGqgPeExti7COwQwGc6G7oEtiNRIT1-vD1IJoXtmwVDbVyVfvgghnVKyCedghditjuwsj56cFF1WCKqGkwat0OiokBXMZ5-1M1RdfBym5I5Sp02sBq82yBZKOhdKCJTFTnIaDskdj8LPS8ozzzsZAQIdulJ4y4CCbD3XH6ostmc5LTmU_zoNGKIR_PJ4BEJLCG0tjIXVkmVKUt_aTCfok9NoMLkkTXSTQY3n22NGZ_ENtNZpy-S23ChWYG3DSKoCVlhwzPmfQXD9D62TPmpY5cWMZa_rBU_QQ.11nZg2BbOQtuAmWJwZb0_g";
        System.err.println(javaWebToken);


        Map<String, Object> maps = parserJavaWebToken(javaWebToken);
        System.err.println(maps.get("id"));
        System.err.println(maps.get("user"));

    }

}
