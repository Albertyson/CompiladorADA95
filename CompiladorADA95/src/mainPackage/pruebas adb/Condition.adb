--with Ada.Text_IO, Ada.Integer_Text_IO, Ada.Exceptions, System.Assertions;
--use Ada;
procedure Condition is
   n1,n2,n3,n4: Integer;
   promedio: float;
begin
    get(n1);
    get(n2);
    get(n3);
    get(n4);
    promedio := (n1+n2+n3+n4) / 4 ;
    if(promedio < 40) then
    	put("promedio insuficiente: ");
    else if(promedio >= 40 and promedio <= 59) then 
    	put("promedio reprobado: "); end
    elsif(promedio >= 60 and promedio <= 79) then
    	put("promedio aprobado bueno: ");
    elsif(promedio >= 80 and promedio <= 90) then
    	put("promedio aprobado muy bueno: ");
    elsif(promedio <= 100) then
    	put("promedio aprobado excelente: ");
    else
    	put("promedio fuera de rango: ");
    end if;
    put(promedio);
end Condition;