procedure pruebaSuma is
   	a,b,c,n,cont,max,min: Integer;
begin
      min:=100;
      put("Cantidad de alumnos: ");
      get(n);
      while (cont<n) loop
      	put("Ingrese nota 1: ");
         get(a);
         put("Ingrese nota 2: ");
         get(b);
         c:=(a + b)/2;
         put("Promedio del alumno No.");
         put(cont);
         put(" es: ");
         put(c);
         put(" ");
         cont:=cont+1;
         if (c>max) then
            max:=c;
         end if;
         if (c<min) then
            min:=c;
         end if;
      end loop;
      put("La nota mas alta es: ");
      put(max);
      put("La nota mas baja es: ");
      put(min);
end pruebaSuma;