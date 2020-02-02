-- ----------------------------------------------------------------------------
-- Description of the POI Recommendation Problem 
-- Encoding for CafeOBJ version 1.5.8
-- Geovisualization Lab, Bochum University of Applied Sciences

module POI-Recommender 
{  
  protecting (NAT)

  -- Sorts:
  [ 
    L             -- POIs
    LSet          -- POI sets  
    LSetSet       -- Set of POI sets 
    U             -- Users
    USet          -- User sets
    Rt            -- Ratings
    RtSet         -- Rating sets
    M             -- Rating scales  
      < M',       -- Superset used for predictions
    Geom          -- Geometric objects
    Dist          -- Spatial distances, eg non-negative real numbers 
    Real2         -- Geographical 2D positions
    Nat           -- Natural numbers
    Percentage    -- Real numbers in the range from 0 to 100
    RhoFunc       -- POI evaluation functions
    RtProbl       -- Recommendation-problem tuples
  ]
  
  -- A POI refers to a geographical position, e.g. a lat/lon pair. 
  signature {
    op pos : L -> Real2          

    -- Principally, POI geometry (e.g., a point or polygon) and position  
    -- could be modeled separately, e.g.: 
    op geom : L -> Geom
    op centroid : Geom -> Real2
  }

  -- L! and U! give the sets of all POIs and all users managed by the system.
  signature {
    op L! : -> LSet    
    op U! : -> USet                  
    pred _in_ : L LSet  
    pred _in_ : U USet  
	
    -- Helpers:
    op #_ : LSet -> Nat         -- cardinality (number of set elements)
    op _-_ : LSet LSet -> LSet  -- difference set
    op _+_ : LSet LSet -> LSet  -- union set
  }
  vars l l' : L .  vars u u' : U .
  vars L L' : LSet .
  axioms {
    eq l in L! = true .         
    eq u in U! = true .
	
    ceq l in (L - L') = true  if (l in L) and not(l in L') .
    ceq l in (L - L') = false if not(l in L) or (l in L') .
    ceq l in (L + L') = true  if (l in L) or (l in L') .
    ceq l in (L + L') = false if not(l in L) and not(l in L') .
  }
  
  -- Set of POIs visited by the user u ("check-in sequence")
  signature {
    op S(_) : U -> LSet  
    pred _visited_ : U L  -- "check-in" predicate 
  }
  axioms {
    eq l in S(u) = u visited l .
  }

