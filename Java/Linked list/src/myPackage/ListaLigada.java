package myPackage;

/* 
+) Métodos para implementar: 
    *  inserirInicio() - Ok
    *  inserir() - em qualquer posicao - Ok
    *  inserirNoFim() - Ok
    *  removerInicio() - Ok
    *  remover() de qualquer posição - Ok
    *  removerNoFim() - Ok
    *  imprimeLista() - Ok 
    *  localizarElemento() - Ok 
    *
    *  Métodos auxiliares:  
    *       estaVazia() - Ok
    *       temElemento() - Ok
    *       posicaoValida() - Ok
    *
    *
+) Diário:
    O localizar já está funcionando, falta implementar o inserir em qualquer posição (que usa o localizar)
    (12/05/16 - 22:40)
    Pronto!, o inserir() já está funcionando. Até comecei a fazer o inserirNoFim, mas na verdade o próximo passo é 
    implementar o remover() de qualuquer posição.
    (14/05/16 - 00:21)
    Bem, o inserirNofim() e o removerNoFim já foram implementados e testados :); falta apenas o remover() de qualquer posição
    (19/05/16 - 00:05)
    Bem, terminamos o método remover() de qualquer posição e fizemos os devidos testes na classe Teste. O pretendido era fazer até 
    aqui, mas ainda as possibilidades a se acrescentar são imensas e isso é que é o interessante. :)
    (19/05/16 - 23:24)
*/

public class ListaLigada {

	private No head; /* Head aponta para o primeiro elemento da lista */  
        private int tamanho; /* Variável que armazena o tamanho da lista */
        String separador; /* Para imprimir um separador na impressão da lista (meramente estético) */ 
        
        
        /* Construtor -----------------------------------------------------------------------------------------++++++++++++++++++++++++++++++++++ */ 
	public ListaLigada() {
            this.tamanho = 0;
            
            /* Estética: Atribuindo o valor do separador, usado na impressão */
            separador = ", ";
                
	}

        /* Métodos ---------------------------------------------------------------------------------------------+++++++++++++++++++++++++++++++++ */
        
        /* reemover() de qualquer posição --------------------------------------------------------
        Algoritmo - alternativo (não usado):
            1. Se a lista esta vazia:
                1. Fim (erro)
            2. Senão se tamanho == 1 e posicao == 0:
                1. inserirInicio(valor)
                2. Fim (o método acima já decrementa tamanho)
            3. Senão se a posição for válida (estiver entre 0 e tam - 1):
                1. Pega o atual (localizarElemento(posicao))
                2. Pega o anterior do atual (localizarElemento(posicao - 1))
                3  Anterior passa a apontar para onde o atual apontava (anterior.proximo = atual.proximo)
                4. Decrementa tamanho.
                5. Fim
            4. Fim :) 
        Algoritmo 2 - Esse foi usado
        1. Se a lista tem elemento:
            1. Se posição for válida:
                1. Se posicao == 0:
                    1. inserirInicio(valor)
                    2. Fim (o método acima já decrementa tamanho)
                2. Senão (se for inserir em qualquer outra posição válida): 
                    1. Pega o atual (localizarElemento(posicao))
                    2. Pega o anterior do atual (localizarElemento(posicao - 1))
                    3  Anterior passa a apontar para onde o atual apontava (anterior.proximo = atual.proximo)
                    4. Decrementa tamanho.
                    5. Fim
            2. Senão:
                1. Fim (Erro)
        2. Senão:
                1. Fim (Erro) */
        
