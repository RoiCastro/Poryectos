/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aforcado;

import java.text.Normalizer;

/**
 * Clase que representa a palabra oculta nun xogo de Aforcado. 
 * Xestiona a lóxica para verificar acertos e mostrar os avances.
 * 
 * @author roi.castrocalvar
 */
public class HiddenWord {

    private char[] characters; // Array que almacena os caracteres da palabra oculta.
    private boolean[] hits; // Array que indica se cada letra foi acertada (true) ou non (false).

    /**
     * Construtor que inicializa os arrays de caracteres e acertos en función da palabra dada.
     * 
     * @param word A palabra oculta que hai que adiviñar.
     */
    public HiddenWord(String word) {
        characters = word.toCharArray();
        hits = new boolean[characters.length]; // Inicializa o array de acertos con todos os valores a false.
    }

    /**
     * Comproba se un caracter aparece na palabra oculta, 
     * marcando todas as súas aparicións como acertadas.
     *
     * @param c O caracter que se desexa comprobar. Necesita estar en minuscula
     * @return true se o caracter aparece na palabra, false en caso contrario.
     */
    public boolean checkChar(char c) {
        boolean found = false;
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] ==  c) {
                hits[i] = true; // Marca esta letra como acertada.
                found = true;
            }
        }
        return found;
    }

    /**
     * Devolve a palabra oculta mostrando só os caracteres acertados, 
     * substituíndo os non acertados por guións.
     *
     * @return Unha cadea de texto coa palabra parcial (caracteres acertados e guións).
     */
    public String show() {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < characters.length; i++) {
            resultado.append(hits[i] ? characters[i] : '-'); // Engade a letra se foi acertada ou un guión en caso contrario.
        }

        return resultado.toString();
    }

    /**
     * Devolve a palabra completa, incluíndo todos os seus caracteres sen ocultar.
     *
     * @return A palabra completa como unha cadea de texto.
     */
    public String showFullWord() {
        return new String(characters); // Constrúe e devolve unha cadea cos caracteres da palabra oculta.
    }

    /**
     * Indica se a palabra é completamente visible, 
     * é dicir, se todos os seus caracteres foron acertados.
     *
     * @return true se todos os caracteres foron acertados, false en caso contrario.
     */
    public boolean isVisible() {
        for (boolean hit : hits) {
            if (!hit) return false; // Se hai algún caracter sen acertar, devolve false.
        }
        return true; // Todos os caracteres foron acertados.
    }
}
