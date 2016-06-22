procedure logicasBooleanas is
	a,b:Boolean;
	c,d:Integer;
begin -- logicasBooleanas
	c:= 4;
	d:= 7;
	a:= a or b;
	b:= b and a or b;
	if a or b then
		c:= 8;
	end if;
end logicasBooleanas;