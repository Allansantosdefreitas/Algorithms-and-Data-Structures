package pacote;

public class Teste {
    /*
        construtor - ok
        inserir() - ok
        listar() - ok
        remover() - ok 
        inicializar() - ok
        buscarPeloIndice() - ok
        buscarPeloElemento() - ok
        substituir() - ok
    */
    public static void main(String[] args){
        
        
        Contato contato1 = new Contato("Peter", 900000000);
        Contato contato2 = new Contato("Jonah", 911111111);
        Contato contato3 = new Contato("Isaiah", 922222222);
        Contato contato4 = new Contato("Micah", 933333333);
        Contato contato5 = new Contato("Ruth", 944444444);
        
        Contato contato6 = new Contato("Joshua", 955555555); // Para alguns testes específicos. Não vai entrar na lista (vetor).       
        Contato igualAoContato6 = new Contato("Joshua", 955555555); // Para teste do equals(). Também não entra na lista.
        Contato contatoNulo = new Contato("Teste", 877777777); // Também para teste do equals(), não entra na lista (vetor)
        
        /* Teste do equals() ----------------------------------------------------------------------+++++++++++++++++++++++++ ok
        // Um sendo null (inválido)
        System.out.println("Teste 3 - Equals(): " + contato6.equals(contatoNulo)); // Retorna false, pois um é nulo - Ok
        
        // Objetos diferentes, campos diferentes
        System.out.println("Teste 2 - Equals(): " + contato6.equals(contato5)); // Retorna fale, pois são diferentes - Ok
        
        // Para testar se o equals reconhece como iguais objetos que são diferentes, mas do mesmo tipo e com atributos (campos iguais):
        System.out.println("Teste 1 - Equals(): " + contato6.equals(igualAoContato6)); // Sim ele reconhece como iguais -Ok
        */
        
        Lista listaContatos = new Lista(10); // Declarando e instanciando um objeto do tipo Lista, com capacidadeTotal 10.
        
        /* Testando o inserir(): -------------------------------------------------------------------++++++++++++++++++++++ Ok */
        System.out.println("inserir(): ");
        listaContatos.inserir(contato1); // Peter
        listaContatos.inserir(contato2); // Jonah
        listaContatos.inserir(contato3); // Isaiah 
        listaContatos.inserir(contato4); // Micah
        listaContatos.inserir(contato5); // Ruth
        
        /* Testando o listar() --------------------------------------------------------------------+++++++++++++++++++++++++ Ok */
        System.out.println("Listar depois de inserir: ");
        listaContatos.listar();
 
        System.out.println(" ---------------------------------------\n");
        
        /* Testando o buscarPeloIndice():  ---------------------------------------------------------------++++++++++++++++++++++ Ok 
        
        System.out.println("BuscarPeloIndice(): ");
        System.out.println(listaContatos.buscarPeloIndice(4)); //Isso imprime os campos já que o equals() foi sobrescrito em Contato!
        */
        
        /* Testando o buscarPeloElemento(): ---------------------------------------------------------------++++++++++++++++++++++ Ok
        
        System.out.println("BuscarPeloElemento(): ");
        System.out.println(listaContatos.buscarPeloElemento(contato5)); // Encontrou, retorna o índice. Ok!

        System.out.println(listaContatos.buscarPeloElemento(contato6)); // Não encontrou, retorna  -1. Ok!
        //listaContatos.listar();
        
        /* Testando o inicializar(): -----------------------------------------------------------------------++++++++++++++++++++++ Ok
        
        System.out.println("inicializar(): ");
        listaContatos.inicializar();
        
        System.out.println("Listar depois de inicializar (zerar): ");
        listaContatos.listar();
        */
        
        /* Testando o remover(): --------------------------------------------------------------------------++++++++++++++++++++++ Ok  
        
        System.out.println("Remover(): ");
        System.out.println(listaContatos.remover()); // tirar Ruth
        System.out.println(listaContatos.remover()); // tirar Micah
        System.out.println(listaContatos.remover()); // Tirar Isaiah
        System.out.println(listaContatos.remover()); // tirar Jonah
        System.out.println(listaContatos.remover()); // Tirar Peter
        System.out.println(listaContatos.remover()); // Teste - tentar remover mais (sem ter). Espera-se que retorne null - ok
        System.out.println(listaContatos.remover()); // Teste de novo. Espera-se null - ok
         
        System.out.println("Listar depois de remover: ");
        listaContatos.listar();
        */
        
        /* Testando o substituir(): -----------------------------------------------------------------------+++++++++++++++++++++++ Ok
        
        listaContatos.substituir(0, contato5); // Substituindo por Ruth
        listaContatos.substituir(1, contato5); // Substituindo por Ruth
        listaContatos.substituir(2, contato5); // Substituindo por Ruth
        listaContatos.substituir(3, contato5); // Substituindo por Ruth
        
        //System.out.println(listaContatos.substituir(2, contato5)); // Observando o retorno: retornou 1, então a substituição ocorreu.
        
        System.out.println("Inserindo fora da faixa dos valores inseridos: ");
        System.out.println(listaContatos.substituir(5, contato5)); // Retorna -1.
        
        System.out.println("Inserindo fora dos limites do vetor: "); // Lembrando que o vetor é de tamanho 10
        System.out.println(listaContatos.substituir(50, contato5)); // Retorna -1 da mesma forma.
        
        System.out.println("Listar após substituir: ");
        listaContatos.listar();
        System.out.println(" ----------------------------------\n");
        */
                
    }
    
    
            

}
