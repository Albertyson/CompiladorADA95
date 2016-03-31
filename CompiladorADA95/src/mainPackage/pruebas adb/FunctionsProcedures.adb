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
end FunctionsProcedures;