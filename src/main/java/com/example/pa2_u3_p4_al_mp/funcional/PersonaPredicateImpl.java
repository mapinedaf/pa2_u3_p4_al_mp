package com.example.pa2_u3_p4_al_mp.funcional;

public class PersonaPredicateImpl  implements IPersonaPredicate<Integer>{

    @Override
    public boolean evaluar(Integer arg) {
        return String.valueOf(arg).charAt(0) == '7';
    }


    
}
