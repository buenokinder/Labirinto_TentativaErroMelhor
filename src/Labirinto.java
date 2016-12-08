

public class Labirinto {
	
	public char Percorrido ='d';
	
	public Mapa mapa; 
	
	public Labirinto(Mapa mapa){
		this.mapa = mapa;
	
	}
	public void Inicializar(Posicao _inicial, Posicao Final){
		this.encontarCaminho(_inicial, Final);
		this.mapa.Imprimir();
		
	}
	public boolean encontarCaminho(Posicao _inicial, Posicao _final){
		
		if(!_inicial.IsValid() )
			return false;
		
	    if(!_inicial.IsInsideArray(mapa.linhas-1, mapa.colunas-1))
			return false;
		
		if(!mapa.isFree(_inicial))
			return false;
		
		this.mapa.mapa[_inicial.linha][_inicial.coluna] = TipoElementoLabirinto.Percorrido.asChar();
		
		if(_inicial.Equals(_final))
		{
			this.mapa.mapa[_inicial.linha][_inicial.coluna] = TipoElementoLabirinto.Fim.asChar();
			return true;
		}
		
		if(this.encontarCaminho(_inicial.Mover(Movimento.Melhor,_final), _final))
		{
			this.mapa.mapa[_inicial.linha][_inicial.coluna] = TipoElementoLabirinto.PercorridoCorreto.asChar();
			return true;
		}
		
		if(this.encontarCaminho(_inicial.Mover(Movimento.Direta,_final), _final))
		{
			this.mapa.mapa[_inicial.linha][_inicial.coluna] = TipoElementoLabirinto.PercorridoCorreto.asChar();
			return true;
		}
		if(this.encontarCaminho(_inicial.Mover(Movimento.Esquerda,_final), _final))
		{
			this.mapa.mapa[_inicial.linha][_inicial.coluna] = TipoElementoLabirinto.PercorridoCorreto.asChar();
			return true;
		}
		
		if(this.encontarCaminho(_inicial.Mover(Movimento.Cima,_final), _final))
		{
			this.mapa.mapa[_inicial.linha][_inicial.coluna] = TipoElementoLabirinto.PercorridoCorreto.asChar();
			return true;
		}
		
		if(this.encontarCaminho(_inicial.Mover(Movimento.Baixo,_final), _final))
		{
			this.mapa.mapa[_inicial.linha][_inicial.coluna] = TipoElementoLabirinto.PercorridoCorreto.asChar();
			return true;
		}
		
		return false;
	}
}
