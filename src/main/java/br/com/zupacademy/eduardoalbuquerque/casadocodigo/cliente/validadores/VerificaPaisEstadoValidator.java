package br.com.zupacademy.eduardoalbuquerque.casadocodigo.cliente.validadores;

import br.com.zupacademy.eduardoalbuquerque.casadocodigo.cliente.ClienteRequest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class VerificaPaisEstadoValidator implements ConstraintValidator<VerificaPaisEstado, ClienteRequest> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean isValid(ClienteRequest clienteRequest, ConstraintValidatorContext context) {

        /* Esta validação verifica:
        1 - Estado nulo , verifica se pais possui algum estado cadastrado;
        2 - Estado não nulo, verifica se estado já está cadastrado para este país.
         */

        Long idEstado = clienteRequest.getEstado().getId();
        Long idPais = clienteRequest.getPais().getId();

        String qlString;
        Query query;
        List<String> resultList;

        if(idEstado == null){

            //estado null, verificar se o país passado tem estado cadastrado
            qlString = "SELECT 1 FROM Estado e where e.pais.id = :idPais ";

            query = manager.createQuery(qlString);
            query.setParameter("idPais", idPais);

            resultList = query.getResultList();

            return resultList.isEmpty()?true:false;



        }else{

            //estado com ID, verificar se o estado já está cadastrado para esse pais
            qlString = "SELECT 1 FROM Estado e join e.pais p where p.id = :idPais";
            System.out.println("verificando pais + estado ...");

            query = manager.createQuery(qlString);
            query.setParameter("idPais", idPais);

            resultList = query.getResultList();

            return resultList.isEmpty()?false:true;

        }

    }
}
