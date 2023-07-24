package com.jonas.redesocialbackend.controlador;

import com.jonas.redesocialbackend.dominio.Usuario;
import com.jonas.redesocialbackend.dominio.dto.AuthDTO;
import com.jonas.redesocialbackend.dominio.dto.CadastroDTO;
import com.jonas.redesocialbackend.dominio.dto.LoginRespostaDTO;
import com.jonas.redesocialbackend.servico.TokenServico;
import com.jonas.redesocialbackend.servico.UsuarioServico;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class ControleDeAcessoControlador {

    private final AuthenticationManager authenticationManager;
    private final UsuarioServico usuarioServico;
    private final TokenServico tokenServico;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthDTO login) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(login.login(), login.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenServico.gerarToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginRespostaDTO(token));
    }

    @PostMapping("/cadastro")
    public ResponseEntity cadastro(@RequestBody @Valid CadastroDTO login) {
        if(this.usuarioServico.findByLogin(login.login()) != null)
            return ResponseEntity.badRequest().build();

        String senhaCodificada = new BCryptPasswordEncoder().encode(login.password());
        Usuario novoUsuario = new Usuario(login.login(), login.email(), senhaCodificada, login.cargo());

        this.usuarioServico.salvarUsuario(novoUsuario);

        return ResponseEntity.ok().build();
    }
}
