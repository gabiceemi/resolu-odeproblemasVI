/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.AlmoxarifeDAO;
import Model.Almoxarife;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "autenticacaoBean")
public class AutenticacaoBean {

    public static String siape;
    private String senha;
    public static int tipo;
    private final AlmoxarifeDAO almoxarifeDAO;
    public static final String USUARIO_LOGADO = "usuarioLogado";

    public AutenticacaoBean() {
        this.almoxarifeDAO = new AlmoxarifeDAO();
    }

    public String logar() {

        Almoxarife usuarioLogado = almoxarifeDAO.select(siape, senha, tipo);

        if (usuarioLogado != null) {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute(USUARIO_LOGADO, usuarioLogado);
            return "home";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não existe! Erro no Login!", "Erro no Login!"));
        return null;
    }

    public Almoxarife getUsuarioLogado() {
        Almoxarife usuarioSessao = (Almoxarife) ((HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false)).getAttribute(USUARIO_LOGADO);

        return usuarioSessao;

    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static String getUSUARIO_LOGADO() {
        return USUARIO_LOGADO;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

}
