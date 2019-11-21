package Model;

public class Almoxarife {

    private String siape;
    private String email;
    private String senha;
    private int tipo;
    private Almoxarifado almoxarifado;

    public Almoxarife() {
    }

    public Almoxarife(String siape, String email, String senha) {
        this.siape = siape;
        this.email = email;
        this.senha = senha;
    }

    /**
     * @return the siape
     */
    public String getSiape() {
        return siape;
    }

    /**
     * @param siape the siape to set
     */
    public void setSiape(String siape) {
        this.siape = siape;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the almoxarifado
     */
    public Almoxarifado getAlmoxarifado() {
        return almoxarifado;
    }

    /**
     * @param almoxarifado the almoxarifado to set
     */
    public void setAlmoxarifado(Almoxarifado almoxarifado) {
        this.almoxarifado = almoxarifado;
    }
}