        public boolean remover(int posicao){
            
            if(this.temElemento()){ // Se tem elemento na lista...
                if(this.posicaoValida(posicao)){// Se a posição estiver entre 0 e tamanho - 1 (intervalo fechado)...
                    if(posicao == 0){ // 
                        this.removerInicio(); // Remove no início, visto que é um caso particular, porque envolve o head da lista
                        return true; // Remoção feita
                    }else{
                        No aRemover = localizarElemento(posicao); // Pega o elemento a remover (atual)
                        No anterior = localizarElemento(posicao - 1); // Pega o elemento anterior ao que se vai remover
                        
                        anterior.proximo = aRemover.proximo; // Anterior aponta para onde o atual (aRemover) aponta
                        this.tamanho--; // Diminui o tamanho da lista
                        return true; // Remoção feita
                    }
                }else{ // Se a posição não for válida...
                    return false; // Erro, não insere
                }
            }else{ // Se a lista não tem elemento (se está vazia)
                return false; // Erro, não insere
            }
            
        } // Fim do métod remover()
        
        
        public boolean removerNoFim() {
            
            /* Se a lista estiver vazia... */
            if(this.estaVazia()){
                
                return false; /* Não faz nada */
            }else if(this.tamanho == 1){ /* Se a lista tiver um elemento */
               removerInicio(); /* Remove do início */
               /* Não precisa decrementar this.tamanho, pois o método acima já faz isso */
               return true; /* Operação realizada com sucesso */
            }else{ /*if(this.tamanho > 1){  //Se tiver mais de um elemento na lista */
                No ultimoNo = localizarElemento(this.tamanho - 1); /* Pegando o último nó */
                No penultimoNo = localizarElemento(this.tamanho - 2); /* Pegando o penúltimo nó */
                
                penultimoNo.proximo = null; /* Penúltimo nó aponta para null */
                this.tamanho--; /* Decrementa tamanho */
                return true; /* Operação realizada com sucesso */
                
            }
            
             
	} // Fim do método removerNoFim()
        
        
        /* inserirNoFim(valor) --------------------------------------------------------------------
            1. Se (lista está vazia)
                1. Insere no início (posição 0)
            2. Senão
                1. Declara e instancia o novo nó com o valor recebido do método
                2. localiza último elemento (tamanho - 1)
                3. faz esse elemento apontar para o novo nó
                4. Incrementa tamanho
            3. Fim
        */
        public boolean inserirNoFim(int valor) {
            
            /* Se a lista estiver vazia... */
            if(this.estaVazia() == true){
                inserirInicio(valor); /* Insere no início */
                return true; /* Confirma que um novo nó foi inserido na lista */
            }else{
                No novoNo = new No(valor); /* Declarando novo nó e inicializando com o valor recebido do método */
                No noUltimo = localizarElemento(this.tamanho - 1); /* Pega o elemento anterior à posição tamanho (o último) */
                
                noUltimo.proximo = novoNo; /* O último nó aponta para o novo nó. A partir daí o último elemento é novoNo */
                this.tamanho++; /* Incrementa o tamanho, pois mais um elemento (nó) foi inserido. */
                return true; /* Confirma que um novo nó foi inserido na lista */
            }
            
             
	} // Fim do método inserirNoFim()
        
        
        /** 
	 * Insere um valor numa posição específica da lista. A posição precisa
	 * ser válida: entre zero e (N-1) (inclusive), onde N é a quantidade de
	 * elementos que foram inseridos na lista. Se a posição for inválida, não 
         * insere, retorna false (falha a operação)
	 *         
	 * @param valor
	 *            O dado a ser inserido.
	 * @param posicao
	 *            Local na lista onde o dado será inserido.
         * @return true, caso insira com sucesso e false, caso contrário.
	 */
        /*
             1. Se tamanho da lista for igual a 0 e posição também for 0 (ou se lista está vazia e posição for 0)
         *        1. insere no início (chama inserirInicio())
         *        2. //Não precisa incrementar tamanho, pois o método inserirInicio() já o faz.
         *        3. retorna true (inserção feita com suceesso)
         *  2. Senão se (a posição for válida (posicaoValida() == true))
         *        1. Pega o nó anterior (com localizarElemento(posicao - 1))
         *        2. Anterior aponta para o novo nó (anterior.defineProximo(novoNo))
         *        3. Pega o próximo nó (com localizarElemento(posicao + 1))
	 *        4. Novo nó aponta para o próximo (novoNo.defineProximo(proximo))
	 *        5. Incrementa this.tamanho 
         *        6. Retorna true (inserção feita com suceesso)
         *  3. Senão (ou seja, se a posição não for válida)
         *        1. Retorna false (Falha. inserção não realizada)
         *  
         *  4. Fim algoritmo :) */
        
	public boolean inserir(int valor, int posicao) {
            
            /* Se lista está vazia e for inserir na primeira posição (posição 0) OU se, independente disso, for inserir na posição 0*/
            if((estaVazia() == true && posicao == 0) || posicao == 0){
                inserirInicio(valor); /* Insere o valor no início */
                /* inserirInicio() já incrementa this.tamanho */
                return true; /* Inserção feita */
                
            }else{ /* Pode inserir no meio, no fim  ou não inserir */
                
                /* Se a posição for válida (entre 0 e tamanho -1) */
                if(posicaoValida(posicao)){ // Equivale a: se posicaoValida() == true
                    /* Declara e instancia o novo nó com o valor recebido do método */
                    No novoNo = new No(valor); 

                    No anterior = localizarElemento(posicao - 1); /* Pega o nó anterior */
                    No antigoProximo = anterior.proximo;
                    anterior.defineProximo(novoNo); /* Nó anterior aponta para o novo nó */

                    //No proximo = antigoProximo; /* Pega o próximo nó */
                    /* Novo nó que irá ficar no meio */
                    novoNo.defineProximo(antigoProximo); /* novoNo aponta para o antigo próximo */
                    
                    this.tamanho++; /* Incrementa tamanho */
                    return true; /* Inserção feita com sucesso */
                    
                }else{ /* Se a posição for inválida */
                    return false; /* Operação falhou, inserção não feita */
                }
            }  
	} // Fim do método inserir()
        
