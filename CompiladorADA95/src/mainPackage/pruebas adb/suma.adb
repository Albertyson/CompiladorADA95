procedure pruebaSuma is
   	a,b,c: Integer;
begin
   	--test := 0;
   	b:= 2 + 3;
   	a:= (b - 3 * 2) / 3 - 5;
   	c:= 4;
   	if(a>c) then
   		c:= 8;
   	elsif(a<c) then
   		c:= 5;
   	elsif(a=2) then
   		c:=4;
   	else
   		c:=2;
   	end if;
   	-- a:= 3;
end pruebaSuma;