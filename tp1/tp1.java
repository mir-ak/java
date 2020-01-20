//exo1 
public class tp1 { 

	public static void main( String[] args) {
	int a , b , c ;		
		 a = 6 ; 
		 b = 7 ; 
		 c = 4 ;
	        c = (a & b) ; 
	System.out.println ("a=="+a+"b=="+b+"c=="+c);
	 boolean a1 = true ; 
	 b = 5 ;
	 c = 3 ;
	 b = ((!a1) ? (b*=c):(c *= b)); 
	System.out.println ("a=="+a1+"b=="+b+"c=="+c);
	a = 5 ; b = 2 ; c = 3 ; 	
	b = ((b|c) != ++a ? 5 : 1); 
	System.out.println ("a=="+a+"b=="+b+"c=="+c);
	a = 0 ; b = 1 ; c = 2 ; 
	a = (a++) * ((++b) * (c++)) ; 
	System.out.println ("a=="+a+"b=="+b+"c=="+c);
	a = 0 ; b = 1 ;c = 2; 
	a = (++a) * ((++b) * (c++)) ;
	System.out.println ("a=="+a+"b=="+b+"c=="+c);
	boolean b1 = true ;
	a = 8 ; c = 4 ;  
	b1 = (false||((c *= 2)>0));
	System.out.println ("a=="+a+"b=="+b1+"c=="+c);
	boolean b2 = false ; 	
	a = 8 ; c = 4 ;  	 
	b2 = (true||((c *= 2)>0));
	System.out.println ("a=="+a+"b=="+b2+"c=="+c);
//exo 2 
	System.out.println("integer max = "+Integer.MAX_VALUE);
	System.out.println("Short max = :"+Short.MAX_VALUE);
	System.out.println("Byte max = "+Byte.MAX_VALUE);
	System.out.println("float max = "+Float.MAX_VALUE);
	System.out.println("double max = :"+Double.MAX_VALUE);
	System.out.println("long max = "+Long.MAX_VALUE);
	System.out.println("integer min = "+Integer.MIN_VALUE);
	System.out.println("Short min = "+Short.MIN_VALUE);
	System.out.println("Byte min = "+Byte.MIN_VALUE);
	System.out.println("float min = "+Float.MIN_VALUE);
	System.out.println("double min = :"+Long.MIN_VALUE);
	System.out.println("long min = "+Double.MIN_VALUE);

//exo 3 
	int i1 = 1000000000;
	int i2 = 2 * i1 ; 
	int i3 = 3 * i1 ; 
	int i4 = Integer.MAX_VALUE;
	System.out.println("i1 = "+i1);
	System.out.println("i2 = "+i2);
	System.out.println("i3 = "+i3);
	System.out.println("i4 = "+i4);
/* la valeur i1 reste la meme et la valeur 2 augment 2* celle de i1 par contre la valeur i3 negative parceque on dépassé la valeur max des entier parceque la valeur max c'est i4 = 2147483647*/
//exo 4 


  
						}
		}
