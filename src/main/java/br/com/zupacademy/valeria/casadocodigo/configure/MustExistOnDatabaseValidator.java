package br.com.zupacademy.valeria.casadocodigo.configure;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Optional;

public class MustExistOnDatabaseValidator implements ConstraintValidator<MustExistOnDatabase, Object> {

    @PersistenceContext
    private EntityManager em;

    private String fieldName;
    private Class<?> domainClass;

    @Override
    public void initialize(MustExistOnDatabase params) {
        fieldName = params.fieldName();
        domainClass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        Query query = em.createQuery("SELECT 1 FROM " + domainClass.getName() + " WHERE " + fieldName + " = :value");
        query.setParameter("value", value);
        Optional<?> resultList = query.getResultList().stream().findFirst();

        return resultList.isPresent();
    }
}
