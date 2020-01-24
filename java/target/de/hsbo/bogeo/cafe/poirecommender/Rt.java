package de.hsbo.bogeo.cafe.poirecommender;

/**
 * Representation of sort <tt>[ Rt ]</tt>.<br/> 
 * (Generated from the CafeOBJ module <tt>POI-Recommender</tt>.)
 */
public class Rt 
{
// -- { add_impl_begin }
	U u;
	L l;
	Nat rate; 
//-- { add_impl_end }

    /**
     * Representation of constructor operation<br/>
     * <br/>
     * <tt>op rate : U L Nat -> Rt 	{ constr }</tt><br/>
     * <br/>
     * (from the module <tt>@{module_name}</tt>).
     */
    static public Rt rate(U param1, L param2, Nat param3) { 
		Rt obj = null;
		// TODO: obj = new Rt(param1, param2, param3); 
// -- { add_impl_begin }
		obj = new Rt(param1, param2, param3); 
// -- { add_impl_end }
		return obj;
	}
    
// -- { add_impl_begin }
	private Rt(U param1, L param2, Nat param3) { 
		u = param1;
		l = param2;
		rate = param3; 
		l.addRt(this);
	}
	
	static public Rt rate(U u, L l, int val) { 
		return Rt.rate(u, l, new Nat(val));
	}
	
	public String toString() {
		return "[u: " + u + ", l: " + l + ", rate: " + rate + "]";
	}
// -- { add_impl_end }
}
