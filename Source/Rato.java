package Source;

public class Rato {
  //atributos
    private final String passo;
    private String mapaGerado[][];

    //construtor
    public Rato(Labirinto mapa){
        passo = "*";
        mapaGerado = mapa.getMapa();

    }

    //metodos
    public boolean acharSaida(char deOndeVeio, int x, int y){
        if (x < 0 || x > 19 || y < 0 || y > 19) {
            return false;
        }else if(mapaGerado[x][y] == "S"){
            return true;
        }else if(mapaGerado[x][y] == "P"){
            return false;
        }else if(mapaGerado[x][y] == passo){
            return false;
        }else{
            mapaGerado[x][y] = passo;
            if ((deOndeVeio != 'b') && acharSaida('c', x+1, y)) {
                return true;

            }else if ((deOndeVeio != 'd') && acharSaida('e', x, y+1)) {
                return true;

            }else if ((deOndeVeio != 'c') && acharSaida('b', x-1, y)) {
                return true;
            
            }else if ((deOndeVeio != 'e') && acharSaida('d', x, y-1)) {
                return true;
            }else{
                mapaGerado[x][y] = ".";
                return false;
            }
            
        }
    }

    public void mostrarCaminho(){
        for (int colunas = 0; colunas < 20; colunas++) {
            for (int linhas = 0; linhas < 20; linhas++) {
                System.out.print(mapaGerado[colunas][linhas] + " ");
            }
            System.out.println();
        }
    }


}
