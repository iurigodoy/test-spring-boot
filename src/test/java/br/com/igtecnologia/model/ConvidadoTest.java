package br.com.igtecnologia.model;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class ConvidadoTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

	@Test
	public void nomeEmpty() {
		Convidado convidado = new Convidado("", 1);

        Set<ConstraintViolation<Convidado>> constraintViolations =
                validator.validate( convidado );

        assertEquals( 1, constraintViolations.size() );
        assertEquals( "O nome não pode ser vazio", constraintViolations.iterator().next().getMessage() );
	}

	@Test
	public void quantidadeNegativa() {
		Convidado convidado = new Convidado("José", -1);

        Set<ConstraintViolation<Convidado>> constraintViolations =
                validator.validate( convidado );

        assertEquals( 1, constraintViolations.size() );
        assertEquals( "A quantidade de acompanhantes deve ser no mínimo 0", constraintViolations.iterator().next().getMessage() );
	}
}
