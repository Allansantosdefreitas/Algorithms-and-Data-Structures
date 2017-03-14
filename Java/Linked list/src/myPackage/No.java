package myPackage;

public class No
{
        /* Atributos -----------------------------------------------++++++++++++++ */ 
	int dado; // Valor
	No proximo; // Referência para o próximo Nó da lista
	
	
        /* Construtor -----------------------------------------------++++++++++++++ */ 
	// Construtor do No
	public No(int valor)
	{
		dado = valor; // só pra deixar explícito:
		proximo = null;
	}
	
	/**
	 * Faz (ou refaz) a ligação entre dois nós.
	 * Se o parâmetro for null, apenas corta a última ligação.
	 * 
	 * @param outro
	 */
	
        
        /* Métodos --------------------------------------------------++++++++++++++ */ 

	
        // Consulta o próximo Nó da lista em relação ao atual
	public No consultaProximo()
	{
		return proximo;
	}

        // Define o que será o próximo elemento, substituindo o antigo.
	public void defineProximo(No outro)
	{
		proximo = outro;
	}
	
	// Consulta o valor do Nó (atual da lista).
	public int consultaDado()
	{
		return dado;
	}
        
        // Define o valor do Nó da lista
        public void defineDado(int novoDado){
            this.dado = novoDado;
        }


}