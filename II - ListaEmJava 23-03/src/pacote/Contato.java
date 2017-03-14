package pacote;

public class Contato {
	
	String nome;
	int numero;

	/* Construtor ----------------------------------------------------------------------++++++++++++++++++++++++++ */
	public Contato(String nomeDoContato, int numeroDoContato){
		
		nome = nomeDoContato;
		numero = numeroDoContato;
	}
        
        /* Sobrescrita do toString() --------------------------------------------------------++++++++++++++++++++++++++ */
        /* Era assim:
        public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
        }
        Agora, sobrescrito, será assim: */
        public String toString(){
            return "Nome: " + nome + "\nNúmero: " + numero;
        }
        
        /* Sobrescrita do equals() --------------------------------------------------------++++++++++++++++++++++++++ */
        public boolean equals(Object outroObjeto){
            
            if(outroObjeto != null){ // Se o objeto passado no parâmetro for válido (não nulo)
                
                if(outroObjeto instanceof Contato){ // Se for do mesmo tipo (instância de Contato, ou seja, se for um objeto de Contato).
                    
                    Contato outroContato = (Contato)outroObjeto; // Fazendo a conversão(cast) forçada
                    if(this.nome.equals(outroContato.nome)){ // Se o campo nome for igual ****** Isso é uma chamada recursiva sem fim!! Ih
                        
                        if(this.numero == outroContato.numero){ // Se o campo numero for igual
                            return true; // Os objetos são iguais de fato.
                        }
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }else{ // Senão...ou seja, se o objeto for null
                return false;
            }
            
            return false; // Estava dando erro quando não tinha esse retorno aqui? Por quê?
        } // Fim do equals()
        
	
} // Fim da classe 
