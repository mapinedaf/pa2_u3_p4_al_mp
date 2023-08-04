package com.example.pa2_u3_p4_al_mp.funcional;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class); 

    public static void main(String[] args) {

        //Realizar la implementación de los métodos High Order JAVA (5 ejemplos) con Métodos Referenciados

        MetodoHighOrder metodoHighOrder = new MetodoHighOrder();

        MetodoReferenciado metodoReferenciado = new MetodoReferenciado();

        metodoHighOrder.consumer(metodoReferenciado::consumir, "12345");

        LOG.info(metodoHighOrder.supplier(metodoReferenciado::getIdHO));

        LOG.info(metodoHighOrder.predicate(metodoReferenciado::predicate, 1000)+"");

        LOG.info(metodoHighOrder.function(metodoReferenciado::function, "1234") + "");

        LOG.info(metodoHighOrder.unary(metodoReferenciado::unary,"abcd"));




    }
}
