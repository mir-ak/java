public class Main {
	public static void main(String[] args){
		Boit B1,B2 ;
		int val = 4 ;
		B1= new Boit(8);
		System.out.println("ma boit CONS1 "+B1.toString());
		Ballon l [] ; 
		l= new Ballon[val];
		for(int i = 0 ; i < val ; i++){
			l[i] = new Ballon('b',i);
									}
		B2= new Boit(l);
		System.out.println("ma boit CONS2 "+B2.toString());
											}

						}
