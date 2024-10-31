package gustavo.stateless.autenticacao.core.controller;

import gustavo.stateless.autenticacao.core.dto.AuthRequest;
import gustavo.stateless.autenticacao.core.dto.TokenDTO;
import gustavo.stateless.autenticacao.core.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public TokenDTO login(@RequestBody AuthRequest Request){
        return authService.login(Request);
    }

}