  -- Rating functions 
  signature {
    op Rt! : -> RtSet  -- set of all ratings in the system
    op rate : U L M -> Rt  { constr }
    pred _has been rated by_ : L U
    op r : L U -> M        
    ops rho rho+ : L U -> M'
    -- Order declarations:	
    pred _<_ : M' M'  
    pred _<_for_ : L L U
	-- Operations to check postulated properties:
	preds comparable asymmetric : M' M' 
	-- Workarounds to document transitiveness:
	pred _<_via_ : M' M' M'  
	pred _<_via_ : L L L  
  }
  vars v v' vv : M' .
  axioms {
    -- Irreflexivity of < on M':
    ceq v < v' = false if v = v' .  
    -- Asymmetry of < on M', shall never evaluate to false!
    ceq asymmetric(v, v') = true   
      if (v < v' and not(v' < v)) or (not(v < v') and v' < v) .
    ceq asymmetric(v, v') = false if v < v' and v' < v .
    -- Transitivity of < on M', just documented here...
    ceq v < v' via vv = true if v < vv and vv < v' .
    -- Trichotomity of < on M', shall always evaluate to true!
    ceq comparable(v, v') = true if v < v' or v' < v .
  
    eq l < l' for u = 
      rho+(l, u) < rho+(l', u) . 
  
    -- Facade:	
    ceq rho+(l, u) = rho(l, u) if l has been rated by u  .
    ceq rho+(l, u) = r(l, u) if not (l has been rated by u) .
  }
  
  -- POI recommendation, i.e. recommendable POIs
  signature {
    op R(_) : U -> LSet
    pred _~_ : LSet LSet  { comm }
    pred _~_via_ : LSet LSet LSet  -- workaround to document transitiveness
  }
  vars r r' vr : LSet .
  axioms {
    eq l in R(u) = not(l in S(u)) .  
    -- I.e., recommended POIs may not have been visited by the user.
  
    ceq r ~ r' = true if r = r' .  -- reflexivity 
    ceq r ~ r' via vr = true if r ~ vr and vr ~ r' .  -- transitivity 
  }
                             
  -- Top-n recommendation
  signature {
    op R_(_) : Nat U -> LSet  -- { bind: 2 }       
    -- Check, if a POI violates top-n recommendation criterion:
    pred check_against_ _ _in_ : L L U LSet LSet

    op [_] : LSet -> LSet  -- representative of underlying equivalence class
  }
  var n : Nat .  var l* : L .  vars Su Rn : LSet .  
  axioms {
    ceq check l against l* u Su in Rn = false 
      if l in (L! - (Rn + Su)) and rho+(l*, u) < rho+(l, u) .

    ceq #[R n (u)] = n 
      if #(L! - S(u)) > n .
    ceq #[R n (u)] = #(L! - S(u)) 
      if #(L! - S(u)) <= n .
  }

  -- Recommendation problem tuple (here just the signature is given):
  signature {
    op problem : USet LSet LSetSet RhoFunc -> RtProbl  { constr } 
  }
  
  -- Similarity measures:
  signature {
    op simL : L L -> Percentage  { comm }
    ops simU simC : U U -> Percentage  { comm }
    ops 0% 100% : -> Percentage
    preds (_<_) (_>_) : Percentage Percentage
    op _gives simL(_,_) : U L L -> Percentage   -- { bind: 1 }
    op _gives simU(_,_) : L U U -> Percentage   -- { bind: 1 }
    op _gives simC(_,_) : L U U -> Percentage   -- { bind: 1 } 
  }
  axioms {
    ceq simL(l, l') = 100% if l = l' .
    ceq simU(u, u') = 100% if u = u' .
    ceq simC(u, u') = 100% if u = u' .
    ceq u gives simL(l, l') > 0%   = true 
      if l =/= l' and r(l, u) = r(l', u).
    ceq u gives simL(l, l') < 100% = true 
      if l =/= l' and r(l, u) =/= r(l', u) and l has been rated by u and l' has been rated by u .
    ceq l gives simU(u, u') > 0%   = true 
      if u =/= u' and r(l, u) == r(l, u') .
    ceq l gives simU(u, u') < 100% = true 
      if u =/= u' and r(l, u) =/= r(l, u') and l has been rated by u and l has been rated by u' .
    ceq l gives simC(u, u') > 0%   = true 
      if u =/= u' and l in S(u) and l in S(u') .
    ceq l gives simC(u, u') < 100% = true 
      if u =/= u' and l in S(u) and not(l in S(u')) .
    ceq l gives simC(u, u') < 100% = true 
      if l gives simC(u', u) < 100% = true .  -- Commutativity of u and u'
  }
  
  -- Spatial distances (quasimetric):
  signature {
    op d : L L -> Dist   -- { bind: 2 }
      -- d is non-commutative 
    op 0 : -> Dist
    pred _<=_ : Dist Dist
	
    -- A "loose" distance algebra:
    op _[+]_ : Dist Dist -> Dist  { id: 0 }
    -- "Tighter" monoidal model as alternative:
    op _+_ : Dist Dist -> Dist  { assoc id: 0 }
  }
  vars a b c c' : L .
  axioms {
    ceq d(a, b) = 0 if a = b .
    eq 0 <= d(a, b) = true .
    ceq d(a, b) <= d(a, c) [+] d(c', b) = true 
      if c = c' .
    ceq d(a, b) <= d(a, c) + d(c', b) = true 
      if c = c' .
  }
}
