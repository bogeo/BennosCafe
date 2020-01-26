// -- { add_impl_begin }
package de.hsbo.bogeo.cafe.poirecommender;

public class Test 
{
	public static void main(String[] args) {
		new Test().run();
	}
	
	private void run() 
	{
		U
			peter = new U(),
			paul = new U(),
			harry = new U();		
		L
			university = new L(),
			mining_museum = new L(),
			railway_museum = new L();
		MRate 
			minus = new MRate(MRate.Score.minus),
			o = new MRate(MRate.Score.o),
			plus = new MRate(MRate.Score.plus),
			plusplus = new MRate(MRate.Score.plusplus);
		
		RtSet rt = new RtSet();
		rt.add(Rt.rate(peter, university, minus));
		rt.add(Rt.rate(peter, mining_museum, plus));
		rt.add(Rt.rate(peter, railway_museum, plus));
		rt.add(Rt.rate(paul, university, o));
		rt.add(Rt.rate(paul, mining_museum, plus));
		rt.add(Rt.rate(paul, railway_museum, o));
		rt.add(Rt.rate(harry, university, minus));
		rt.add(Rt.rate(harry, mining_museum, o));
		rt.add(Rt.rate(harry, railway_museum, plusplus));
		   
		System.out.println("simU(peter, paul) = " + peter.simU(paul));	    
		System.out.println("simU(peter, harry) = " + peter.simU(harry));	    
		System.out.println("simU(paul, harry) = " + paul.simU(harry));	    
		
		System.out.println(
			"simL(university, mining_museum) = " + university.simL(mining_museum));	    
		System.out.println(
			"simL(university, railway_museum) = " + university.simL(railway_museum));	    
		System.out.println(
			"simL(mining_museum, railway_museum) = " + mining_museum.simL(railway_museum));	    

		L
			botanical_garden = new L(),
			zoo = new L(),
			planetarium = new L();
				
		// Training values:
		rt.add(Rt.rate(peter, botanical_garden, minus));
		rt.add(Rt.rate(peter, zoo, plus));
		rt.add(Rt.rate(peter, planetarium, plusplus));
		rt.add(Rt.rate(paul, botanical_garden, plus));
		rt.add(Rt.rate(paul, zoo, plusplus));
		rt.add(Rt.rate(paul, planetarium, plus));
		// Prediction:
		System.out.println("rho(peter, botanical_garden) = " + botanical_garden.rho(harry));
		System.out.println("rho(peter, zoo) = " + zoo.rho(harry));
		System.out.println("rho(peter, planetarium) = " + planetarium.rho(harry));
	}
}
//-- { add_impl_end }
