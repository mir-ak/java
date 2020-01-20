public class Segment {
	
	 Point start ; 
	 Point stop ;
//constructeur 
	public Segment(Point x , Point y ) {
	 this.start = x ; 
	 this.stop = y ; 
	}
	public Segment(int a , int b ,int c, int d ){
	this.start=new Point (a,b);
	this.stop=new Point (c,d);
	}
//getters 
	public Point getStart () {return this.start;}
	public Point getStop () {return this.stop;}
//setters 
	public void setStart (Point s){this.start=s;}
	public void setStop (Point s){this.stop=s;} 
	/*public String ToString () {
		return (start.tostring()+"\n"+stop.tostring());
							}*/      

public static void main(String[] args){
	
	Point p = new Point(1,5);
	Point p2 = new Point(4,2); 
	Segment s1 = new Segment(p,p2);
	Segment s2 = new Segment(4,2,3,4);
	System.out.println("mes point " +p.x+","+p2.y);
	System.out.println("mon s1 " +s1.start.x+","+s1.start.y+","+s1.stop.x+","+s1.stop.y);
}}
