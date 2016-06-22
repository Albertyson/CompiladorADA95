procedure pruebaFor is
   a,b,c,i: Integer;
begin
   a:=2;
   b:=3;
	for i in 1 .. 10 loop
      c:=i*a;
      b:=i*b;
      if(c>b) then
         c:=c/2;
      else
         b:=b-2;
      end if;
      put("a= ");
      put(a);
      put("b= ");
      put(b);
      put("c= ");
      put(c);
      exit when a>b;
         
   end loop;
end pruebaFor;