package pacote;

/* Implementar minha própria "arrayList":
 * - Inicializar;
 * - Inserir no fim da lista;
 * - Listar;
 * - Buscar pelo índice e pelo elemento;
 * - Remover só no final e retorna o elemento removido pra o usuário;
 * - Substituir pelo índice. 
 * 
 *  Obs.: 
 *  	- Sobrescrever equals() no Contato;
 *  	- Sobrescrever toString() no Contato;
 *  	- Todos os métodos dever ser dinâmicos.
 *  	- Comentar a estratégia do algoritmo nos métodos.
 *  
 *  	- Não retorna o array de contato, nem passa como parâmetro de método nenhum

    Diário +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        Ao inserir um Contato na lista, ocorre o nullPointerException.
        22 Mar, 2016

        Que bom!!! :) Isso já solucionamos. O problema é que estava instanciando um outro array
        e o array do atributo estava null ainda, pois não havia sido instanciado.
        O problema agora é no remover, que também dá nullPointerException. Bora fazer isso hoje que
        está mais perto do que longe
        23 Mar, 2016 - 10:30
        
        Bem...todos os métodos já foram testados, tudo concluído.
        23 Mar, 2016 - 20:51

 * */
public class Lista {
	
    int capacidadeTotal; // Constante para a capacidade total da lista
    int qtdInseridos; /* Variável para armazenar a quantidade de elementos inseridos na lista. Utilizada para
    navegar no vetor */
    Contato[] vetor; // Declarando o vetor de Contato. Ainda não instanciado, ainda sem tamanho.
	
    // Construtor --------------------------------------------------------------------------------###########++++++++++
    /* Construtor que dá o tamanho inicial do array e chama o método inicializar() */
    public Lista(int tamanhoVetor){
        
        this.capacidadeTotal = tamanhoVetor;
	/* Instanciando o Array (que já foi declarado)do tipo Contato com o tamanho recebido */
        vetor = new Contato[capacidadeTotal];  // Se capacidadeTotal for final, essa linha não funciona? Por quê?
	this.inicializar();	
    }
    
    // inicializar() ----------------------------------------------------------------------------------------++++++++++
    /* Método para zerar a lista: zera a quantidade de elementos inseridos e zera (null) o valor de todos elementos */
    public void inicializar(){
        
        for(int i = 0; i < this.qtdInseridos; i++){
            this.vetor[i] = null; // Deveria zerar o valor dos atributos de Contato individualmente: vetor[i].nome ??? Testaremos pra ver;
            //this.vetor[i].nome = " ";
            //this.vetor[i].numero = 0;
	}
        this.qtdInseridos = 0;
        
    }
	
    // inserir() ---------------------------------------------------------------------------------------------++++++++++
    /* Insere na próxima posição livre do vetor */
    public void inserir(Contato contato){
        this.vetor[qtdInseridos] = contato;
        this.qtdInseridos++; // Passa para a próxima casa (posição)livre do vetor
    }
    
    // listar() ----------------------------------------------------------------------------------------++++++++++
    /* Listar todos os contatos */
    public void listar(){
        for(int i = 0; i < qtdInseridos; i++){
            System.out.println(this.vetor[i].nome + " " + this.vetor[i].numero); // É assim mesmo? Tem alguma forma melhor
        }
    }
    
    // buscarPeloIndice() ------------------------------------------------------------------------------++++++++++
    /* Buscar pelo índice e retornar o elemento Contato encontrado */
    public Contato buscarPeloIndice(int indice){ // A alternativa a isso seria imprimir na tela o contato encontrado
        // Verificar se está dentro do limite do vetor, desde o índice 0 até ao índice associado ao último valor inserido
        if(indice >= 0 && indice < this.qtdInseridos){
            return this.vetor[indice];
            
        }else{ // Caso falhe, na tentativa de buscar fora (além) dos limites dos valores inseridos no vetor, ou até fora do vetor.
            return null; 
        }
         
    }
    
    // buscarPeloElemento() ----------------------------------------------------------------------------------------++++++++++
    /* Buscar pelo elemento e retornar o índice associado a esse elemento ou -1 caso não encontre o elemento */
    public int buscarPeloElemento(Contato contato){ 
        int i; 
        for(i = 0; i < qtdInseridos; i++){ // Percorre até a quantidade de inseridos(o que já é suficiente), não o vetor todo.
            if(this.vetor[i].equals(contato)){ // O equals() já está sobrescrito em Contato
                return i;  // Retornar o índice associado ao elemento encontrado
            }
        }
        return -1;// Retornar -1, indicando que não encontrou o elemento
    }
    // remover() ---------------------------------------------------------------------------------------------------+++++++++++  
    /* Remove o contato da última posição e retorna esse objeto Contato associado a essa posição. Caso não haja elemento para remover
    retorna null, apesar de que seria melhor uma exceção, não é!? É! */
    public Contato remover(){
        
        if(this.qtdInseridos - 1 >= 0){
            Contato contatoParaRetorno = this.vetor[qtdInseridos - 1]; /* Variável provisória do tipo Contato para recebe o contato a 
            ser removido antes que ele seja removido (null) */
            this.vetor[qtdInseridos - 1] = null; // Assim ou pôr null em cada um dos atributos do objeto contato?
            this.qtdInseridos--; // Volta para a casa anterior
            return contatoParaRetorno; // Retornando o contato que já foi removido
        }else{ // Caso não seja possível mais remover (por já haver removido tudo)
            return null;
        }
    }   
    
    // substituir() ------------------------------------------------------------------------------------------------+++++++++++
    /* Substituir pelo índice, recebendo o índice e o novo contato a ser inserido na posição associada esse índice. 
       retorna 1 caso a substituição ocorra e -1, caso não ocorra */
    public int substituir(int indice, Contato novoContato){
        // Se indice estiver de 0 até o índice associado ao último contato inserido
        if(indice >= 0 && indice <= qtdInseridos - 1){ /* Se o índice se referir a algum contato já inserido então pode haver substituição.
            Se, de outro modo, permitisse que a variável indice fizesse referência a qualquer outra posição do vetor (até ao tamanho 
            total), seria possível inserir elementos nas posições disponíveis, usando esse método (substituindo onde fosse null pelo 
            contato do parâmetro), o que não é o objetivo. .Esse método objetiva apenas substituir um contato existente por outro
             contato recebido no parâmetro. 
            Obs.: Da forma que está, é possível usar o substituir() para inserir elementos novos, mas sempre em lugar dos já inseridos */
            this.vetor[indice] = novoContato; // Substituindo o antigo pelo novo contato.
            return 1;
        }else{
            return -1;
        }
    }
	
} // Fim da classe Lista
