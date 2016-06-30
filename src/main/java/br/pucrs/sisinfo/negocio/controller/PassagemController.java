package br.pucrs.sisinfo.negocio.controller;

import br.pucrs.sisinfo.persistencia.dao.PassagensDao;
import br.pucrs.sisinfo.persistencia.modelo.Passagem;
import com.google.inject.Inject;
import java.util.Calendar;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

public class PassagemController {

    private PassagensDao passagensDao;

    @Inject
    public PassagemController(PassagensDao passagensDao) {
        this.passagensDao = passagensDao;
    }

    public Passagem buscarPassagem(String id) {
        return passagensDao.buscarPassagem(id);
    }

    public int buscarVooPorPassagem(String id) {
        return passagensDao.buscarVoo(id);
    }

    public void realizarCompra(Passagem passagem) {
        passagensDao.registrarCompra(passagem);
    }

    public String checarStatus(Calendar dataPassagem) {
        Calendar atual = Calendar.getInstance();
        atual.setTimeInMillis(System.currentTimeMillis());
        int anoAtual = atual.get(YEAR);
        int anoPassagem = dataPassagem.get(YEAR);
        int mesAtual = atual.get(MONTH);
        int mesPassagem = dataPassagem.get(MONTH);
        int diaAtual = atual.get(DAY_OF_MONTH);
        int diaPassagem = atual.get(DAY_OF_MONTH);

        if (anoAtual < anoPassagem) {
            if (mesAtual == 12 && mesPassagem == 1) {
                if (diaAtual > 28 && diaPassagem == 1 || diaAtual > 29 && diaPassagem <= 2 || diaAtual > 30 && diaPassagem <= 3) {
                    return "Check-in aberto";
                }
            } else {
                return "Pendente";
            }
        } else if (mesAtual < mesPassagem) {
            if (mesPassagem - mesAtual == 1) {
                if (diaAtual > 28 && diaPassagem == 1 || diaAtual > 29 && diaPassagem <= 2 || diaAtual > 30 && diaPassagem <= 3) {
                    return "Check-in aberto";
                }else{
                    return "pendente";
                }
            }else{
                return "pendente";
            }

        } else{
            if(diaAtual > 28 && diaPassagem == 1 || diaAtual > 29 && diaPassagem <= 2 || diaAtual > 30 && diaPassagem <= 3 || diaPassagem-diaAtual==1){
                return "Check-in aberto";
            }
        }
        return "pendente";
    }
}
