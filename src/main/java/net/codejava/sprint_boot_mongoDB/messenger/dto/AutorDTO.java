package net.codejava.sprint_boot_mongoDB.messenger.dto;

import net.codejava.sprint_boot_mongoDB.messenger.model.Usuario;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class AutorDTO implements Serializable {

    @Id
    private String id;

    private String nome;

    public AutorDTO() {
    }

    public AutorDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
