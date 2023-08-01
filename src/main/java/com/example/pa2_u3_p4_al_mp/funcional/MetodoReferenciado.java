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


    public Character[] function(String string){

        Character[] chars = new Character[string.length()];

        for(int i =0; i< string.length(); i++){
            chars[i] = string.charAt(i);
        }

        return chars;
    }

    public String unary(String string){

        Character[] chars = function(string);

        StringBuilder builder = new StringBuilder();

        for(Character c : chars){

            builder.append((char)((int)c.charValue()+1));

        }
        return builder.toString();
    } 
}
