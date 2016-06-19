procedure pruebaPut is
      entero:Integer;
      fl:Float;
      procedure imprimir(a:Integer) is
      begin
         put("Hola");
         put("Adios");
         put("Hola");
         put(9.12);
         put(89);
         put(entero);
         put(fl);
         put(45 * 2);
         put(45.4 * 7.1);
         put(a);
      end imprimir;
begin
   entero:=8;
   fl:=4.4;
   imprimir(8);
end pruebaPut;