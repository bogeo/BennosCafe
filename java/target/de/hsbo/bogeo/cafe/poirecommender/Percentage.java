package de.hsbo.bogeo.cafe.poirecommender;

/**
 * Representation of sort <tt>[ Percentage ]</tt>.<br/>
 * (Generated from the CafeOBJ module <tt>POI-Recommender</tt>.)
 */
public class Percentage 
{
	/**
	 * Representation of operation<br/>
	 * <br/>
	 * <tt>op 100% : -> Percentage</tt><br/>
	 * <br/>
	 * (from the module <tt>POI-Recommender</tt>).
	 */
// -- { add_code_begin }
/*
// -- { add_code_end }
    public Percentage Percentage100() { 
	    // TODO: Add operation implementation

		return null;
	}	
// -- { add_code_begin }
*/

    static public Percentage Percentage100() { 
    	return new Percentage(100.); 
    }
	
	double val;
	public Percentage(double val) {
		this.val = val;
	}
	public String toString() {
		return "" + val;
	}
// -- { add_code_end }
}
