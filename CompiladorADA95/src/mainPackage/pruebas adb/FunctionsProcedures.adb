procedure FunctionsProcedures is
	Function calcular(r:in out Integer) return Integer is
		unaVariable:Integer;
	begin
		unaVariable := 23;
		r := r*unaVariable;
		return r;
	end calcular;
	Procedure imprimirCadena(s: in String)is
		Procedure innerProc () is
		begin
			put("hola");
		end innerProc;
		Function innerFunc() return float is
		begin
			if(true) then
				return 3.0;
			end if;
			return 0;
		End innerFunc;
	begin
		put("la cadena es: ");
		put(s);
		innerProc();
	end imprimirCadena;
	calculo:Integer;
begin
	calculo := calcular(2);
	imprimirCadena("Hey");
	put(calculo);
	x:=1;
end FunctionsProcedures;