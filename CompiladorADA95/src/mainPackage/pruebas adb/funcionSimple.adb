procedure funcionesSimples is
	x,y,z:Integer;
	function multiplicar(n1,n2:Integer) return Integer is
		a,b:Integer;
	begin -- multiplicar
		a:= n1;
		b:= n2;
		return a * b;
	end multiplicar;
begin -- funcionesSimples
	put("Ingrese n1: ");
	get(x);
	put("Ingrese n2: ");
	get(y);
	z:=multiplicar(x,y);
	-- x:=multiplicar(2 , 4);
	-- y:=multiplicar(2 * 3 , 6 / 4);
	-- z:=multiplicar(z , multiplicar(x,y));
	put("Resultado: ");
	put(z);
end funcionesSimples;