/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "menuBean")
public class MenuBean {
    
    public String home(){
        return "home";
    }

    public String solicitar() {
        return "solicitacao";
    }

    public String analisar() {
        return "analisarSolicitacao";
    }

    public String requisicao() {
        return "requisicaoMensal";
    }

    public String acompanhar() {
        return "acompanharSolicitacoes";
    }
    
    public String consultar() {
        return "consultarEstoque";
    }
}
