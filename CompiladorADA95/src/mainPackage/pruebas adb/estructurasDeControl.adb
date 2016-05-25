procedure EstructurasDeControl is
	limiteFor : Integer;
	inicioWhile:Integer;
	limiteWhile : Integer;
	limiteLoop : Integer;
	i: Integer;
begin
	limiteFor := 10;
	inicioWhile := 0;
	limiteWhile := 15;
	limiteLoop := 30;
	for i in 1 .. limiteFor loop
		if ( i > 4) then 
			put("es mayor a 4");
		else
			put("es menor o igual a 4");
		end if;
	end loop;
	while inicioWhile<limiteWhile loop
		inicioWhile:= inicioWhile + 2;
		put("Dentro de while");
		put(inicioWhile);
	end loop;
	loop
		exit when (inicioWhile < limiteLoop) ;
		put("dentro de loop");
		inicioWhile:= inicioWhile + 3;
		loop
			exit when true;
		end loop;
		exit when true;
	end loop;

end EstructurasDeControl ;