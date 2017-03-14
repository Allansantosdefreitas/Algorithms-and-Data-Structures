package myPackage;

public class Teste {
	
/* +) Métodos para implementar: 
    *  inserirInicio() - Ok
    *  inserir() - em qualquer posicao - Ok
    *  inserirNoFim() - Ok
    *  removerInicio() - Ok
    *  remover() de qualquer posição - Ok
    *  removerNoFim() - Ok
    *  imprimeLista() - Ok 
    *  localizarElemento() - Ok 
*/

    public static void main(String[] args) {

            // Testando inserirInicio()---------------------------------
            ListaLigada lista = new ListaLigada();
            
            // Testando inserir() em qualquer posição --------------------------------------------- Ok
            /*
            lista.inserirInicio(2);
            lista.inserirInicio(3);

            System.out.println("Imprimir primeira vez: ");
            lista.imprimeLista();
           
            // Teste I --------------
            System.out.print("Inserir 7 na posição 0: ");
            System.out.println(lista.inserir(7, 0)); // insere "empurrando"
            lista.imprimeLista(); // Espera-se: [7, 3, 2] - Ok
            
            // Teste II -----------
            System.out.print("Inserir 8 na posição 1: ");
            System.out.println(lista.inserir(8, 1)); // insere "empurrando"
            
            //Teste: System.out.println(lista.localizarElemento(2).consultaDado()); // Não tem elemento na posição 2, não está ligando
            lista.imprimeLista(); // Espera-se: [7, 8, 3, 2] - Ok*/

            /* Teste III ------------ Inserir fora da lista (posição positiva) - Ok 
            lista.inserirInicio(2);
            lista.inserirInicio(3);
            
            System.out.println("Imprimir primeira vez: ");
            lista.imprimeLista();

            System.out.println("Inserir fora da lista (positivo): " + lista.inserir(9, 2)); // Fora da lista (positivo).
            
            System.out.print("Imprimir de novo: ");
            lista.imprimeLista(); // Espera-se: [3,2] */
            
            
            
            /* Teste IV ------------ Posição negativa - Ok :)
            lista.inserirInicio(2);
            lista.inserirInicio(3);

            System.out.println("Imprimir primeira vez: ");
            lista.imprimeLista();

            System.out.println("Inserir em posição negativa: " + lista.inserir(9, -1)); // Fora da lista (negativo). Ocorre erro
            System.out.print("Imprimir de novo: ");
            lista.imprimeLista(); // Espera-se: [3,2]
            */
            
            /* Testando removerInicio() --------------------------------------------- Ok 
            
            lista.inserirNoFim(5);
            lista.inserirNoFim(6);
            lista.inserirNoFim(7);
            lista.inserirNoFim(8);
            
            lista.removerInicio();
            lista.removerInicio();
            lista.removerInicio();
            lista.removerInicio();
            lista.removerInicio();
            lista.removerInicio();

            lista.imprimeLista();
            */
            // Testando localizarElemento() -------------------------------------------- Ok

            //System.out.println(lista.localizarElemento(2));
            
            
            /* Testando inserirNoFim() ---------------------------------------------------- Ok 
            
            lista.inserirNoFim(8);
            lista.inserirNoFim(9);
            lista.inserirNoFim(10);
            lista.inserirNoFim(12);

            lista.imprimeLista(); 
            */
             /* Testando removerNoFim() ---------------------------------------------------- Ok 
            
            lista.inserirNoFim(8);
            lista.inserirNoFim(9);
            lista.inserirNoFim(10);
            lista.inserirNoFim(12);
            
            lista.removerNoFim();
            lista.removerNoFim();
            lista.removerNoFim();
            lista.removerNoFim();
            lista.removerNoFim();
            lista.removerNoFim();
           
            lista.imprimeLista(); 
            */
            
            /* Testando remover() em qualquer posição ----------------------------------------- Ok, passou */
            
            lista.inserirNoFim(6);
            lista.inserirNoFim(7);
            lista.inserirNoFim(8);
            lista.inserirNoFim(9);
            
            System.out.println("Antes de remover: ");
            lista.imprimeLista(); 
            
            
            //lista.remover(0); // Remove do iníco, ok
            //lista.remover(1); // Ok
            lista.remover(2); // Tira o 8
            //lista.remover(3); // Tira o 9
            //System.out.println("retorno: " + lista.remover(4)); // Posição inválida

            System.out.println("Após remover: ");
            lista.imprimeLista(); 
            

            
            
            
            
            
            
            
            
            
            
    }
}
