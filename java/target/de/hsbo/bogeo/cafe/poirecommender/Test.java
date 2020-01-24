// -- { add_impl_begin }
package de.hsbo.bogeo.cafe.poirecommender;

public class Test 
{
	public static void main(String[] args) {
		new Test().run();
	}
	
	private void run() 
	{
		int nL = 3;
		L[] l = new L[nL];
		for (int i = 0; i < nL; i++) l[i] = new L();
		    
		int nU = 3;
		U[] u = new U[nU];
		for (int i = 0; i < nU; i++) u[i] = new U();
		   
		RtSet rt = new RtSet();
		rt.add(Rt.rate(u[0], l[0], 0));
		rt.add(Rt.rate(u[0], l[1], 2));
		rt.add(Rt.rate(u[0], l[2], 2));
		rt.add(Rt.rate(u[1], l[0], 1));
		rt.add(Rt.rate(u[1], l[1], 2));
		rt.add(Rt.rate(u[1], l[2], 1));
		rt.add(Rt.rate(u[2], l[0], 0));
		rt.add(Rt.rate(u[2], l[1], 1));
		rt.add(Rt.rate(u[2], l[2], 3));
		   
		System.out.println("simU(u0, u1) = " + u[0].simU(u[1]));	    
		System.out.println("simU(u0, u2) = " + u[0].simU(u[2]));	    
		System.out.println("simU(u1, u2) = " + u[1].simU(u[2]));	    
		
		System.out.println("simL(l0, l1) = " + l[0].simL(l[1]));	    
		System.out.println("simL(l0, u2) = " + l[0].simL(l[2]));	    
		System.out.println("simL(l1, l2) = " + l[1].simL(l[2]));	    
	}
}
//-- { add_impl_end }
