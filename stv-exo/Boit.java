public class Boit {
 	Ballon liste [] ; 
	public 	Boit(int nbr){
		liste = new Ballon[nbr];
		for(int i = 0 ; i < nbr ; i++)
	 		liste[i] = new Ballon('r',8);
				}
		public Boit(Ballon[] list){
			liste = list ; 
									}
public String toString(){
	String s = "";
	for(int i = 0; i < liste.length ; i++){
			s+= liste[i].toString();
			s+= "\n";
										  }
	return s ;
					}
				}
	
