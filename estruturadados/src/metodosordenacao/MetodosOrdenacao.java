/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metodosordenacao;

import javax.swing.JOptionPane;

/**
 *
 * @author Multas
 */
public class MetodosOrdenacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        int opcao = -1, troca;
        int[] arrayInicial;
        int[] array;
        String metodo = "", a = "", b = "";
        opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha uma das opções digitando o número correspondente:\n"
                + "\n1: Método por Seleção"
                + "\n2: Método por Inserção"
                + "\n3: Método por Bolha"
                + "\n0: Para sair"));
        while (opcao != 0) {
            final int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantas posições?"));
            array = new int[valor];
            arrayInicial = new int[valor];
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor inteiro para a posição " + (i + 1) + ":"));
            }
            System.arraycopy(array, 0, arrayInicial, 0, valor);
            switch (opcao) {
                case 1:
                    metodo = "Seleção";
                    int menorNumero;
                    for (int i = 0; i < (array.length - 1); i++) {
                        menorNumero = i;
                        for (int j = (i + 1); j < array.length; j++) {
                            if (array[j] < array[menorNumero]) {
                                menorNumero = j;
                            }
                        }
                        if (i != menorNumero) {
                            troca = array[i];
                            array[i] = array[menorNumero];
                            array[menorNumero] = troca;
                        }
                    }
                    break;
                case 2:
                    metodo = "Inserção";
                    for (int i = 0; i < array.length; i++) {
                        int j = i;
                        while ((j != 0) && (array[j] < array[j - 1])) {
                            troca = array[j];
                            array[j] = array[j - 1];
                            array[j - 1] = troca;
                            j--;
                        }
                    }
                    break;
                case 3:
                    metodo = "Bolha";
                    for (int i = 1; i < valor; i++) {
                        int j = i;
                        while (j != 0 && array[j] < array[j - 1]) {
                            troca = array[j];
                            array[j] = array[j + 1];
                            array[j + 1] = troca;
                            j--;
                        }
                    }

                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Por favor escolha uma opção válida!");
            }
            for (int x : array) {
                a = x + "".concat(a);
            }
            for (int y : arrayInicial) {
                b = y + "".concat(b);
            }
            JOptionPane.showMessageDialog(null, "O método utilizado foi " + metodo + ""
                    + "\nSeu vetor inicial era: " + a + ""
                    + "\nSeu vetor final é: " + b + "");
            opcao = 0;
        }
    }
}
