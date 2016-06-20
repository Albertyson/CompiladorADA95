procedure pruebaSuma is
      a,b,c: Integer;
      function sumar( n1,n2: Integer; z:Boolean) return Integer is
      begin
         if (n1>n2) then         
            return n1 + n2;
         elsif(n2=n1) then
            return n2 + n1 + 1;
         end if;
         return n1+n2 + 2;
      end sumar;
      procedure imprimirHola() is
      begin
         put("Hola");
         put("Adios");
         put("Hola");
         put(89);
         put(b);
         put(5 + 8);
      end imprimirHola;
begin
      --test := 0;
      --b:= sumar(2, 5,true)+1;
      a:= (b + 3 + 2) + 3 + 5;
      c:= 4 + 1;
      c:= a;
      if(a>c) then
         c:= 8;
      elsif(a<c) then
         c:= 5;
      elsif(a=2) then
         c:=4;
      else
         c:=2;
      end if;
      imprimirHola();
      -- a:= 3;
end pruebaSuma;