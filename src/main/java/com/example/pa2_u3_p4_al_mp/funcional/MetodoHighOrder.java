package com.example.pa2_u3_p4_al_mp.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodoHighOrder {

        private static final Logger LOG = LoggerFactory.getLogger(MetodoHighOrder.class); // desde ahora este logger para imprimir

    public void metodo(IPersonaSupplier <String> funcion){


        LOG.info("High order supplier "+ funcion.getId());

    }


    public void consumer(IPersonaConsumer<String> consumer , String val){

        LOG.info("Hight order consumer: ");

        consumer.accept(val);

    }
}
