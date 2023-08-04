package com.example.pa2_u3_p4_al_mp.funcional;

public class PersonaUnaryOperatorImpl  implements IPersonaUnaryOperator<String>{

    @Override
    public String aplicar(String arg) {
        return arg +arg; 
    }


    
}
