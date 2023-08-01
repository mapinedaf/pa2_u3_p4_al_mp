package com.example.pa2_u3_p4_al_mp.funcional;

import java.time.LocalTime;
import java.time.temporal.TemporalAmount;

import org.slf4j.Logger; // debe ser este pilas
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class); // desde ahora este logger para imprimir

    public static void main(String[] args) {
        IPersona persona = new PersonaImpl();
        persona.caminar();
        // 1.- Supplier

        // Clases
        IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
        LOG.info("Supplier class" + supplier.getId());
        // no se usa el Sysmten.out.println
        // la buena practica es un logger

        // Lambdas
        IPersonaSupplier<String> supplier2 = () -> "1724210685";
        LOG.info("Spplier2 lambda: " + supplier2.getId());

        IPersonaSupplier<String> supplier3 = () -> {
            String cedula = "1724210685";
            String cedu = cedula + "Zzzzz";
            return cedu;
        };
        LOG.info("Spplier3 lambda: " + supplier3.getId());

        // Metodos referenciados

        MetodoReferenciado metodoReferenciado = new MetodoReferenciado();

        IPersonaSupplier<Integer> supplier4 = metodoReferenciado::getId;

        LOG.info("Spplier4 Referenciado: " + supplier4.getId());

        // 2. Consumer

        IPersonaConsumer<String> consumer1 = new PersonaConsumerImpl();

        LOG.info("Consumer Clase");

        consumer1.accept(" Marco Pineda");

        // Lambdas

        IPersonaConsumer<String> consumer2 = cadena -> {
            LOG.info("1");
            LOG.info(cadena);
        };

        LOG.info("Consumer lambda");

        consumer2.accept("Marco Pineda 2");

        // Metodo referenciado

        IPersonaConsumer<String> consumer = metodoReferenciado::consumir;

        LOG.info("Consumer Referenciado: ");
        LocalTime origin = LocalTime.now();
        consumer.accept("0123456789");
        LocalTime fin = LocalTime.now();

        LOG.info("Hilo espero de:" + origin + " a " + fin);

        // 3. PREDICATE

        IPersonaPredicate<Integer> predicate = valor -> valor.compareTo(8) == 0;

        IPersonaPredicate<Integer> predicate2 = valor -> {
            Integer valor2 = 10;

            valor = valor + valor2;

            return valor >= 100;
        };

        IPersonaPredicate<String> predicate3 = letra -> "Marco".contains(letra);

        LOG.info("Predicate lambda: " + predicate.evaluar(4));

        LOG.info("Predicate2 lambda: " + predicate2.evaluar(90));

        LOG.info("Predicate3 lambda: " + predicate3.evaluar("a"));

        IPersonaBiPredicate<String, String> biPredicate = (string, charr) -> string.contains(charr);

        LOG.info("BiPRedicate lambda: " + biPredicate.eval("marco", "r"));

        // metodo referenciado

        IPersonaPredicate<Integer> predicate4 = metodoReferenciado::predicate;

        LOG.info("Predicate Referenciado: " + predicate4.evaluar(100));

        // 4. Function

        IPersonaFuntion<String, Integer> function = num -> String.valueOf(num);

        IPersonaFuntion<String, Integer> function2 = numero -> numero.toString() + "valor";

        LOG.info("Function lambda: " + function.aplicar(8));
        LOG.info("Function2 lambda: " + function2.aplicar(10));

        // Metodo referenciado

        IPersonaFuntion<Character[], String> function3 = metodoReferenciado::function;

        LOG.info("Function metodo referenciado: string" +"->" + function3.aplicar("string"));

        // 5. Unary operator

        IPersonaUnaryOperator<Integer> unary = numero -> (int) Math.sqrt(numero);

        LOG.info("Unari lambda: " + unary.aplicar(100));

        IPersonaUnaryOperatorFunction<Integer> unary2 = numero -> (int) Math.sqrt(numero);

        LOG.info("Unari Function lambda: " + unary2.aplicar(100));

        // Metodo referenciado

        IPersonaUnaryOperator <String> unary3 = metodoReferenciado::unary;

        LOG.info("Unary metodo referenciado: abcd ->"+ unary3.aplicar("abcd"));

    }
}
