procedure pruebaWhile is
   a,b,c,i: Integer;
begin
   a:=2;
   b:=10;
	while a<b  and a < 100 loop
      a:=a*b-1;
      exit when a= b*7;
      b:=b+1;
   end loop;
end pruebaWhile;