package br.pucrs.sisinfo.negocio.controller;
import br.pucrs.sisinfo.persistencia.dao.PassageirosDao;
import com.google.inject.Inject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class PassageiroController {
    
    private final static String emailRegularExpression = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    private PassageirosDao passageirosDao;
    
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
    
    
    
}
