package trabalho_mateus;

import java.util.regex.Pattern;

public class operacoes {
    
    //Binario
    public String binario(String inteiro, String flutuante) {
        
        //Variaveis
        String binario = "";
        String quebrado = "";
        int x = Integer.parseInt(inteiro);
        float y = Float.parseFloat(flutuante);
        
        //Binario inteiro
        if(x != 0) {
            while(x != 1) {
                int antigo = x;
                x = x / 2;
                if((x * 2) == antigo) {
                    binario = "0" +  binario;
                } else {
                    binario = "1" +  binario;
                }
            }
            binario = "1" + binario;
        } else {
            binario = "0";
        }

        //Ponto flutuante de binario
        for(int t = 0; t < 10; t++) {
            int contador = 0;
            while(y != 1) {
                y = 2 * y;
                if(y > 1) {
                    quebrado = quebrado + "1";
                    y = y - 1;
                } else if(y == 1) {
                    quebrado = quebrado + "1";
                    break;
                } else {
                    quebrado = quebrado + "0";
                }
                if(contador == 10) {
                    break;
                }
                contador++;
            }
        }
        return binario + "." + quebrado;
    }
    
    //octal
    public String octal(String inteiro, String flutuante) {
        
        //variaveis
        String octal = "";
        String quebrado = "";
        int x = Integer.parseInt(inteiro);
        float y = Float.parseFloat(flutuante);
        
        //Octal
            if(x != 0) {
                if(x >= 8) {
                    while(x >= 8) {
                        int antigo = x;
                        x = x / 8;
                        if(antigo == (x * 8)) {
                            octal = "0" + octal;
                        } else if (antigo >= (x * 8)) {
                            int diferenca = antigo - (x * 8);
                            octal = diferenca + octal;
                        } else if (antigo > 8) {
                            octal = x + octal;
                        }
                    }
                    if(x <= 7) {
                        octal = x + octal; 
                    }
                } else {
                    octal = x + octal;
                }
            } else {
                octal = "0";
            }

            //Flutuante de octal
            if(y != 0) {
                quebrado = "" + (8 * y);
            } else {
                quebrado = "" + 0;
            }
            
            //Conversão para saida de valor
            float finalvalor = (float) (Integer.parseInt(octal) + Float.parseFloat(quebrado));

            String oct = "" + finalvalor;
            
            //Saida
            return oct;
    }
    
    //Hexa
    public String hexadecimal(String inteiro, String flutuante) {
        
        //variaveis
        String hexa = "";
        String quebrado = "";
        int x = Integer.parseInt(inteiro);
        float y = Float.parseFloat(flutuante);
        
        if(y != 0) {
            quebrado = "" + (16 * y);
        } 

        //Soma valores do inteiro + o quebrado
        float quebrado_valor = (float) (x + Float.parseFloat(quebrado));

        String valor_quebrado = "" + quebrado;
        String[] valores = valor_quebrado.split(Pattern.quote("."));
        
        if(valores[1].equals("0")) {
            valores[1] = "";
        } else {
            valores[1] = "." + valores[1];
        }

        //Valor com soma
        x = (int) (quebrado_valor);


            //Converção do valor para hexadecimal
            if(x > 16) {
                while(x > 16) {

                    int diferenca = 0;
                    int antigo = x;
                    x = x / 16;

                    if(antigo == (x * 16)) {
                        hexa = "0" + hexa;
                    } else {

                        String valor = "" + x;

                        diferenca = antigo - (x * 16);

                        //Confirma valores de substituição
                        if(diferenca == 16) {
                            hexa = "1F" + hexa;
                        } else if(diferenca == 15) {
                            hexa = "F" + hexa;
                        } else if(diferenca == 14) {
                            hexa = "E" + hexa;
                        } else if (diferenca == 13) {
                            hexa = "D" + hexa;
                        } else if (diferenca == 12) {
                            hexa = "C" + hexa;
                        } else if (diferenca == 11) {
                            hexa = "B" + hexa;
                        } else if (diferenca == 10) {
                            hexa = "A" + hexa;
                        } else {
                            hexa = diferenca + hexa;
                        }  
                    }

                    if(x < 16) {
                        hexa = x + hexa;
                    }
                }

            //Confirma valores de substituição
            } else if(x == 16) {
                hexa = "1F" + hexa;
            } else if(x == 15) {
                hexa = "F" + hexa;
            } else if(x == 14) {
                hexa = "E" + hexa;
            } else if (x == 13) {
                hexa = "D" + hexa;
            } else if (x == 12) {
                hexa = "C" + hexa;
            } else if (x == 11) {
                hexa = "B" + hexa;
            } else if (x == 10) {
                hexa = "A" + hexa;
            } else {
                hexa = "" + x;
            }
            return hexa + valores[1];
    }
}
