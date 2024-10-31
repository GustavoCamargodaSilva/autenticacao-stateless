package gustavo.stateless.autenticacao.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Classe de configuração para codificação de senhas.
 * Esta classe define um bean para o PasswordEncoder usando o algoritmo de hashing BCrypt.
 */
@Configuration
public class PasswordEncoderConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Cria um bean PasswordEncoder que usa o algoritmo de hashing BCrypt.
     * @return uma instância de PasswordEncoder configurada com BCrypt.
     */
}
