procedure funcionesSimples is
	x,y,z:Integer;
	function multiplicar(n1,n2:Integer) return Integer is
	begin -- multiplicar
		return n1 * n2;
	end multiplicar;
begin -- funcionesSimples
	put("Ingrese n1: ");
	get(x);
	put("Ingrese n2: ");
	get(y);
	z:=multiplicar(x,y);
	put("Resultado: ");
	put(z);
end funcionesSimples;