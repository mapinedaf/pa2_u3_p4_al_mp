package com.example.pa2_u3_p4_al_mp.funcional;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.util.ArrayUtils;

import com.example.pa2_u3_p4_al_mp.repository.PersonaFunctionImpl;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class); 

    public static void main(String[] args) {

        //TAREA 17: Metodos High Order para Predicate, Function y UnaryOperator
        //Realizar ejemplos de implementación para clase, lambdas y métodos referenciados 

        MetodoHighOrder metodoHighOrder = new MetodoHighOrder();

        MetodoReferenciado metodoReferenciado = new MetodoReferenciado();

        LOG.info(metodoHighOrder.predicate(metodoReferenciado::predicate, 1000)+"");

        IPersonaPredicate<Integer> predicate = (x) -> x.compareTo(100)>=0;

        LOG.info("Lambda predicate" + metodoHighOrder.predicate( predicate , 1000));
        
        predicate = new PersonaPredicateImpl();

        LOG.info("class predicate" + metodoHighOrder.predicate( predicate , 1000));
        

        LOG.info(metodoHighOrder.function(metodoReferenciado::function, "1234") + "");

        IPersonaFuntion<Character[], String> function = (val) -> val.chars().mapToObj(c -> (char)c).toArray(Character[]::new);

        LOG.info("Lambda function" + metodoHighOrder.function(function, "algo"));


        function = new PersonaFunctionImpl();
        LOG.info("Class function" + metodoHighOrder.function(function, "algo"));

        LOG.info(metodoHighOrder.unary(metodoReferenciado::unary,"abcd"));

        IPersonaUnaryOperator<String> unary = (arg) -> arg +arg ;

        LOG.info("Lambda unary "+ metodoHighOrder.unary(unary, "abcd"));
        
        unary = new PersonaUnaryOperatorImpl ();
        LOG.info("Lambda class " + metodoHighOrder.unary(unary, "defg"));




    }
}
