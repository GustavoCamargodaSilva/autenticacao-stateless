package gustavo.stateless.autenticacao.core.service;


import gustavo.stateless.autenticacao.core.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class JwtService {

    private static final Integer ONE_DAY_IN_HOURS = 24;

    @Value("${app.token.secret-key}")
    private String secretKey;

    public String createToken(User user){
        var data = new HashMap<String, String>();
        data.put("id", user.getId().toString());
        data.put("email", user.getEmail());
        return Jwts.builder().setClaims(data).setExpiration(generateExpiresAt()).signWith(generateSign()).compact();
    }

    private Date generateExpiresAt(){
        return Date.from(LocalDateTime.now().plusHours(ONE_DAY_IN_HOURS)
                .atZone(ZoneId.systemDefault()).toInstant());
    }

    private SecretKey generateSign(){
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
}
