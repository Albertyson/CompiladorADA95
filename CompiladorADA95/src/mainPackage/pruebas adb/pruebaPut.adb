procedure pruebaPut is
      entero:Integer;
      procedure imprimir(a:Integer) is
      begin
         put("Hola");
         put("Adios");
         put("Hola");
         put(89);
         put(entero);
         put(45 * 2);
         put(a);
      end imprimir;
begin
   entero:=8;
   imprimir(8);
end pruebaPut;