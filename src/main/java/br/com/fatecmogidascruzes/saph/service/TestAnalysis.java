/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Leandro Luque
 */
public class TestAnalysis {

    private Map<Integer, List<Boolean>> mapProb;
    private boolean[][] combinacoes;

    public TestAnalysis() {

        mapProb = new HashMap<Integer, List<Boolean>>();
    }

    public Double getProbability(Integer nHit, List<TestProbability> rdmProb) {

        mapProb = new HashMap<Integer, List<Boolean>>();
        Double returnProb = 0.0;

        gerarMatrizCombinacional(rdmProb.size(), nHit);

        for (int i = 0; i < mapProb.keySet().size(); i++) {
            returnProb += obterProbParcial(rdmProb, mapProb.get(i));
        }
        return returnProb;
    }

    private Double obterProbParcial(List<TestProbability> rdmProb, List<Boolean> combinacao) {
        Double retorno = 1.0;

        for (int i = 0; i < rdmProb.size(); i++) {
            if (combinacao.get(i)) {
                retorno *= rdmProb.get(i).getHitProbability();
            } else {
                retorno *= rdmProb.get(i).getMissProbability();
            }
        }
        return retorno;
    }

    private void gerarMatrizCombinacional(Integer nQuestions, Integer nHits) {
        combinacoes = gerarCombinacoes(nQuestions, nHits);

        for (int i = 0; i < combinacoes.length; i++) {
            for (int j = 0; j < combinacoes[i].length; j++) {
                System.out.print(combinacoes[i][j] ? "1" : "0");
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    /**
     * Gera uma combinação de N elementos tomados p a p.
     *
     * @param N O valor de N.
     * @param p O valor de p.
     * @return Uma matriz com todas as combinações.
     */
    private boolean[][] gerarCombinacoes(int N, int p) {
        // Cria a matriz de retorno.
        int quantidadeCombinacoes = fatorial(N) / (fatorial(N - p) * fatorial(p));
        boolean[][] retorno = new boolean[quantidadeCombinacoes][N];
        int linhaAtual = 0;

        if (p == 0) {
            mapProb.put(0, new ArrayList<Boolean>());
            
            for(int i = 0; i < N; i++){
                retorno[0][i] = false;
                mapProb.get(0).add(false);
            }
            return retorno;
        } else {

        // Preenche a matriz.
            // Gera todas as possíveis posições dos 1s.
            int[] posicao = new int[p];
            for (int i = 0; i < p; i++) {
                posicao[i] = i;
            }
        // O algoritmo seguinte gera números conforme os seguintes - para um
            // exemplo de combinação(5, 3).
            // 1 2 3
            // 1 2 4
            // 1 2 5
            // 1 3 4
            // 1 3 5
            // 1 4 5
            // 2 3 4
            // 2 3 5
            // 2 4 5
            // 3 4 5
            adicionaCombinacao(retorno, linhaAtual++, posicao);
            // Enquanto não gerar a última posição.
            while (posicao[0] != (N - p)) {
                int i = p - 1;
                while (i >= 0) {
                    if (posicao[i] < (N - p + i)) {
                        posicao[i]++;
                        // Atualiza as posições à direita da atual.
                        for (int j = i + 1; j < p; j++) {
                            posicao[j] = posicao[j - 1] + 1;
                        }
                        break;
                    } else {
                        i--;
                    }
                }
                adicionaCombinacao(retorno, linhaAtual++, posicao);
            }

            for (int k = 0; k < quantidadeCombinacoes; k++) {
                mapProb.put(k, new ArrayList<Boolean>());
                for (int l = 0; l < N; l++) {
                    mapProb.get(k).add(retorno[k][l]);
                }
            }
            return retorno;
        }
    }

    /**
     * Adiciona à matriz de combinações (combinacoes), na linhaAtual
     * (linhaAtual), uma combinação com valores iguais a 1 nas posições
     * (posicoes).
     *
     * @param combinacoes A matriz de combinações.
     * @param linhaAtual A linha atual da matriz de combinações onde será feita
     * a adição da combinação.
     * @param posicoes As posições que possuem valores iguais a 1 na combinação.
     */
    public static void adicionaCombinacao(boolean[][] combinacoes, int linhaAtual, int[] posicoes) {
        for (int i = 0; i < posicoes.length; i++) {
            combinacoes[linhaAtual][posicoes[i]] = true;
        }
    }

    /**
     * Retorna o fatorial do número i.
     *
     * @param i O número do qual se deseja calcular o fatorial.
     * @return O fatorial do número i.
     */
    public static int fatorial(int i) {
        if (i == 0) {
            return 1;
        }
        int fatorial = 1;
        for (int j = 2; j <= i; j++) {
            fatorial *= j;
        }
        return fatorial;
    }
}
