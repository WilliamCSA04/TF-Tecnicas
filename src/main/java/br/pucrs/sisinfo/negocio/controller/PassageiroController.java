package br.pucrs.sisinfo.negocio.controller;
import br.pucrs.sisinfo.persistencia.dao.PassageirosDao;
import br.pucrs.sisinfo.persistencia.modelo.Passageiro;
import com.google.inject.Inject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class PassageiroController {
    
    private final static String emailRegularExpression = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    private PassageirosDao passageirosDao;
    private static Passageiro usuarioAtual;
    private String email;
    
    @Inject
    public PassageiroController(PassageirosDao passageirosDao) {
        this.passageirosDao = passageirosDao;
    }
    
    public int buscaUsuario(String email, String senha){
        
        if(!validadorEmail(email)){
            return 0;
        }
        
        if(passageirosDao.checarLogin(email, senha)){ //TODO substituir esse if pelo metodo checarLogin da classe PassageirosDaoJdbc.
            return 1;
        }
        
        return -1;
    }
    
    private boolean validadorEmail(String email) {
        Pattern pattern = Pattern.compile(emailRegularExpression);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public void salvarPassageiroAtual(String email){
        usuarioAtual = passageirosDao.passageiroLogado(email);
    }
    
    public boolean checkCPF(String CPF){
        return usuarioAtual.getCpf().equals(CPF);
    }
    
    public boolean checkRG(String RG){
        return usuarioAtual.getRg().equals(RG);
    }
    
    public boolean checkPassaporte(String passaporte){
        return usuarioAtual.getPassaporte().equals(passaporte);
    }
    
    public int getID(){
        return usuarioAtual.getId();
    }
    
    
    
}
