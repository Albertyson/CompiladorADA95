--with Ada.Text_IO, Ada.Integer_Text_IO, Ada.Exceptions, System.Assertions;
--use Ada;
procedure Condition is
   n1,n2,n3,n4: float;
   promedio: float;
begin
    get(n1);
    get(n2);
    get(n3);
    get(n4);
    promedio := (n1+n2+n3+n4) / 4.0 ;
    if(promedio < 40.0) then
    	put("promedio insuficiente: ");
    elsif(promedio >= 40.0 and promedio <= 59.0) then 
    	put("promedio reprobado: ");
    elsif(promedio >= 60.0 and promedio <= 79.0) then
    	put("promedio aprobado bueno: ");
    elsif(promedio >= 80.0 and promedio <= 90.0) then
    	put("promedio aprobado muy bueno: ");
    elsif(promedio <= 100.0) then
    	put("promedio aprobado excelente: ");
    else
    	put("promedio fuera de rango: ");
    end if;
    put(promedio);
end Condition;