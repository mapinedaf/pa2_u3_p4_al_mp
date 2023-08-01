package com.example.pa2_u3_p4_al_mp.funcional;

public class MetodoReferenciado {

    public Integer getId(){
        return 8;
    }
    

    public void consumir(String word){
        try {
            Thread.sleep(word.length()*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean predicate(Integer integer){

        return integer%3 ==0;
    }
}
