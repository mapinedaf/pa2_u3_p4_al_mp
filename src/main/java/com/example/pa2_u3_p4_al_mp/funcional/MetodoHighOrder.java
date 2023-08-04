package com.example.pa2_u3_p4_al_mp.funcional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodoHighOrder {

        private static final Logger LOG = LoggerFactory.getLogger(MetodoHighOrder.class); // desde ahora este logger para imprimir

    public String supplier(IPersonaSupplier <String> funcion){


        LOG.info("High order supplier ");

        return funcion.getId();

    }


    public void consumer(IPersonaConsumer<String> consumer , String val){

        LOG.info("Hight order consumer: ");

        consumer.accept(val);

    }

    public Boolean predicate(IPersonaPredicate<Integer> predicate, Integer val){
        LOG.info("Hight order predicate: "+val +" -> ");
        return predicate.evaluar(val);
    }

    public Character[] function(IPersonaFuntion<Character[], String> funtion, String val){
        LOG.info("Hight order function: "+val +" -> ");
        return funtion.aplicar(val);
    }

    public String unary(IPersonaUnaryOperator<String> unary, String val){
        LOG.info("Hight order unary: "+val +" -> ");
        return unary.aplicar(val);
    }
}
