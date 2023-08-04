package com.example.pa2_u3_p4_al_mp.repository;


import com.example.pa2_u3_p4_al_mp.funcional.IPersonaFuntion;

public class PersonaFunctionImpl implements IPersonaFuntion<Character[], String>{

    @Override
    public Character[] aplicar(String arg) {

        Character[] arr =new Character[ arg.length()];

        for (int i =0; i< arr.length; i++){
            arr[i] = arg.charAt(i);
        }

        return arr;
    }
    
}
