package br.com.fiap.service;

import br.com.fiap.model.Usuario;
import br.com.fiap.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario cadastrar(Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioExistente.isPresent()) {
            throw new RuntimeException("Usuário já cadastrado no sistema!");
        }

        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Usuario usuario, Long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()){
            Usuario usuarioAtual = usuarioOptional.get();

            String novoEmail = usuario.getEmail();
            String emailAtual = usuarioAtual.getEmail();
            if (novoEmail != null && !novoEmail.equals(emailAtual)){
                if (usuarioRepository.findByEmail(novoEmail).isPresent()){
                    throw new RuntimeException("Email já esta em uso por outro usuário!");
                }
                usuarioAtual.setEmail(usuario.getEmail());
            }

            String novaSenha = usuario.getSenha();
            if (novaSenha != null && !novaSenha.isEmpty()){
                String senhaCriptografada = passwordEncoder.encode(novaSenha);
                usuarioAtual.setSenha(senhaCriptografada);
            }

            usuarioAtual.setNome(usuario.getNome());
            usuarioAtual.setGenero(usuario.getGenero());
            usuarioAtual.setTelefone(usuario.getTelefone());
            usuarioAtual.setData_nasc(usuario.getData_nasc());
            usuarioAtual.setPerfil_financeiro(usuario.getPerfil_financeiro());
            return usuarioRepository.save(usuarioAtual);
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public Usuario buscarPorId(Long id){
        Optional<Usuario> usuarioCadastrado = usuarioRepository.findById(id);
        if (usuarioCadastrado.isPresent()){
            return usuarioCadastrado.get();
        } else {
            throw new RuntimeException("Usuárionão encontrado!");
        }
    }

    public List<Usuario> buscarTodosUsuario(){
        return usuarioRepository.findAll();
    }

    public void excluirUsuario(Long id){
        Optional<Usuario> usuarioExcluido = usuarioRepository.findById(id);
        if (usuarioExcluido.isPresent()){
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuário não encontrado!");
        }
    }

}
