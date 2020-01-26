package de.hsbo.bogeo.cafe.poirecommender;

//-- { add_code_begin }
import java.util.ArrayList;
//-- { add_code_end }

/**
 * Representation of sort <tt>[ U ]</tt>.<br/> 
 * (Generated from the CafeOBJ module <tt>POI-Recommender</tt>.)
 */
public class U 
{
	/**
	 * Representation of operation<br/>
	 * <br/>
	 * <tt>pred _in_ : U USet</tt><br/>
	 * <br/>
	 * (from the module <tt>POI-Recommender</tt>).
	 */
	public Boolean geom(USet param1) { 
		// TODO: Add operation implementation
		
		return null;
	}

	/**
	 * Representation of operation<br/>
	 * <br/>
	 * <tt>op S(_) : U -> LSet</tt><br/>
	 * <br/>
	 * (from the module <tt>POI-Recommender</tt>).
	 */
	public LSet S() { 
		// TODO: Add operation implementation
		
		return null;
	}

	/**
	 * Representation of operation<br/>
	 * <br/>
	 * <tt>pred _visited_ : U L</tt><br/>
	 * <br/>
	 * (from the module <tt>POI-Recommender</tt>).
	 */
	public Boolean visited(L param1) { 
		// TODO: Add operation implementation
		
		return null;
	}
	
	/**
	 * Representation of operation<br/>
	 * <br/>
	 * <tt>op R(_) : U -> LSet</tt><br/>
	 * <br/>
	 * (from the module <tt>POI-Recommender</tt>).
	 */
	public LSet R() { 
		// TODO: Add operation implementation
		
		return null;
	}
		
	/**
	 * Representation of operation<br/>
	 * <br/>
	 * <tt>op top-n(_) : Nat U -> LSet</tt><br/>
	 * <br/>
	 * (from the module <tt>POI-Recommender</tt>).
	 */
	public LSet topN(Nat param1) { 
		// TODO: Add operation implementation
		
		return null;
	}
	
	/**
	 * Representation of operation<br/>
	 * <br/>
	 * <tt>simU : U U -> Percentage  { comm }</tt><br/>
	 * <br/>
	 * (from the module <tt>POI-Recommender</tt>).<br/>
     * <br/> 
     * <b>Hint:</b> This method shall be commutative!
	 */
	public Percentage simU(U param1) { 
	    // TODO: Add operation implementation

// -- { add_code_begin }
		@SuppressWarnings("static-access")
		ArrayList<Rt> rt_all = RtSet.Rt_all().RtList;
		ArrayList<L> corated = new ArrayList<L>();		
		for (Rt rt : rt_all) {
			if (rt.l.has_been_rated_by(this) && rt.l.has_been_rated_by(param1)) {
				if (!corated.contains(rt.l))
					corated.add(rt.l);
			}
		}
		double 
			sij = 0., 
			sqi = 0., 
			sqj = 0.,
			ri, rj;
		for (L l : corated) {
			ri = (double) l.r(this).asInt();
			rj = (double) l.r(param1).asInt();
			sij += (ri * rj);
			sqi += (ri * ri);
			sqj += (rj * rj);
		}
		return new Percentage(sij / Math.sqrt(sqi * sqj));
/*
// -- { add_code_end }
		return null;
// -- { add_code_begin }
*/
// -- { add_code_end }
	}
	
	/**
	 * Representation of operation<br/>
	 * <br/>
	 * <tt>simC : U U -> Percentage  { comm }</tt><br/>
	 * <br/>
	 * (from the module <tt>POI-Recommender</tt>).<br/>
     * <br/> 
     * <b>Hint:</b> This method shall be commutative!
	 */
	public Percentage simC(U param1) { 
		// TODO: Add commutative operation implementation
		
		return null;
	}
}