        /*localizarElemento ------------------------------------------------------------------------------------------ */
        /* se a lista não está vazia e a posição é válida 
            percorra até achar o elemento e retorne a referência dele. 
        Esse método dever ser privado (porque retorna o No) e ser usado como método auxiliar */
        public No localizarElemento(int posicaoABuscar) {
            
		No atual = this.head; /* atual aponta para o primeiro elemento da lista. this.head equivale a head (atributo da classe) */
                
                /* Se tem elemento na lista e a posição a buscar for válida... */
                if(temElemento() == true && posicaoValida(posicaoABuscar)){
                    
                    /* Enquanto atual não for null */
                    for(int posicaoAtual = 0; atual != null; posicaoAtual++){
                    
                        if(posicaoABuscar == posicaoAtual){ /* Se encontrar a posição desejada... */
                            return atual; /* Retorna o próprio nó atual */
                        }
                        
                        /* Atual aponta para o próximo elemento da lista */
                        atual = atual.consultaProximo(); 
                    }
                    /* Não achou, retorna null */
                    return null;
                }else{
                    return null;
                }
	}
        
        // Imprime todo os nós da lista() ---------------------------------------------------------------------------
	public void imprimeLista() {
		// se a lista estiver vazia...
		if (estaVazia()) {
			// imprime "Vazia" e pronto. Termina.
			// System.out.println("Lista vazia.");
			System.out.println("[]");
		}
		else { 	// senão
			
			// varre os elementos imprimindo um por um:
			No atual;
			atual = head; /* Variável atual aponta para o primeiro elemento da lista */

                        /* Estética: Imprime o separador */
			System.out.print("[");
                        
			/* enquanto não terminei a lista... */
			while (atual != null) { /* Enquanto atual não for null */
				// imprime o elemento atual
				int valor = atual.consultaDado(); /* Retorna o dado daquele nó (do nó atual); guarda na variável valor */
				System.out.print(valor); /* Imprime o valor consultado */

				/* Estética: se não for o último, imprime ", " */
				if (atual.consultaProximo() != null) {
					System.out.print(separador); /* System.out.print(", "); */
				}

				// vai para o próximo elemento...
				atual = atual.consultaProximo(); /* atual passa a referenciar o próximo nó (elemento) da lista */

				/* até terminar a lista */
			}
                        
                        /* Estética: Ao terminar a lista, imprime "]"*/
			System.out.println("]");

		}
	}
        
	
	/* Insrir no Início() ----------------------------------------------------------------------------------------
         *
	 * Salva head em uma variável novoInicio; Instancia o novo nó; Novo nó
	 * aponta para a variável novoInicio; Head aponta para o novo nó;
	 */
	public void inserirInicio(int valor) {
		
		// copiando dados e criando o novo nó
		No antigoInicio = this.head;
		No novoNo = new No(valor);

		// modificando a estrutura da lista
		novoNo.defineProximo(antigoInicio); /* O próximo será o nó que head apontava. Se não houver elemento ainda,  o próximo será null */
		this.head = novoNo; /* head (Cabeça da lista) aponta para o nó inserido */
                
                this.tamanho++;
	}

	// Remover do Início() ----------------------------------------------------------------------------------------
	public int removerInicio() {
		// inicio: null
		No inicio = null;

		// se não está vazia:
		// if(this.head != null)
		if (temElemento()) { /* Estava assim: if (estaVazia() == false) */
			// guarda o inicio da lista pra poder usar depois.
			inicio = this.head;

			// mudar a estrutura da lista aqui:
			// diz que o início agora Ã© a partir do segundo elemento...
			this.head = this.head.consultaProximo();

			// se fosse em c/c++: precisaria fazer o free aqui
			// int valor = inicio.consultaDado();
			// free(inicio);
			// return valor;
                        
			this.tamanho--; // Tamanho diminui, porque um elemento foi tirado
                        
                        return inicio.consultaDado();
		}

		// retorna o valor no início da lista
		return 0;
	}

