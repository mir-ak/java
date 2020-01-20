public  class Matrice {
	private  int nbLignes ;
	private  int nbCol ;
	private  int[][] coefficients ;
	public Matrice  (){}
	public Matrice  ( int nbL , int nbC)
	{
	this.nbLignes = nbL;
	this.nbCol = nbC ;
	this.coefficients=new int [nbL][nbC];
	} 
	public Matrice  (int[][] coef )
	{
	nbLignes = coef[0].length  ;
	nbCol = coef.length;
	coefficients = new int [nbCol][nbLignes]; 
	for (int i = 0;i < nbCol; i++) {
         for (int j = 0;j < nbLignes;j++) {
            coefficients[i][j] = coef[i][j];
	}
	}
	} 
/*
	public  int getNbLignes  (){
	//A vous  de  jouer
	}
	public  int getNbCol  ()
	{
	//A vous  de  jouer
	}
	public  void setNbLignes  ( int nbL)
	{
	//A vous  de  jouer
	}
	public  void setNbCol  ( int nbC)
	{
	//A vous  de  jouer
	}
	}*/
public String toString(){
	String t = "";
	for(int i = 0 ; i < nbCol ; i++){
		for(int j=0; j< nbLignes ; j++){
		t += coefficients[i][j];
		t+=",";
									} 
	t+="\n"	;
	}
	return t;
}
public static void main(String[] args){
	int[][] t = new int [3][3];
	Matrice k = new Matrice(t);

	System.out.println(k);
	}
	}
