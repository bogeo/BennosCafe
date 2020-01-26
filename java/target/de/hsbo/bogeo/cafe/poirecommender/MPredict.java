package de.hsbo.bogeo.cafe.poirecommender;

/**
 * Representation of sort <tt>[ M' ]</tt>.<br/>
 * <br/>
 * <tt>[ M < M' ]</tt><br/>
 * <br/>
 * (Generated from the CafeOBJ module <tt>POI-Recommender</tt>.)
 */
public class MPredict extends MRate
{
	/**
	 * Representation of operation<br/>
	 * <br/>
	 * <tt>pred _<_ : M' M'</tt><br/>
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
	 * <tt>comparable : M' M'</tt><br/>
	 * <br/>
	 * (from the module <tt>POI-Recommender</tt>).
	 */
	public Boolean comparable(L param1, U param2) { 
		// TODO: Add operation implementation
		
		return null;
	}

	/**
	 * Representation of operation<br/>
	 * <br/>
	 * <tt>asymmetric : M' M'</tt><br/>
	 * <br/>
	 * (from the module <tt>POI-Recommender</tt>).
	 */
	public Boolean asymmetric(L param1, U param2) { 
		// TODO: Add operation implementation
		
		return null;
	}

// -- { add_impl_begin }
	private double score;
	MPredict(double score) { super(null); this.score = score; }
	public double asDouble() { return this.score; }
	public String toString() { return "" + Math.round(score * 100.) / 100.; }
// -- { add_impl_end }		
}
