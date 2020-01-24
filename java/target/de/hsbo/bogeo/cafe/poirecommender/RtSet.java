package de.hsbo.bogeo.cafe.poirecommender;

//-- { add_impl_begin }
import java.util.ArrayList;
//-- { add_impl_end }

/**
 * Representation of sort <tt>[ RtSet ]</tt>.<br/>
 * (Generated from the CafeOBJ module <tt>POI-Recommender</tt>.)
 */
public class RtSet 
{
// -- { add_impl_begin }
    static ArrayList<Rt> RtList = new ArrayList<Rt>();
//-- { add_impl_end }

	/**
	 * Representation of operation<br/>
	 * <br/>
	 * <tt>op Rt! : -> Rt</tt><br/>
	 * <br/>
	 * (from the module <tt>POI-Recommender</tt>).
	 */
// -- { add_impl_begin }
    static
// -- { add_impl_end }
	public RtSet Rt_all() { 
	    // TODO: Add operation implementation
// -- { add_impl_begin }
        return new RtSet();
/*
// -- { add_impl_end }

		return null;
// -- { add_impl_begin }
*/
// -- { add_impl_end }
	}
	
// -- { add_impl_begin }
	public void add(Rt r) {
		RtList.add(r);
//-- { add_impl_end }
	}
}
