package gustavo.stateless.autenticacao.core.service;


import gustavo.stateless.autenticacao.core.dto.AuthRequest;
import gustavo.stateless.autenticacao.core.dto.TokenDTO;
import gustavo.stateless.autenticacao.infra.exception.ValidationException;
import gustavo.stateless.autenticacao.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@AllArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    public TokenDTO login(AuthRequest request){
        var user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new ValidationException("User not found"));
        var accessToken = jwtService.createToken(user);
        validatePassword(request.password(), user.getPassword());
        return new TokenDTO(accessToken);
    }

    private void validatePassword(String rawPassword, String encodedPassword){
        if(isEmpty(rawPassword)){
            throw new ValidationException("Password must be informed");
        }
        if(!passwordEncoder.matches(rawPassword, encodedPassword)){
            throw new ValidationException("Invalid password");
        }
    }


}
