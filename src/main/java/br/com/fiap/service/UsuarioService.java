package br.com.fiap.service;

import br.com.fiap.model.Orcamento;
import br.com.fiap.model.Usuario;
import br.com.fiap.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario cadastrar(Usuario usuario) {
        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            throw new RuntimeException("O email é obrigatório!");
        }

        if (usuario.getSenha() == null || usuario.getSenha().trim().isEmpty()) {
            throw new RuntimeException("A senha é obrigatória!");
        }

        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioExistente.isPresent()) {
            throw new RuntimeException("Usuário já cadastrado no sistema!");
        }

        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Long id, Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (!usuarioOptional.isPresent()) {
            throw new RuntimeException("Usuário não encontrado!");
        }

        Usuario usuarioAtual = usuarioOptional.get();

        String novoEmail = usuario.getEmail();
        String emailAtual = usuarioAtual.getEmail();

        if (novoEmail != null && !novoEmail.equals(emailAtual)) {
            if (usuarioRepository.findByEmail(novoEmail).isPresent()) {
                throw new RuntimeException("Email já está em uso por outro usuário!");
            }
            usuarioAtual.setEmail(novoEmail);
        }

        String novaSenha = usuario.getSenha();
        if (novaSenha != null && !novaSenha.trim().isEmpty()) {
            String senhaCriptografada = passwordEncoder.encode(novaSenha);
            usuarioAtual.setSenha(senhaCriptografada);
        }

        if (usuario.getNome() != null) {
            usuarioAtual.setNome(usuario.getNome());
        }

        if (usuario.getGenero() != null) {
            usuarioAtual.setGenero(usuario.getGenero());
        }

        if (usuario.getTelefone() != null) {
            usuarioAtual.setTelefone(usuario.getTelefone());
        }

        if (usuario.getDataNasc() != null) {
            usuarioAtual.setDataNasc(usuario.getDataNasc());
        }

        if (usuario.getPerfilFinanceiro() != null) {
            usuarioAtual.setPerfilFinanceiro(usuario.getPerfilFinanceiro());
        }

        return usuarioRepository.save(usuarioAtual);
    }

    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()){
            return usuarioOptional.get();
        } else {
            throw new RuntimeException("Orçamento não encontrado!");
        }
    }

    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public void excluirUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado!");
        }
        usuarioRepository.deleteById(id);
    }
}