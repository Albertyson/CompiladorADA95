procedure funcionesRaras is
	a,b,c:Boolean;
	r,q:Integer;
	function f(x:Boolean;y:Integer;z:Integer) return Integer is
	Begin
		return 4;
	End f;
	function f2(t:Integer;s:Integer) return Integer is
	Begin
		return t+s;
	End f2;
	function f3(t:Boolean;s:Integer) return Integer is
	Begin
		if(t=true)then return 1; end if;
		return 3;
	End f3;
Begin
	a := true;
	c := false;
	b := false;
	q := f(b , 3 + 5, f2(9,r));
end funcionesRaras;