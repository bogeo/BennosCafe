package de.hsbo.bogeo.cafe.poirecommender;

/**
 * Representation of sort <tt>[ M ]</tt>.<br/>
 * (Generated from the CafeOBJ module <tt>POI-Recommender</tt>.)
 */
public class MRate 
{
// -- { add_impl_begin }
	public enum Score { minus, o, plus, plusplus };
	private Score score;
	MRate(Score score) { this.score = score; }
	public int asInt() { return this.score.ordinal(); }
// -- { add_impl_end }	
}
