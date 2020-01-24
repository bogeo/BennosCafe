package de.hsbo.bogeo.cafe.poirecommender;

//-- { add_impl_begin }
import java.util.ArrayList;
//-- { add_impl_end }

/**
 * Representation of sort <tt>[ L ]</tt>.<br/> 
 * (Generated from the CafeOBJ module <tt>POI-Recommender</tt>.)
 */
public class L 
{
	/**
	 * Representation of operation<br/>
	 * <br/>
	 * <tt>op pos : L -> Real2</tt><br/>
	 * <br/>
	 * (from the module <tt>POI-Recommender</tt>).
	 */
	public Real2 pos() { 
		// TODO: Add operation implementation
		
		return null;
	}

	/**
	 * Representation of operation<br/>
	 * <br/>
	 * <tt>op geom : L -> Geom</tt><br/>
	 * <br/>
	 * (from the module <tt>POI-Recommender</tt>).
	 */
	public Geom geom() { 
		// TODO: Add operation implementation
		
		return null;
	}
	
	/**
	 * Representation of operation<br/>
	 * <br/>
	 * <tt>pred _in_ : L LSet</tt><br/>
	 * <br/>
	 * (from the module <tt>POI-Recommender</tt>).
	 */
	public Boolean in(LSet param1) { 
		// TODO: Add operation implementation
		
		return null;
	}
	
	/**
	 * Representation of operation<br/>
	 * <br/>
	 * <tt>pred _has been rated by_ : L U</tt><br/>
	 * <br/>
	 * (from the module <tt>POI-Recommender</tt>).
	 */
	public Boolean has_been_rated_by(U param1) { 
// -- { add_impl_begin }
		for (Rt rt : rtList ) {
			if (rt.u == param1) return true;
		}
		return false;
/*
// -- { add_impl_end }
		// TODO: Add operation implementation
		
		return null;
// -- { add_impl_begin }
*/
// -- { add_impl_end }
	}
	
	/**
	 * Representation of operation<br/>
	 * <br/>
	 * <tt>op rho : L U -> Nat</tt><br/>
	 * <br/>
	 * (from the module <tt>POI-Recommender</tt>).
	 */
	public Nat rho(U param1) { 
// -- { add_impl_begin }
		for (Rt rt : rtList ) {
			if (rt.u == param1) return rt.rate;
		}
// -- { add_impl_end }
		// TODO: Add operation implementation
		
		return null;
	}
	
	/**
	 * Representation of operation<br/>
	 * <br/>
	 * <tt>op rho+ : L U -> Nat</tt><br/>
	 * <br/>
	 * (from the module <tt>POI-Recommender</tt>).
	 */
	public Nat rho_plus(U param1) { 
// -- { add_impl_begin }
		@SuppressWarnings("static-access")
		ArrayList<Rt> rt_all = RtSet.Rt_all().RtList;
		ArrayList<U> u_ratings = new ArrayList<U>();		
		for (Rt rt : rt_all) {
			if (rt.l == this && !u_ratings.contains(rt.u)) 
				u_ratings.add(rt.u);
		}
		double s1 = 0., s2 = 0.;
		for (U u : u_ratings) {
			Nat x = this.rho(u);
			if (x != null) {
				Double 
					simU = param1.simU(u).val,
					rho = (double) x.val;
				if (!simU.isNaN()) {
					s1 += simU * rho;
					s2 += Math.abs(simU);
				}
			}
		}
		return new Nat((int) Math.round(s1 / s2));
/*
// -- { add_impl_end }
		// TODO: Add operation implementation
		
		return null;
// -- { add_impl_begin }
 */
// -- { add_impl_end }
	}
	
	/**
	 * Representation of operation<br/>
	 * <br/>
	 * <tt>op rho' : L U -> Nat</tt><br/>
	 * <br/>
	 * (from the module <tt>POI-Recommender</tt>).
	 */
	public Nat rho_wrap(U param1) { 
		// TODO: Add operation implementation
		
		return null;
	}
	
	/**
	 * Representation of operation<br/>
	 * <br/>
	 * <tt>pred _<_for_ : L L U</tt><br/>
	 * <br/>
	 * (from the module <tt>POI-Recommender</tt>).
	 */
	public Boolean less_than(L param1, U param2) { 
		// TODO: Add operation implementation
		
		return null;
	}

	/**
	 * Representation of operation<br/>
	 * <br/>
	 * <tt>pred check_against_ _ _in_ : L L U LSet LSet</tt><br/>
	 * <br/>
	 * (from the module <tt>POI-Recommender</tt>).
	 */
	public Boolean check_against_in(L param1, U param2) { 
		// TODO: Add operation implementation
		
		return null;
	}
	
	/**
	 * Representation of operation<br/>
	 * <br/>
	 * <tt>op simL : L L -> Percentage  { comm }</tt><br/>
	 * <br/>
	 * (from the module <tt>POI-Recommender</tt>).<br/>
     * <br/> 
     * <b>Hint:</b> This method shall be commutative!
	 */
	public Percentage simL(L param1) { 
		// TODO: Add operation implementation

// -- { add_code_begin }
		@SuppressWarnings("static-access")
		ArrayList<Rt> rt_all = RtSet.Rt_all().RtList;
		ArrayList<U> corated = new ArrayList<U>();		
		for (Rt rt : rt_all) {
			if (this.has_been_rated_by(rt.u) && param1.has_been_rated_by(rt.u)) {
				if (!corated.contains(rt.u)) 
					corated.add(rt.u);
			}
		}
		double 
			sij = 0., 
			sqi = 0., 
			sqj = 0.,
			rho_i, rho_j;
		for (U u : corated) {
			rho_i = (double) this.rho(u).val;
			rho_j = (double) param1.rho(u).val;
			sij += (rho_i * rho_j);
			sqi += (rho_i * rho_i);
			sqj += (rho_j * rho_j);
		}
		return new Percentage(sij / Math.sqrt(sqi * sqj));
/*
// -- { add_code_end }
		return null;
// -- { add_code_begin }
*/
// -- { add_code_end }
	}

// -- { add_impl_begin }
	ArrayList<Rt> rtList = new ArrayList<Rt>();
	public void addRt(Rt rt) {
		rtList.add(rt);
	}
// -- { add_impl_end }
}
