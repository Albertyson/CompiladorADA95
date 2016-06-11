procedure pruebaLoop is
   a,b,c,i: Integer;
begin
   a:=2;
   b:=10;
   loop
   		b:=b-2;
   		c:=a*b;
   		b:=a+c;
   		exit when b<a or b>c;   			
   end loop;
end pruebaLoop;