	// posicaoValida() Verifica se a posição não ultrapassa os limites da lista ---------------------------------------------------
        /* Se posicao for maior ou igual a zero e for menor que o tamanho da lista. Ou seja, a posição é válida se
           estiver de 0 até tamanho -1 (inclusive os extremos, intervalo fechado)
           
            Este método será usado como auxiliar quando no método que localiza um elemento por posição
            
        */
        private boolean posicaoValida(int posicao) {
            if(posicao >= 0 && posicao < this.tamanho){
                return true; /* Posição é válida */
            }else{
                return false; /* Posição não é válida */
            }
        }
        
	// temElemento() Verifica se a lista tem algum elemento --------------------------------------------------------------------
	private boolean temElemento() {
                
            /* Se a lista não estiver vazia, tem elemento */  
            return !estaVazia(); /* Observe o operador lógico de negação*/
            
            /* Poderia ser:
                if(estaVazia() == false){
                    return true;
                }else...
            */
	}

	// estaVazia() Verifica se a lista está vazia --------------------------------------------------------------------
        /**
         * 
         * @return 
         *      true, caso a lista esteja vazia e false, caso haja elemento na lista
         *      
         */
	private boolean estaVazia() {
		return head == null; // Retorna true ou false
	}
	
	
	public void setSeparador(String valor) {
		if (valor != null) {
			separador = valor;
		}
	}
        
        public int consultarTamanho(){
            return this.tamanho;
        }

	/**
	 * Remove um valor numa posiÃ§Ã£o especÃ­fica da lista. A posiÃ§Ã£o precisa
	 * ser vÃ¡lida: entre zero e (N-1) (inclusive), onde N Ã© a quantidade de
	 * elementos que foram inseridos na lista.
	 * 
	 * Se a posiÃ§Ã£o for invÃ¡lida, nÃ£o insere o elemento e falha a
	 * operaÃ§Ã£o.
	 * 
	 * @param valor
	 *            o dado a ser inserido.
	 * @param posicao
	 *            local na lista onde o dado serÃ¡ inserido.
	 */
	/*public No remover(int valor, int posicao) {
		// se a lista nÃ£o Ã© vazia...
		// se a posiÃ§Ã£o Ã© vÃ¡lida...
		// localiza a posiÃ§Ã£o anterior Ã quela onde o nÃ³ serÃ¡ inserido...
		// calcula o novo nÃ³ "prÃ³ximo"
		// cria um novo nÃ³
		// modifica a estrutura da lista.

		// deu carto: Ã³timo! Avisa o usuÃ¡rio.
		//return true;
	}*/
}


/* "Lixo" de Código ------------------------------------------------------------------------------------------++++++++++++++++++++++++++ 


/*localizarElemento ------------------------------------------------------------------------------------------ 
private No localizarElemento(int posicaoABuscar) {

    No atual = this.head; /* atual aponta para o primeiro elemento da lista. this.head equivale a head (atributo da classe) 


    /* Se a lista estiver vazia OU a posição a buscar for inválida...
    /* Se tem elemento e a posição a buscar for válida... 
    if(estaVazia() || (posicaoABuscar < 0 || posicaoABuscar >= this.tamanho)){
        return null;
    }

    for(int posicaoAtual = 0; atual != null; posicaoAtual++){

        /* Se encontrar a posição desejada 
        if(posicaoABuscar == posicaoAtual){ 
            return atual; /* Retorna o próprio nó atual 
        }

        atual = atual.consultaProximo(); /* Atual aponta para o próximo elemento da lista 

    }
    return null;      

    // se a lista não está vazia:
    // percorra até achar o elemento e retorne a referência dele.

} 


public boolean inserir(int valor, int posicao) {

    /* Se lista está vazia e posição for 0
    if(estaVazia() == true && posicao == 0){
        inserirInicio(valor); /* Insere o valor no início 
        /* inserirInicio() já incrementa this.tamanho 
        return true; /* Inserção feita
    }
    /* Senão se (a posição for válida 
    else if(posicaoValida(posicao)){ // Equivale a: se posicaoValida() == true

        /* Declara e instancia o novo nó com o valor recebido do método 
        No novoNo = new No(valor); 

        No anterior = localizarElemento(posicao - 1); /* Pega o nó anterior 
        anterior.defineProximo(novoNo); /* Nó anterior aponta para o novo nó 

        No proximo = localizarElemento(posicao + 1); /* Pega o próximo nó 
        novoNo.defineProximo(proximo); /* novoNo aponta para o próximo nó 

        this.tamanho++; /* Incrementa tamanho 
        return true; /* Inserção feita com sucesso 
    }
    else{ /* Se a lista não está vazia e a posição for 0 E se posição for inválida 
        return false; /* Operação falhou, inserção não feita 
    }
} */